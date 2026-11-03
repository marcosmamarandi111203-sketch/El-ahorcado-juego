import json
from pathlib import Path
from model.Person import Person
from dataclasses import asdict

items: list[Person] = [
    Person(11, 'Ana', 20, 'ana@example.com'),
    Person(12, 'Ana', 21, 'ana@example.com'),
    Person(13, 'Ana', 22, 'ana@example.com'),
]
file_path = Path(__file__).resolve().parents[1] / 'persons.json'
file_path.write_text(json.dumps([asdict(item) for item in items], indent=2), encoding='utf-8')
print('Saved to:', file_path)
restored = [Person(**item) for item in json.loads(file_path.read_text(encoding='utf-8'))]
for item in restored:
    print(item)
print('Found ID 12:', next((item for item in restored if item.id == 12), 'Not found'))
