package client.commands;

import data.Dragon;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class PrintAscending extends AbstractCommand{
    @Override
    public String execute(LinkedHashMap<Integer, Dragon> dragonsCollection) {
        Map<Integer, Dragon> treeMap = new TreeMap<>(dragonsCollection);
        for (Map.Entry<Integer, Dragon> entry : treeMap.entrySet()) {
            return entry.toString();
        }
        return "";
    }
}