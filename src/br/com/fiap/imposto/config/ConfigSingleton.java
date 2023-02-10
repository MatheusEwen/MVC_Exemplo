package br.com.fiap.imposto.config;

import java.io.IOException;
import java.util.Properties;

public class ConfigSingleton {

    private static Properties prop;

    private ConfigSingleton() {

    }

    public static Properties getInstance() {
        if(prop == null) {
            prop = new Properties();
            try {
                prop.load(ConfigSingleton.class.getResourceAsStream("/config.properties"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return prop;
    }

}
