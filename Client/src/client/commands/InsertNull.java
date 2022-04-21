package client.commands;

import data.Dragon;

import java.util.LinkedHashMap;

public class InsertNull extends AbstractCommand{
    public void setDragon(Dragon a) {
        this.a = a;
    }

    Dragon a;

    public void setKey(Integer key) {
        this.key = key;
    }

    Integer key;
    @Override
    public String execute(LinkedHashMap<Integer, Dragon> dragonsCollection) {
        dragonsCollection.put(key, a);
        return "Объект успешно добавлен";
    }

}
