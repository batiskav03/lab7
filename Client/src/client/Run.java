package client;


import Server.JsonProcessing;

import java.io.*;
import java.util.logging.*;


/**
 * @author Калабухов Максим
 */

public class Run {

    public static void main(String[] args) throws IOException, InterruptedException {
        ClientAuthorizer authorizer = new ClientAuthorizer();
//        authorizer.entrance();
        Console console = new Console();
        Handler FileHandler = new FileHandler("log.log");
        JsonProcessing.log.setUseParentHandlers(false);
        JsonProcessing.log.addHandler(FileHandler);
        JsonProcessing.log.info("Program is running.");
        console.interactiveMod();
        JsonProcessing.log.info("Program successful complete.");


    }

}
