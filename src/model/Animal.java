package model;

public abstract  class Animal {
    protected  String name;
    protected  String birthday;
    protected  String command;

    public Animal(String name, String birthday, String command) {
        this.name = name;
        this.birthday = birthday;
        this.command = command;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }
}
