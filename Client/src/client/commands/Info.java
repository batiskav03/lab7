package client.commands;

import data.Dragon;

import java.util.LinkedHashMap;

public class Info extends AbstractCommand {
    @Override
    public String execute(LinkedHashMap<Integer, Dragon> dragonsCollection) {
        return "Count of element in collection := " + dragonsCollection.size();
    }
}
