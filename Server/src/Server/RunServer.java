package Server;

import client.commands.AbstractCommand;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class RunServer {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ServerCollection collection = new ServerCollection();
        ServerSocket server = new ServerSocket(1337);

        while (true){
            Socket client = server.accept();
            System.out.println("Подключился новый пользователь");
            DataInputStream inputStream=new DataInputStream(client.getInputStream());
            DataOutputStream outputStream=new DataOutputStream(client.getOutputStream());
            ObjectInputStream objectInputStream=new ObjectInputStream(client.getInputStream());
            new Thread(() -> {
                AbstractCommand command = null;
                try {
                    command = (AbstractCommand) objectInputStream.readObject();
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
                try {
                    outputStream.writeUTF(collection.executeCurrentCommand(command));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    outputStream.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Успешный запрос");}).start();



        }
    }
}
