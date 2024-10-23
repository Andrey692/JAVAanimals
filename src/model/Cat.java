package model;

public class Cat extends Animal {
    private int catId;

    public Cat(int catId, String birthday, String command, String name) {
        super(birthday, command, name);
        this.catId = catId;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    @Override
    public String toString() {
        return  "name=" + name + ", type=cat" +
                ", birthday=" + birthday +
                ", command=" + command;
    }
}
