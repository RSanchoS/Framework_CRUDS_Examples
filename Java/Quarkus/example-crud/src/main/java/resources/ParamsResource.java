package resources;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import domains.Param;
import domains.Params;
import io.quarkus.logging.Log;
import services.ParamsService;

@Path("/params")
public class ParamsResource {

    @Inject
    ParamsService paramsService;

    @GET
    @Produces(MediaType.APPLICATION_JSON) 
    public Response getAllParams() {
        try {
            List<Params> params = paramsService.getAllParams();
            return Response.ok(params).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        } 

    }

    @GET
    @Path("/{paramsId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getParams(@PathParam("paramsId") String paramsId) {
        try {
            Params params = paramsService.findParamsById(paramsId);
            return Response.ok(params).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createParams(Params params) {
        try {
            Params createdParams = paramsService.createParams(params);
            return Response.status(Response.Status.CREATED).entity(createdParams).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateParams(Params params) {
        try {
            Params updatedParams = paramsService.updateParams(params);
            return Response.ok(updatedParams).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DELETE
    @Path("/{paramsId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteParams(@PathParam("paramsId") String paramsId) {
        try {
            paramsService.deleteParams(paramsId);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GET
    @Path("/{paramsId}/{paramName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getParam(@PathParam("paramsId") String paramsId, @PathParam("paramName") String paramName) {
        try {
            List<Param> param = paramsService.findParamByIdAndName(paramsId, paramName);
            return Response.ok(param).build();
        } catch (Exception e) {
            Log.error(e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }


    
}