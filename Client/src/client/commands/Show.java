package client.commands;

import data.Dragon;

import java.util.LinkedHashMap;
import java.util.Map;

public class Show extends AbstractCommand{
    @Override
    public String execute(LinkedHashMap<Integer, Dragon> dragonsCollection) {
        String ans = "";
        for (Map.Entry<Integer, Dragon> entry : dragonsCollection.entrySet()) {
            ans += entry.toString() + "\n";
        }
        return ans;
    }
}
