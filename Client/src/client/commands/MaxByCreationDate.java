package client.commands;

import data.Dragon;

import java.util.LinkedHashMap;
import java.util.Map;

public class MaxByCreationDate extends AbstractCommand{
    @Override
    public String execute(LinkedHashMap<Integer, Dragon> dragonsCollection) {
        long maxdatemls = 0;
        Integer key = null;
        for (Map.Entry<Integer, Dragon> entry : dragonsCollection.entrySet()) {
            if (entry.getValue().getCreationDate().getTime() > maxdatemls) {
                maxdatemls = entry.getValue().getCreationDate().getTime();
                key = entry.getKey();
            }
        }
        return dragonsCollection.get(key).toString();
    }
}
