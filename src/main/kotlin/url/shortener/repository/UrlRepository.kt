package url.shortener.repository

import io.quarkus.hibernate.orm.panache.PanacheRepository
import url.shortener.domain.UrlEntity
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class UrlRepository: PanacheRepository<UrlEntity> {
    fun getAllCustom(): List<UrlEntity> = list("isCustom", true)
}