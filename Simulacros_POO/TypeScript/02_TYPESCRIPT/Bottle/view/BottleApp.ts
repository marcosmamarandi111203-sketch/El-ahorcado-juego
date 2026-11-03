import { Bottle } from '../model/Bottle';
import * as fs from 'node:fs';
import * as path from 'node:path';

const items: Bottle[] = [
  new Bottle(11, "Plastic", "Blue", 1.5),
  new Bottle(12, "Plastic", "Blue", 1.75),
  new Bottle(13, "Plastic", "Blue", 2.0)
];
const filePath = path.join(__dirname, '..', 'bottles.json');
fs.writeFileSync(filePath, JSON.stringify(items, null, 2), 'utf8');
console.log('Saved to:', filePath);
const restored: Bottle[] = JSON.parse(fs.readFileSync(filePath, 'utf8')).map(
  (item: Bottle) => new Bottle(item.id, item.material, item.color, item.capacity)
);
console.table(restored);
console.log('Found ID 12:', restored.find(item => item.id === 12) ?? 'Not found');
