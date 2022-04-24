package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import static client.ClientStaticSocket.getClientSocket;

public class ClientAuthorizer {
    Scanner scan = new Scanner(System.in);
    DataInputStream inputStream = new DataInputStream(getClientSocket().getInputStream());
    DataOutputStream outputStream = new DataOutputStream(getClientSocket().getOutputStream());
    ObjectOutputStream objectOutputStream = new ObjectOutputStream(getClientSocket().getOutputStream());

    public ClientAuthorizer() throws IOException {
    }
    public void switchCase() throws IOException {
        System.out.println("Введите то, что хотите сделать:");
        String arg = scan.nextLine();
        switch (arg) {
            case "log in":
                logIn();
                break;
            case "sign up":
                registration();
                break;
            default:
                System.out.println("Wrong!");
        }
    }
    public void entrance() throws IOException {

        System.out.println("Для того что бы авторизоваться введите: log in" +
                "\nДля того чтобы зарегистрироваться введите: sign up");


        switchCase();
        while (true) {
            String ans = inputStream.readUTF();
            switch (ans) {
                case "wrong sign up":
                    System.out.println("Пользователь с данным логином уже существует, попробуйте еще раз");
                    switchCase();
                    break;
                case "successful registration":
                    System.out.println("Регистрация прошла успешно");
                    switchCase();
                    break;
                case "successful connection":
                    System.out.println("Авторизация прошла успешно");
                    return;
                case "wrong login":
                    System.out.println("Логин или пароль неверны." +
                            "\nПопробуйте еще раз.");
                    switchCase();
                    break;
            }
        }



    }



    public void registration() throws IOException {
        outputStream.writeUTF("registration");
        outputStream.flush();
        System.out.println("Придумайте свой логин:");
        String login = scan.nextLine();

        outputStream.writeUTF(login);
        outputStream.flush();

        System.out.println("Придумайте свой пароль:");
        String password = scan.nextLine();

        outputStream.writeUTF(password);
        outputStream.flush();


        System.out.println("Обработка запроса ...");

    }

    public void logIn() throws IOException {
        outputStream.writeUTF("login");
        outputStream.flush();
        System.out.println("Введите свой логин:");
        String login = scan.nextLine();
        outputStream.writeUTF(login);
        outputStream.flush();


        System.out.println("Введите свой пароль:");
        String password = scan.nextLine();
        outputStream.writeUTF(password);
        outputStream.flush();


        System.out.println("Обработка запроса ...");

    }

}