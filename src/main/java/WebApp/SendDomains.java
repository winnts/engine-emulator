package WebApp;

import Entity.Domains;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;


/**
 * Created by adyachenko on 11.10.16.
 */
public class SendDomains {
    private List<Domains> domains;
    public SendDomains(List<Domains> domains){
        this.domains = domains;
    }
    @JsonProperty
    public List<Domains> getDomains() {
        return domains;
    }
}
