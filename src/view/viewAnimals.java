package view;

import controller.NewController;
import java.io.IOException;
import java.util.Scanner;

public class viewAnimals {
    static NewController controller = new NewController();

    public static void printMessage(String massage){
        System.out.println("__________________");
        System.out.print(massage);
    }

    //*основное меню */
    public static void menu() throws IOException{
        Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("__________________");
                System.out.println("Выберите действие:");
                System.out.println("1. Завести новое животное");
                System.out.println("2. Показать список всех животных");
                System.out.println("3. Обучить животное новой команде");
                System.out.println("0. Выход");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> {
                        viewAddNewAnimal();
                        continue;
                    }
                    case 2 -> {
                        viewShowAllAnimals();
                        continue;
                    }
                    case 3 -> {
                        viewAddNewCommand();
                    }
                    case 0 -> {
                        System.out.println("Выход...");
                        return;
                    }
                    default -> System.out.println("Неверный выбор.");
                }
            }
    }


    //*дополнительное меню */
    public static void viewAddNewAnimal() throws IOException{
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println('\n' + "Заводим собаку или кошку,");
                System.out.print("выберете цифру: ");
                System.out.println('\n' + "1 = Dog");
                System.out.println("2 = Cat");
                System.out.println("3 = Hamster");
                int choice = scanner.nextInt();
                    switch (choice) {
                        case 1 -> {
                            String name = viewEnterName();
                            String birthday = viewEnterBirthday();
                            String command = viewEnterCommand();
                            controller.createDog(name, birthday, command); // добавляем собаку
                        }
                        case 2 -> {
                            String name = viewEnterName();
                            String birthday = viewEnterBirthday();
                            String command = viewEnterCommand();
                            controller.createCat(name, birthday, command); // добавляем кошку
                        }
                        case 3 -> {
                            String name = viewEnterName();
                            String birthday = viewEnterBirthday();
                            String command = viewEnterCommand();
                            controller.createHamster(name, birthday, command); // добавляем хомяка
                        }
                        default -> System.out.println("Неверный выбор.");
                    }
                    return;
            }
    }

    //*ввод имени + проверка нового животного */
    private static String  viewEnterName(){
        String name = null;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Введите имя животного (имя недолжно повторяться): ");
            name = sc.nextLine();
            //проверка на пустоту
            if(name.isEmpty()){
                System.out.println("Пустое значение недопустимо!");
                continue;
            }
            //проверка на уникальность
            if(controller.contollerChekName(name)){
                System.out.print("Ошибка! Такое имя уже существует! ");
                continue;
            }
            return name;
        }
    }

    //*ввод даты нового животного */
    private static String  viewEnterBirthday(){
        String birthday = null;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Введите дату рождения животного: ");
            birthday = sc.nextLine();
            if(birthday.isEmpty()){
                System.out.println("Пустое значение недопустимо!");
                continue;
            }
            return birthday;
        }
    }

    //ввод команд нового животного*/
    private static String  viewEnterCommand(){
        String command = null;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Введите команды животного: ");
            command = sc.nextLine();
            if(command.isEmpty()){
                System.out.println("Пустое значение недопустимо!");
                continue;
            }
            return command;
        }
    }

    //*показать весь список животных */
    private static void viewShowAllAnimals() throws IOException {
        NewController controller = new NewController();
        controller.getListAnimal();
    }

    //*добавление команд*/
    private static void viewAddNewCommand() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите имя животного, которому будем добавлять команды: ");
        String name = sc.nextLine();
        System.out.print("Введите новые команды: ");
        String commands = sc.nextLine();
        controller.addNewCommand(name, commands);
    }

    public static void printConsole(String animal) {
        System.out.println(animal);
    }
}
