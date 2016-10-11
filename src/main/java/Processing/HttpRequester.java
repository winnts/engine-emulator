package Processing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/**
 * Created by adyachenko on 11.10.16.
 */
public class HttpRequester {
    public static String get(HttpURLConnection con) throws IOException {
        String content = "";
        try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            String line;
            while ((line = in.readLine()) != null) {
                content += line;
            }
        }
        return content;
    }
}
