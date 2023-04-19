package com.FilurFyren;

import com.FilurFyren.Connection.ConnectBot;
import io.github.cdimascio.dotenv.Dotenv;

import javax.security.auth.login.LoginException;

public class Main {

    public static void main(String[] args) {
        try{
            ConnectBot botConnection = new ConnectBot();

        }catch (LoginException e){
            System.out.println("ERROR: Provided bot token is invalid!\n\n");
            System.out.println(e.getMessage());
        }
    }
}