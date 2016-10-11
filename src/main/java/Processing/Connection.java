package Processing;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by adyachenko on 11.10.16.
 */
public class Connection {
    public static HttpURLConnection HttpConnection (String url) throws IOException {
        URL u = new URL(url);
        return (HttpURLConnection)u.openConnection();
    }
}
