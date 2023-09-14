package url.shortener

import jakarta.transaction.Transactional
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam
import jakarta.ws.rs.core.Response
import url.shortener.services.DefaultService
import url.shortener.utils.Params

@Path("/")
@Transactional
class Default {
    @GET
    @Path("{shortUrl}")
    fun redirect(@PathParam(Params.SHORT_URL) shortUrl: String): Response = DefaultService().redirect(shortUrl)
}