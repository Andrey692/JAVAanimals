package service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Animal;
import model.Cat;
import model.Dog;
import model.Hamster;
import model.Type;

public class DataService {
    private List<Animal> animalList = new ArrayList<>();

    //*метод принимает параметры животного (birthday,command,name)
    //и по ним создает либо собаку, либо кошку, либо хомяка*/
    public void create(String name, String birthday, String command, Type type) throws IOException{
    int id = getId(type);
        if (type == model.Type.CAT) {
            animalList.add(new Cat(id, name, birthday, command));
            ServiceFile.writeAnimalToFile(animalList);
        }
        if (type == model.Type.DOG) {
            animalList.add(new Dog(id, name, birthday, command));
            ServiceFile.writeAnimalToFile(animalList);
        }
        if (type == model.Type.HAMSTER) {
            animalList.add(new Hamster(id, name, birthday, command));
            ServiceFile.writeAnimalToFile(animalList);

        }
    }

    private int getId(Type type) {
        boolean itsCat = Type.CAT == type;
        int LastId = 1;
        for (Animal animal : animalList) {
            if (animal instanceof Dog && !itsCat)
                LastId = ((Dog) animal).getDogId() + 1;
            if (animal instanceof Cat && itsCat)
                LastId = ((Cat) animal).getCatId() + 1;
            if (animal instanceof Hamster && !itsCat)
                LastId = ((Hamster) animal).getHamsterId() + 1;
        }
        return LastId;
    }

    public void setAnimalList(List<Animal> animalList) {
        this.animalList = animalList;
    }

}
