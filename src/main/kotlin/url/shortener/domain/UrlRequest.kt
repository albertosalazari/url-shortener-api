package url.shortener.domain

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import url.shortener.utils.Params

data class UrlRequest @JsonCreator constructor (
    @JsonProperty(Params.ORIGINAL_URL) val originalUrl: String = "",
    @JsonProperty(Params.CUSTOM_URL) val customUrl: String? = null
)