package model;

public class User {
    private final int id;
    private final String name;

    private static int idTemp = 0;

    public User(String name) {
        this.id = ++idTemp;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "id = " + id + ", name = " + name;
    }
}
