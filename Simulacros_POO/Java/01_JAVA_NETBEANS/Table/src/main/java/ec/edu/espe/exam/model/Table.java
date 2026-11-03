package ec.edu.espe.exam.model;

public class Table {
    private int id;
    private String material;
    private String color;
    private String dimensions;

    public Table(int id, String material, String color, String dimensions) {
        this.id = id;
        this.material = material;
        this.color = color;
        this.dimensions = dimensions;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public String getDimensions() { return dimensions; }
    public void setDimensions(String dimensions) { this.dimensions = dimensions; }

    @Override
    public String toString() {
        return "Table{" + "id=" + id + ", " + "material=" + material + ", " + "color=" + color + ", " + "dimensions=" + dimensions + "}";
    }
}
