import { Person } from '../model/Person';
import * as fs from 'node:fs';
import * as path from 'node:path';

const items: Person[] = [
  new Person(11, "Ana", 20, "ana@example.com"),
  new Person(12, "Ana", 21, "ana@example.com"),
  new Person(13, "Ana", 22, "ana@example.com")
];
const filePath = path.join(__dirname, '..', 'persons.json');
fs.writeFileSync(filePath, JSON.stringify(items, null, 2), 'utf8');
console.log('Saved to:', filePath);
const restored: Person[] = JSON.parse(fs.readFileSync(filePath, 'utf8')).map(
  (item: Person) => new Person(item.id, item.name, item.age, item.email)
);
console.table(restored);
console.log('Found ID 12:', restored.find(item => item.id === 12) ?? 'Not found');
