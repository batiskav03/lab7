package client;

import client.commands.AbstractCommand;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;

public class SendCmd {
    private Socket socket;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;
    private BufferedReader keyboard;
    private ObjectOutputStream objectOutputStream;

    public SendCmd() {
        try {
            socket = new Socket("localhost",1337);
            keyboard = new BufferedReader(new InputStreamReader(System.in));
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream=new DataInputStream(socket.getInputStream());
            outputStream=new DataOutputStream(socket.getOutputStream());
        } catch (IOException e ) {
            e.getMessage();
        }


    }
    public void Sender(AbstractCommand command){
        try {
            objectOutputStream.writeObject(command);
            objectOutputStream.flush();
            System.out.println(inputStream.readUTF());
        }
        catch (SocketException ex){
            System.out.println("Сервер отключен");
        }
        catch (IOException ex){
            System.out.println("Невозможна отправка");
        }

    }
}
