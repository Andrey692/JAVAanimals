package service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public  class Check {
    private static String FILE_PATH = "file.txt";

    //*проверяем наличие имени в файле */
    public static boolean checkName(String name){
        try(BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))){
            String animal = br.readLine(); //в переменную animal сохранится первая строчка
            while (animal !=null) {
                //проверяем начало строки на соответствие префиксу
                if(animal.startsWith("name=" + name + ",")){
                    return true;
                }
                animal = br.readLine();
            }
        }catch(IOException e) {
        System.out.println(e.getMessage());
        }
        return false;
    }

}
