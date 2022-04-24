package client;

import client.commands.AbstractCommand;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;

import static client.ClientStaticSocket.getClientSocket;

public class SendCmd {
    private Socket socket;
    private DataInputStream inputStream;

    private BufferedReader keyboard;
    private ObjectOutputStream objectOutputStream;

    public SendCmd() {
        try {
            keyboard = new BufferedReader(new InputStreamReader(System.in));
            objectOutputStream = new ObjectOutputStream(getClientSocket().getOutputStream());
            inputStream = new DataInputStream(getClientSocket().getInputStream());
            
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
