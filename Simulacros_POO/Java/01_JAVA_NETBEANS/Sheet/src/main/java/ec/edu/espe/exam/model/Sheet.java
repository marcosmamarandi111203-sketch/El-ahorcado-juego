package ec.edu.espe.exam.model;

public class Sheet {
    private int id;
    private String material;
    private String color;
    private String size;

    public Sheet(int id, String material, String color, String size) {
        this.id = id;
        this.material = material;
        this.color = color;
        this.size = size;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public String getSize() { return size; }
    public void setSize(String size) { this.size = size; }

    @Override
    public String toString() {
        return "Sheet{" + "id=" + id + ", " + "material=" + material + ", " + "color=" + color + ", " + "size=" + size + "}";
    }
}
