package com.FilurFyren.Connection;

import io.github.cdimascio.dotenv.Dotenv;

public class Config {



    private final Dotenv env;
    private static Config config;

    public Config() {
        env = Dotenv.configure().load();
    }

    public static Config get(){
        if(config == null) config = new Config();
        return config;
    }

    public String getConfig(String s){
        return env.get(s);
    }
}
