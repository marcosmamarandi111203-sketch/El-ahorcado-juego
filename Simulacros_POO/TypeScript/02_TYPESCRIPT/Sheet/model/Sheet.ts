export class Sheet {
  id: number;
  material: string;
  color: string;
  size: string;

  constructor(id: number, material: string, color: string, size: string) {
    this.id = id;
    this.material = material;
    this.color = color;
    this.size = size;
  }
}
