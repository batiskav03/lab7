package client.commands;

import data.Dragon;

import java.util.LinkedHashMap;
import java.util.Map;

public class UpdateID extends AbstractCommand {
    Integer id;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDragon(Dragon a) {
        this.a = a;
    }

    Dragon a;

    @Override
    public String execute(LinkedHashMap<Integer, Dragon> dragonsCollection) {
        for (Map.Entry<Integer, Dragon> entry : dragonsCollection.entrySet()) {
            if (entry.getValue().getId().equals(id)) {
                System.out.println("Update element:");
                dragonsCollection.put(id,a);
            } else {
                return "Элемент не найден";
            }

        }
        return "Элемент успешно обновлен";
    }
}