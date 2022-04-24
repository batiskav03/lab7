package client;

import java.io.IOException;
import java.net.Socket;

public class ClientStaticSocket {
    private static Socket socket;

    static {
        try {
            socket = new Socket("localhost",1337);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static Socket getClientSocket() {
        return socket;
    }

}
