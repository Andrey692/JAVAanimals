package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Animal;
import model.Type;
import service.Check;
import service.Count;
import service.DataService;
import service.ServiceFile;
import view.viewAnimals;

public class NewController {
    private List<Animal> animalList = new ArrayList<>();
    static Count count = new  Count();

    private final DataService dataService = new DataService();
    private final viewAnimals printConsole = new viewAnimals();

    private String name;
    private String commands;

    public void createCat(String name, String birthday, String command) throws IOException {
        dataService.create(name, birthday, command, Type.CAT);
    }

    public void createDog(String name, String birthday, String command) throws IOException {
        dataService.create(name, birthday, command, Type.DOG);
    }

    public void createHamster(String name, String birthday, String command) throws IOException {
        dataService.create(name, birthday, command, Type.HAMSTER);
    }

    //*передает список всех животных в консоль */
    public void  getListAnimal() throws IOException {
        List<String> ls = ServiceFile.readAllAnimalsFromFile();
        for (String animal : ls) {
            viewAnimals.printConsole(animal);
        }
    }

    //*добавление новых команд*/
    public void addNewCommand(String name, String commands) throws IOException{
        String finishString = ServiceFile.changeStringAndWriteInFile(name, commands); // получаем строку
        String message = "Измененная запись: ";
        viewAnimals.printMessage(message);
        viewAnimals.printConsole(finishString);
    }

    //*проверка name на уникальность */
    public static boolean contollerChekName(String name){
        if(Check.checkName(name)){// если имя существует то:
            return true;
        }
        return false;
    }
}
