package url.shortener.domain

import io.quarkus.hibernate.orm.panache.PanacheEntity
import jakarta.persistence.*
import url.shortener.utils.Params

@Entity
@Table(name = Params.LINKS)
open class UrlEntity: PanacheEntity() {
        @Column(name = Params.URL)
        open lateinit var originalUrl: String
        @Column(name = Params.CODE)
        open lateinit var shortUrl: String
        @Column(name = Params.IS_CUSTOM)
        var isCustom: Boolean = false
}