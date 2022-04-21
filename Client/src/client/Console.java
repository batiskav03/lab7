package client;

import java.util.Scanner;

public class Console {


    private Scanner keyboard;
    private String userCommand = "";
    private String[] finalCommand;
    private SenderManager sender = new SenderManager();

    public void interactiveMod() {
        keyboard = new Scanner(System.in);

        while (true) {
            System.out.print("Enter the command:");
            userCommand = keyboard.nextLine();
            finalCommand = userCommand.trim().split(" ", 2);
            sender.createAndSend(finalCommand);
            if (userCommand.equals("exit")) {
                break;
            }
        }
    }

}
