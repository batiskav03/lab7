package client.commands;

import data.Dragon;

import java.util.LinkedHashMap;

public class Help extends AbstractCommand{
    @Override
    public String execute(LinkedHashMap<Integer, Dragon> dragonsCollection) {
        return "help : Список команд\n" +
                "info : Информация о коллекции\n" +
                "show : Все элементы в коллекции\n" +
                "insert {key} : Добавить новый элемент с заданным ключ\n" +
                "update {id} : Обновить значение\n" +
                "remove {key} : Удалить элемент из коллекции по ключу\n" +
                "clear : Очистить коллекцию\n" +
                "save : Сохранить коллекцию в файл\n" +
                "execute_script file_name : Считать и исполнить скрипт из указанного файла\n" +
                "exit : Завершить программу (без сохранения в файл)\n" +
                "history : Вывести последние 15 команд (без их аргументов)\n" +
                "rmv_greater {key} : Удалить из коллекции все элементы, ключ которых превышает заданный\n" +
                "rmv_lower {key}: Удалить из коллекции все элементы, ключ которых меньше, чем заданный\n" +
                "max_date : Вывести любой объект из коллекции, значение поля creationDate которого является максимальным\n" +
                "filter_color {color} : Вывести элементы, значение поля color которых равно заданному\n" +
                "print_ascending: Вывести элементы коллекции в порядке возрастания";
    }
}
