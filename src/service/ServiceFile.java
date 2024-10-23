package service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Animal;

public  class ServiceFile {
    private List<Animal> animalList = new ArrayList<>();
    private static String FILE_PATH = "file.txt";
    private String oldStr;



    public static void writeAnimalToFile(List<Animal> animalList) throws IOException{
        try(Count ct = new Count()){
            ct.add();

            try (FileWriter writer = new FileWriter(FILE_PATH, true)) {
                for(Animal animal : animalList) {
                    writer.write(animal + System.lineSeparator());
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }

    //*создаем список всех животных из файла */
    public static List<String> readAllAnimalsFromFile() throws IOException{
        List<String> ls = new ArrayList<>();
        String myPart = null;
        try(BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))){
            String animal = br.readLine();
            while (animal !=null) {
                ls.add(animal);
                animal = br.readLine();
            }
        }catch(IOException e) {
        System.out.println(e.getMessage());
        }
        return ls;
    }

    //*добавляет новые команды в нужную строку*/
    public static String changeStringAndWriteInFile(String name, String command) throws IOException{
        boolean ans = true;
        String finalStr = new String();
        List<String> ls = new ArrayList<>(); //сюда будем сохранять все строки из файла

        try(BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))){
            String animal = br.readLine();
            while (animal !=null) {
                //проверяем начало строки на соответствие префиксу
                if(ans = animal.startsWith("name=" + name + ",")){
                    animal = animal + "," + command;// если ok, то дописываем строку
                    finalStr = animal; //копируем измкненную строку для вывода в консоль
                }
                ls.add(animal); //добавляем строку в список
                animal = br.readLine();//считываем следующую строку
            }
        }catch(IOException e) {
        System.out.println(e.getMessage());
        }

        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            for(String str: ls) {
                writer.write(str + System.lineSeparator());
            }
        } catch (IOException e) {
        System.out.println(e.getMessage());
        }
    return finalStr;
    }
}
