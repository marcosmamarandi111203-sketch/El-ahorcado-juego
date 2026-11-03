import json
from pathlib import Path
from model.Bottle import Bottle
from dataclasses import asdict

items: list[Bottle] = [
    Bottle(11, 'Plastic', 'Blue', 1.5),
    Bottle(12, 'Plastic', 'Blue', 1.75),
    Bottle(13, 'Plastic', 'Blue', 2.0),
]
file_path = Path(__file__).resolve().parents[1] / 'bottles.json'
file_path.write_text(json.dumps([asdict(item) for item in items], indent=2), encoding='utf-8')
print('Saved to:', file_path)
restored = [Bottle(**item) for item in json.loads(file_path.read_text(encoding='utf-8'))]
for item in restored:
    print(item)
print('Found ID 12:', next((item for item in restored if item.id == 12), 'Not found'))
