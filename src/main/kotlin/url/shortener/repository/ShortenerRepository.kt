package url.shortener.repository

import io.quarkus.hibernate.orm.panache.PanacheRepository
import url.shortener.domain.UrlEntity
import jakarta.enterprise.context.ApplicationScoped
import url.shortener.utils.Params

@ApplicationScoped
class ShortenerRepository: PanacheRepository<UrlEntity> {
    fun getAllCustom(): List<UrlEntity> = list("isCustom", true)
}