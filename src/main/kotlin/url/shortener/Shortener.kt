package url.shortener

import jakarta.transaction.Transactional
import url.shortener.domain.UrlRequest
import url.shortener.domain.UrlResponse
import url.shortener.services.ShortenerService
import jakarta.ws.rs.Consumes
import jakarta.ws.rs.DELETE
import jakarta.ws.rs.GET
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam
import jakarta.ws.rs.Produces
import jakarta.ws.rs.QueryParam
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import url.shortener.utils.Params

@Path("/shortener")
@Transactional
class Shortener {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun create(request: UrlRequest): UrlResponse = ShortenerService().create(request)

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun listAllCustom(): List<UrlResponse> = ShortenerService().listAllCustom()

    @DELETE
    fun delete(@QueryParam(Params.ID) id: Long): Response = ShortenerService().delete(id)
}