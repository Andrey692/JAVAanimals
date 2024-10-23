package model;

public class Hamster extends Animal {
    private int hamsterId;

    public Hamster(int hamsterId, String birthday, String command, String name) {
        super(birthday, command, name);
        this.hamsterId = hamsterId;
    }

    public int getHamsterId() {
        return hamsterId;
    }

    public void setHamsterId(int hamsterId) {
        this.hamsterId = hamsterId;
    }

    @Override
    public String toString() {
        return  "name=" + name + ", type=hamster" +
                ", birthday=" + birthday +
                ", command=" + command;
    }
}
