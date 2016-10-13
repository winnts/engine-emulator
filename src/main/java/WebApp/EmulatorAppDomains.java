package WebApp;

import Processing.GetResources;
import com.codahale.metrics.annotation.Timed;
import io.dropwizard.jersey.PATCH;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by adyachenko on 29.08.16.
 */
@Path("/hosts")
@Produces(MediaType.APPLICATION_JSON)
public class EmulatorAppDomains {
    private final String template;
    private final AtomicLong counter;

    public EmulatorAppDomains(String template){
        this.template = template;
        this.counter = new AtomicLong();
    }

    @Path("{hash: [a-zA-Z_0-9]*}/domains")
    @GET
    @Timed
    public SendDomains sendAll() throws IOException {
        GetResources.start();
        return new SendDomains(Processing.GetDomains.getDomains());
    }
    @Path("{hash: [a-zA-Z_0-9]*}")
    @PATCH
    @Timed
    public void patchAll() throws IOException {
        GetResources.stop();
    }
}
