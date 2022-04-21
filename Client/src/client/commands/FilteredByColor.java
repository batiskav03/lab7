package client.commands;

import data.Color;
import data.Dragon;

import java.util.LinkedHashMap;
import java.util.Map;

public class FilteredByColor extends AbstractCommand{
    Color color;

    public void setColor(Color color) {
        this.color = color;
    }


    @Override
    public String execute(LinkedHashMap<Integer, Dragon> dragonsCollection) {
        for (Map.Entry<Integer, Dragon> entry : dragonsCollection.entrySet()) {
            if (entry.getValue().getColor().equals(color)) {
                return entry.toString();

            }
        }
        return "";
    }
}
