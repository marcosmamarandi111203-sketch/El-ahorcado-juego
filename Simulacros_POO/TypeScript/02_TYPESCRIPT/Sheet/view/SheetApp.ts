import { Sheet } from '../model/Sheet';
import * as fs from 'node:fs';
import * as path from 'node:path';

const items: Sheet[] = [
  new Sheet(11, "Paper", "White", "A4"),
  new Sheet(12, "Paper", "White", "A4"),
  new Sheet(13, "Paper", "White", "A4")
];
const filePath = path.join(__dirname, '..', 'sheets.json');
fs.writeFileSync(filePath, JSON.stringify(items, null, 2), 'utf8');
console.log('Saved to:', filePath);
const restored: Sheet[] = JSON.parse(fs.readFileSync(filePath, 'utf8')).map(
  (item: Sheet) => new Sheet(item.id, item.material, item.color, item.size)
);
console.table(restored);
console.log('Found ID 12:', restored.find(item => item.id === 12) ?? 'Not found');
