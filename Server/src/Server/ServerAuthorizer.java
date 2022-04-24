package Server;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;


public class ServerAuthorizer {

    private HashMap<String,String> data = new HashMap<>();      /* login, password */

    public void logInWait(Socket socket) throws IOException, ClassNotFoundException {
        DataInputStream inputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket
                .getOutputStream());

        while(true) {
            System.out.println("Ожидание приказа");
            String order = inputStream.readUTF();
            System.out.println(order);
            if(order.equals("registration")) {
                output.writeUTF(registration(socket));
                output.flush();
            } else if (order.equals("login")) {
                String check = authorize(socket);
                output.writeUTF(check);
                output.flush();
                if (check.equals("successful connection")) {
                    return;
                }

            }
        }

    }
    public String authorize(Socket socket) throws IOException {
        DataInputStream inputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket
                .getOutputStream());
        System.out.println("Клиент начал попытку авторизации");
        String login = inputStream.readUTF();
        String password = inputStream.readUTF();
        for (Map.Entry<String, String> entry : data.entrySet()) {
            if (entry.getKey().equals(login) || entry.getValue().equals(password)) {
                System.out.println("Пользователь подключился");
                return "successful connection";
            }
        }
        System.out.println("Пользователь безуспешно пытался подключится");
        return "wrong login";
    }
    public String registration(Socket socket) throws IOException {
        DataInputStream inputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket
                .getOutputStream());
        System.out.println("Клиент начал попытку регистрации");
        String login = inputStream.readUTF();
        String password = inputStream.readUTF();
        for (Map.Entry<String, String> entry : data.entrySet()) {
            if (entry.getKey().equals(login)) {
                System.out.println("Пользователь безуспешно пытался зарегистрироваться");
                return "wrong sign up";
            }
        }
        data.put(login,password);
        System.out.println("Пользователь зарегистрировался");
        return "successful registration";
    }
}



