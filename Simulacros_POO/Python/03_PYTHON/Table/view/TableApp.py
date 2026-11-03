import json
from pathlib import Path
from model.Table import Table
from dataclasses import asdict

items: list[Table] = [
    Table(11, 'Wood', 'Brown', '1.5m x 0.8m'),
    Table(12, 'Glass', 'Transparent', '1.2m x 1.2m'),
    Table(13, 'Metal', 'Black', '2.0m x 1.0m'),
]
file_path = Path(__file__).resolve().parents[1] / 'tables.json'
file_path.write_text(json.dumps([asdict(item) for item in items], indent=2), encoding='utf-8')
print('Saved to:', file_path)
restored = [Table(**item) for item in json.loads(file_path.read_text(encoding='utf-8'))]
for item in restored:
    print(item)
print('Found ID 12:', next((item for item in restored if item.id == 12), 'Not found'))
