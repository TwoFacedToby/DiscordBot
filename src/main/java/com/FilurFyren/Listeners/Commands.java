package com.FilurFyren.Listeners;

import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.exceptions.ErrorResponseException;

import static java.lang.Integer.parseInt;

public class Commands {
    private String[] command = new String[0];
    Messages messages = new Messages();
    MessageReceivedEvent event;

    public void newCommand(MessageReceivedEvent event){
        this.event = event;
        command = event.getMessage().getContentRaw().split(" ");
        switch (command[0]){
            case "<answer":
                answer();
                break;
            case "<help":
                help();
                break;
            case "<poll":
                poll();
                break;



            default:
                System.out.println("Unknown Command");
                break;
        }
    }
    private void answer(){

    }
    private void poll(){
        int amount = 0;
        if(command.length > 2){
            if(command[1].equals("options")){
                try{
                    amount = parseInt(command[2]);
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }
        System.out.println("Creating Poll");
        String text = messages.line + "\n                                        **POLL**\n"+ messages.line + "\n\n";

        if(amount > 0){
            text += collect(command, 3, command.length);
            int finalAmount = amount;
            event.getChannel().sendMessage(text).queue(message -> {
                message.addReaction(Emoji.fromUnicode("\u1523")).queue();

            });
        }
        else{
            text += collect(command, 1, command.length);
            event.getChannel().sendMessage(text).queue(message -> {
                message.addReaction(Emoji.fromUnicode("\u2705")).queue();
                message.addReaction(Emoji.fromUnicode("\u274e")).queue();
            });
        }

    }
    private String collect(String[] arr, int start, int end){
        String message = "";
        for(int i = start; i < arr.length; i++){
            message += arr[i] + " ";
        }
        return message;
    }
    private void help(){
        String message = "";
        if(command.length == 1){
            message = messages.help;
        }


        sendPrivateMessage(event.getAuthor(), message);
    }
    // Helper Functions (maybe implement own class (Singleton?)
    private void sendPrivateMessage(User user, String content) {
        // openPrivateChannel provides a RestAction<PrivateChannel>
        // which means it supplies you with the resulting channel
        user.openPrivateChannel().queue((channel) ->
        {
            channel.sendMessage(content).queue();
        });
    }



}
