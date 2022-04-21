package client;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;



public class Authorizer {
    private HashMap<String, String> data = new HashMap<>();

    public void registration() {
        String login = askLogin();
        if(login.equals("exit")) {
            action();
        }
        for (Map.Entry<String, String> entry : data.entrySet()) {
            if (entry.getKey().equals(login)) {
                System.out.println("Данный логин занят кем-то другим");
                registration();
            }
        }
        String password = askPassword();
        if(password.equals("exit")) {
            action();
        }
        data.put(login,password);
        System.out.println("Регистрация завершена успешно!");
    }

    public void authorization() {
        boolean isAuthorize = false;
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите логин:");
        String login = scan.nextLine();
        if(login.equals("exit")) {
            action();
        }
        System.out.println("Введите пароль:");
        String password = scan.nextLine();
        if(password.equals("exit")) {
            action();
        }
        for (Map.Entry<String, String> entry : data.entrySet()) {
            if (entry.getKey().equals(password) && entry.getValue().equals(login)) {
                System.out.println("Авторизация проведена успешно!");
                isAuthorize = true;

            }
        }
        if (!isAuthorize) {
            System.out.println("Логин или пароль неверный! Попробуйте еще раз");
            authorization();
        }
    }

    public String askPassword() {
        String password = "";
        System.out.println("Придумайте свой пароль:");
        Scanner scan = new Scanner(System.in);
        password = scan.nextLine();
        return password;
    }

    public String askLogin() {
        String login = "";
        System.out.println("Придумайте свой логин:");
        Scanner scan = new Scanner(System.in);
        login = scan.nextLine();
        return login;
    }

    public void action() {
        System.out.println("Для того что бы авторизоваться введите: log in\nДля того чтобы зарегистрироваться введите: sign up" );
        boolean flag = false;
        while (!flag) {
            System.out.println("Введите то, что хотите сделать:");
            Scanner scan = new Scanner(System.in);
            String answer = scan.nextLine();
            switch (answer) {
                case ("log in"):
                    authorization();
                    flag = true;
                    break;
                case ("sign up"):
                    registration();
                    break;
                default:
                    System.out.println("one more try bro");
            }
        }
    }
}
