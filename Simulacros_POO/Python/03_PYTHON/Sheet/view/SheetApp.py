import json
from pathlib import Path
from model.Sheet import Sheet
from dataclasses import asdict

items: list[Sheet] = [
    Sheet(11, 'Paper', 'White', 'A4'),
    Sheet(12, 'Paper', 'White', 'A4'),
    Sheet(13, 'Paper', 'White', 'A4'),
]
file_path = Path(__file__).resolve().parents[1] / 'sheets.json'
file_path.write_text(json.dumps([asdict(item) for item in items], indent=2), encoding='utf-8')
print('Saved to:', file_path)
restored = [Sheet(**item) for item in json.loads(file_path.read_text(encoding='utf-8'))]
for item in restored:
    print(item)
print('Found ID 12:', next((item for item in restored if item.id == 12), 'Not found'))
