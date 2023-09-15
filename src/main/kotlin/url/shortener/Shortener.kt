package url.shortener

import jakarta.transaction.Transactional
import jakarta.ws.rs.*
import url.shortener.domain.UrlRequest
import url.shortener.domain.UrlResponse
import url.shortener.services.ShortenerService
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
    @Path("{id}")
    fun delete(@PathParam(Params.ID)  id: Long): Response = ShortenerService().delete(id)
}