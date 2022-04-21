package Server;

import client.commands.AbstractCommand;
import data.Dragon;

import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;

public class ServerCollection {
    private LinkedHashMap<Integer, Dragon> dragonsCollection;
    private final Date date = new Date();
    private JsonProcessing save = new JsonProcessing();
    /**
     * Свойство - ID объектов
     */
    public static int idCounter;

    public ServerCollection(){
        try {
            dragonsCollection = JsonProcessing.readFile();
            idCounter = JsonProcessing.readFile().size();
            System.out.println(JsonProcessing.readFile().size());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public String executeCurrentCommand(AbstractCommand command){
        return command.execute(dragonsCollection);
    }


    public void whenExit() {
        try {
            save.saveCollection(dragonsCollection);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
