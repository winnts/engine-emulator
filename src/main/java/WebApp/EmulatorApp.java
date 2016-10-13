package WebApp;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Created by adyachenko on 29.08.16.
 */
public class EmulatorApp extends Application <EmulatorAppConfiguration> {
    public static EmulatorAppConfiguration config;

    public static void main(String[] args) throws Exception{
        new EmulatorApp().run(args);
    }

    @Override
    public String getName() {
        return "ResourcesApp";
    }

    @Override
    public void initialize (Bootstrap<EmulatorAppConfiguration> bootstrap){
        bootstrap.addBundle(new AssetsBundle("/webapp", "/app"));
    }

    @Override
    public void run(EmulatorAppConfiguration emulatorAppConfiguration, Environment environment) {
        config = emulatorAppConfiguration;
        final EmulatorAppDomains resource = new EmulatorAppDomains(
                emulatorAppConfiguration.getTemplate()
        );
        environment.jersey().register(resource);
    }
}
