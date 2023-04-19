package com.FilurFyren.Connection;

import com.FilurFyren.Listeners.EventListener;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;

import javax.security.auth.login.LoginException;

public class ConnectBot {


    private final ShardManager shardManager;

    private DefaultShardManagerBuilder builder;

    public ConnectBot() throws LoginException {
        String token = Config.get().getConfig("TOKEN");
        builder = DefaultShardManagerBuilder.createDefault(token);
        setStatus(OnlineStatus.ONLINE);
        builder.enableIntents(GatewayIntent.MESSAGE_CONTENT);
        shardManager = builder.build();
        shardManager.addEventListener(new EventListener());
    }





    public void setStatus(OnlineStatus status){
        builder.setStatus(status);
    }
    public void setActivity(Activity activity){
        builder.setActivity(activity);
    }
}
