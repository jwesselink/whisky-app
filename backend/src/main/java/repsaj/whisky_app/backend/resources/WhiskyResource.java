package repsaj.whisky_app.backend.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import repsaj.whisky_app.backend.Server;
import repsaj.whisky_app.backend.db.MongoDB;
import repsaj.whisky_app.backend.model.Whisky;

@Path("whisky")
public class WhiskyResource {

    public WhiskyResource() {
//        try {
//            Whisky whisky = new Whisky();
//            whisky.setId("1");
//            whisky.setName("Laphroaig");
//            whisky.setSubName("10yo");
//            //whiskyCache.put(whisky.getId(), whisky);
//            Server.getInstance().getDb().store(whisky);
//
//            whisky = new Whisky();
//            whisky.setId("2");
//            whisky.setName("Laphroaig");
//            whisky.setSubName("quarter cask");
//            Server.getInstance().getDb().store(whisky);
//
//            whisky = new Whisky();
//            whisky.setId("3");
//            whisky.setName("Ardbeg");
//            whisky.setSubName("10yo");
//            Server.getInstance().getDb().store(whisky);
//        } catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }

    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getWhiskyList() {
        try {
            MongoDB db = Server.getInstance().getDb();
            return Response.ok(db.findAll()).build();
        } catch (Exception ex) {
            return Response.serverError().build();
        }
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getWhiskyById(final @PathParam("id") String id) {
        try {
            MongoDB db = Server.getInstance().getDb();
            return Response.ok(db.findById(id)).build();
        } catch (Exception ex) {
            return Response.serverError().build();
        }
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response storeWhisky(Whisky whisky) {
        try {
            MongoDB db = Server.getInstance().getDb();
            //TODO Validate intput!!
            Whisky obj = db.store(whisky);
            return Response.ok(obj).build();
        } catch (Exception ex) {
            return Response.serverError().build();
        }
    }
}
