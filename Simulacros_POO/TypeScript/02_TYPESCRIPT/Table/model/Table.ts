export class Table {
  id: number;
  material: string;
  color: string;
  dimensions: string;

  constructor(id: number, material: string, color: string, dimensions: string) {
    this.id = id;
    this.material = material;
    this.color = color;
    this.dimensions = dimensions;
  }
}
