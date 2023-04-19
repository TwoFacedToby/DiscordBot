package com.FilurFyren.Listeners;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class EventListener extends ListenerAdapter {
    /*
    By Pressing [CTRL + o] you can see all the events or by heading to this link:
    https://jda.wiki/introduction/events-list/
    */
    Commands commands = new Commands();

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        super.onMessageReceived(event);
        String message = event.getMessage().getContentRaw();
        if(message.toCharArray()[0] == '<') commands.newCommand(event);
    }
}
