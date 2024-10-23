package model;

public class Dog extends Animal {
    private int dogId;

    public Dog(int dogId, String birthday, String command, String name) {
        super(birthday, command, name);
        this.dogId = dogId;
    }

    public int getDogId() {
        return dogId;
    }

    public void setDogId(int dogId) {
        this.dogId = dogId;
    }

    @Override
    public String toString() {
        return  "name=" + name + ", type=dog" +
                ", birthday=" + birthday +
                ", command=" + command;
    }
}
