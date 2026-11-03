import { Table } from '../model/Table';
import * as fs from 'node:fs';
import * as path from 'node:path';

const items: Table[] = [
  new Table(11, "Wood", "Brown", "1.5m x 0.8m"),
  new Table(12, "Glass", "Transparent", "1.2m x 1.2m"),
  new Table(13, "Metal", "Black", "2.0m x 1.0m")
];
const filePath = path.join(__dirname, '..', 'tables.json');
fs.writeFileSync(filePath, JSON.stringify(items, null, 2), 'utf8');
console.log('Saved to:', filePath);
const restored: Table[] = JSON.parse(fs.readFileSync(filePath, 'utf8')).map(
  (item: Table) => new Table(item.id, item.material, item.color, item.dimensions)
);
console.table(restored);
console.log('Found ID 12:', restored.find(item => item.id === 12) ?? 'Not found');
