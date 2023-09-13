package url.shortener.domain

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class UrlResponse(val id: Long? = null, val shortUrl: String, val originalUrl: String)