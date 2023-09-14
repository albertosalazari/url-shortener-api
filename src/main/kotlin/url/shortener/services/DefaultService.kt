package url.shortener.services

import url.shortener.domain.UrlEntity
import url.shortener.repository.UrlRepository
import jakarta.inject.Inject
import jakarta.transaction.Transactional
import jakarta.ws.rs.core.Response
import url.shortener.utils.Params
import java.net.URI

@Inject
private var repository = UrlRepository()

@Transactional
class DefaultService {
    fun redirect(shortUrl: String): Response {
        val originalUrl: String = repository.run {
            find(Params.SHORT_URL, shortUrl).firstResult<UrlEntity?>()?.originalUrl ?: ""
        }

        return if (originalUrl.isNotBlank())
            Response.seeOther(URI.create(originalUrl)).build()
        else
            Response.status(Response.Status.NOT_FOUND).build()
    }
}