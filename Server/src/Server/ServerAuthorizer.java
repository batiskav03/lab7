package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;



public class ServerAuthorizer {
    private HashMap<String, String> data = new HashMap<>();

    public void registration(Socket socket) throws IOException {
        String login = askLogin(socket);
        if(login.equals("exit")) {
            action(socket);
        }
        for (Map.Entry<String, String> entry : data.entrySet()) {
            if (entry.getKey().equals(login)) {
                System.out.println("Данный логин занят кем-то другим");
                registration(socket);
            }
        }
        String password = askPassword(socket);
        if(password.equals("exit")) {
            action(socket);
        }
        data.put(login,password);
        System.out.println("Регистрация завершена успешно!");
    }

    public void authorization(Socket socket) throws IOException {
        boolean isAuthorize = false;
        DataInputStream inputStream=new DataInputStream(socket.getInputStream());
        DataOutputStream outputStream=new DataOutputStream(socket.getOutputStream());
        outputStream.writeUTF("Введите логин:");
        outputStream.flush();

        String login = inputStream.readUTF();

        if(login.equals("exit")) {
            action(socket);
        }
        outputStream.writeUTF("Введите пароль:");
        String password = inputStream.readUTF();
        if(password.equals("exit")) {
            action(socket);
        }
        for (Map.Entry<String, String> entry : data.entrySet()) {
            if (entry.getKey().equals(password) && entry.getValue().equals(login)) {
                System.out.println("Авторизация проведена успешно!");
                isAuthorize = true;

            }
        }
        if (!isAuthorize) {
            System.out.println("Логин или пароль неверный! Попробуйте еще раз");
            authorization(socket);
        }
    }

    public String askPassword(Socket socket) {
        String password = "";
        System.out.println("Придумайте свой пароль:");
        Scanner scan = new Scanner(System.in);
        password = scan.nextLine();
        return password;
    }

    public String askLogin(Socket socket) {
        String login = "";
        System.out.println("Придумайте свой логин:");
        Scanner scan = new Scanner(System.in);
        login = scan.nextLine();
        return login;
    }

    public void action(Socket socket) throws IOException {
        System.out.println("Для того что бы авторизоваться введите: log in\nДля того чтобы зарегистрироваться введите: sign up" );
        boolean flag = false;
        while (!flag) {
            System.out.println("Введите то, что хотите сделать:");
            Scanner scan = new Scanner(System.in);
            String answer = scan.nextLine();
            switch (answer) {
                case ("log in"):
                    authorization(socket);
                    flag = true;
                    break;
                case ("sign up"):
                    registration(socket);
                    break;
                default:
                    System.out.println("one more try bro");
            }
        }
    }
}
