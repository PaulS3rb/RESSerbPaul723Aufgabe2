package model;

public class Entity {
    int id;

    @Override
    public String toString() {
        return "Entity{" +
                "id=" + id +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public Entity(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
