package client.commands;

import data.Dragon;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class RemoveGreaterKey extends AbstractCommand{
    private Integer Key;
    public void setKey(Integer key) {
        Key = key;
    }
    @Override
    public String execute(LinkedHashMap<Integer, Dragon> dragonsCollection) {
        Iterator<Map.Entry<Integer,Dragon>> i = dragonsCollection.entrySet().iterator();
        while (i.hasNext()) {
            Map.Entry<Integer, Dragon> entry = i.next();
            if(Key < entry.getKey()) {
                i.remove();
            }
        }
        return "Операция завершена";
    }
}
