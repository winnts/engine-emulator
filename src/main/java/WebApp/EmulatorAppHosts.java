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
public class EmulatorAppHosts {
    private final String template;
    private final AtomicLong counter;

    public EmulatorAppHosts(String template){
        this.template = template;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public SendDomains sendAll() throws IOException {
        GetResources.start();
        return new SendDomains(counter.incrementAndGet(), Processing.GetDomains.getDomains());
    }

    @PATCH
    @Timed
    public void patchAll() throws IOException {
        GetResources.stop();
    }
}
