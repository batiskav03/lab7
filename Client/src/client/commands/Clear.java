package client.commands;

import data.Dragon;

import java.util.LinkedHashMap;

public class Clear extends AbstractCommand{
    @Override
    public String execute(LinkedHashMap<Integer, Dragon> dragonsCollection) {
        dragonsCollection.clear();
        return "Очистка успешно проведена!";
    }
}
