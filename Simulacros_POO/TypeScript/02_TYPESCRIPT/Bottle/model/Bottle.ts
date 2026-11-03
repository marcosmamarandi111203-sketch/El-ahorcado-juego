export class Bottle {
  id: number;
  material: string;
  color: string;
  capacity: number;

  constructor(id: number, material: string, color: string, capacity: number) {
    this.id = id;
    this.material = material;
    this.color = color;
    this.capacity = capacity;
  }
}
