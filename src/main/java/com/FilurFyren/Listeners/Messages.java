package com.FilurFyren.Listeners;

import net.dv8tion.jda.api.entities.emoji.Emoji;

public class Messages {
    public String line = "__                                                                                           __";
    public String help =
                    "                                   Hello.                              \n"+
                    "Here is a short list of commands you can use on a server where I am on.\n" +
                    "To get a description of specific commands write **<help [command]**\n" +
                    "To get a random answer to a question ask **<answer** [your question]\n"+
                    "To start a pole use <poll [question]\n"+
                    "\n"+
                    "\n"+
                    "\n"+
                    "\n"+
                    "\n"+
                    "\n";

    public Emoji[] numbers;

    Messages(){
        numbers = new Emoji[10];
        numbers[0] = Emoji.fromUnicode("\u0030");
        numbers[1] = Emoji.fromUnicode("\u0031");
        numbers[2] = Emoji.fromUnicode("\u0032");
        numbers[3] = Emoji.fromUnicode("\u0033");
        numbers[4] = Emoji.fromUnicode("\u0034");
        numbers[5] = Emoji.fromUnicode("\u0035");
        numbers[6] = Emoji.fromUnicode("\u0036");
        numbers[7] = Emoji.fromUnicode("\u0037");
        numbers[8] = Emoji.fromUnicode("\u0038");
        numbers[9] = Emoji.fromUnicode("\u0039");

    }

    //region emojis
    /*
    :zero:: \u0030
    :one:: \u0031
    :two:: \u0032
    :three:: \u0033
    :four:: \u0034
    :five:: \u0035
    :six:: \u0036
    :seven:: \u0037
    :eight:: \u0038
    :nine:: \u0039
    */
    //endregion

}
