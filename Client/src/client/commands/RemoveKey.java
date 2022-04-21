package client.commands;

import data.Dragon;

import java.util.LinkedHashMap;
import java.util.Map;

public class RemoveKey extends AbstractCommand{
    private Integer Key;
    public void setKey(Integer key) {
        Key = key;
    }


    @Override
    public String execute(LinkedHashMap<Integer, Dragon> dragonsCollection) {
        for (Map.Entry<Integer, Dragon> entry : dragonsCollection.entrySet()) {
            if (entry.getValue().getId().equals(Key)) {
                System.out.println("Update element:");
                dragonsCollection.remove(Key);
            } else {
                return "Элемент не найден";
            }

        }
        return "Элемент успешно удален";
    }
}
