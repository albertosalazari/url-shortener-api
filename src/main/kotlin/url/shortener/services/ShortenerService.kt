package url.shortener.services

import url.shortener.domain.UrlEntity
import url.shortener.domain.UrlRequest
import url.shortener.domain.UrlResponse
import url.shortener.repository.UrlRepository
import url.shortener.utils.ShortenerUtility
import jakarta.inject.Inject
import jakarta.transaction.Transactional
import jakarta.ws.rs.core.Response

@Inject
private var repository = UrlRepository()

@Transactional
class ShortenerService {
    fun create(request: UrlRequest): UrlResponse {
        val entity = UrlEntity()
        val shortUrl: String

        if(!request.customUrl.isNullOrBlank()) {
            shortUrl =  request.customUrl.toString()
            entity.isCustom = true
        }
        else
            shortUrl = ShortenerUtility.generateShortUrl()

        entity.shortUrl = shortUrl
        entity.originalUrl = request.originalUrl

        repository.run {
            persist(entity)
        }

        return UrlResponse(
            shortUrl = shortUrl,
            originalUrl = request.originalUrl
        )
    }

    fun listAllCustom() : List<UrlResponse> {
        val customResponses: List<UrlResponse>

        repository.run {
            customResponses = getAllCustom().map { UrlResponse( id = it.id, originalUrl = it.originalUrl, shortUrl = it.shortUrl )}
        }

        return customResponses
    }

    fun delete(id: Long) : Response{
        repository.run {
            deleteById(id)
        }

        return Response.ok().build()
    }
}