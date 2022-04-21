package client.commands;

import data.Dragon;

import java.io.Serializable;
import java.util.LinkedHashMap;

abstract public class AbstractCommand implements Serializable {
    public String execute(LinkedHashMap<Integer, Dragon> dragonsCollection) {
        return "";
    }
}
