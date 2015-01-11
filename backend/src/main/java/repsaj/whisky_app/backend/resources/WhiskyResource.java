package repsaj.whisky_app.backend.resources;

import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import repsaj.whisky_app.backend.model.Whisky;

@Path("whisky")
public class WhiskyResource {
    
    private final Map<String,Whisky> whiskyCache = new HashMap<>();
    
    public WhiskyResource(){
        Whisky whisky1 = new Whisky();
        whisky1.setId("1");
        whisky1.setName("test 1");
        whisky1.setSubName("tst");
        whiskyCache.put(whisky1.getId(),whisky1);
        
        Whisky whisky2 = new Whisky();
        whisky2.setId("2");
        whisky2.setName("Another whisky");
        whisky2.setSubName("bla");
        whiskyCache.put(whisky2.getId(), whisky2);
        
    }

    @GET
    @Path("")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getWhiskyList() {
        return Response.ok(whiskyCache.values()).build();
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getWhiskyById(final @PathParam("id") String id) {
        return Response.ok(whiskyCache.get(id)).build();
    }
}
