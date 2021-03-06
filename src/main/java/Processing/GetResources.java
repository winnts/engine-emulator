package Processing;

import Entity.AllResources;
import WebApp.EmulatorApp;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import static Csv.Csv.generateCsvFile;

/**
 * Created by adyachenko on 11.10.16.
 */
public class GetResources {
    private static List<AllResources> resources = new ArrayList<>();
    private static Timer timer = new Timer();

    private static String getResources() throws IOException{
        return HttpRequester.get(Connection.HttpConnection(EmulatorApp.config.getUrl()+EmulatorApp.config.getProcessName()));
    }

    public static void start () throws IOException {
        long startTimer = System.nanoTime();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    JSONObject res = new JSONObject(getResources());
                    long currentTime = System.nanoTime() - startTimer;
                    JSONArray content = res.getJSONArray("content");
                    for (Object o : content) {
                        JSONObject ress = new JSONObject(o.toString());
                        resources.add(new AllResources(ress.getString("processCPU"), ress.getString("processMem"),
                                ress.getString("systemCPU"), ress.getString("systemFreeMem"),
                                ress.getString("systemTotalMem"), currentTime/1000000000));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }, 0, 1000);
    }

    public static void stop (){
        timer.cancel();
        generateCsvFile(resources);
    }
}
