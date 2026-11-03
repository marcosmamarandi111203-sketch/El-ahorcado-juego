package ec.edu.espe.exam.model;

public class Bottle {
    private int id;
    private String material;
    private String color;
    private double capacity;

    public Bottle(int id, String material, String color, double capacity) {
        this.id = id;
        this.material = material;
        this.color = color;
        this.capacity = capacity;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public double getCapacity() { return capacity; }
    public void setCapacity(double capacity) { this.capacity = capacity; }

    @Override
    public String toString() {
        return "Bottle{" + "id=" + id + ", " + "material=" + material + ", " + "color=" + color + ", " + "capacity=" + capacity + "}";
    }
}
