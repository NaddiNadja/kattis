from collections import defaultdict

n = int(input())
lists = 1
out = []
while n != 0:
    animals = defaultdict(int)
    for i in range(n):
        animals[input().split()[-1].lower()] += 1
    sorted = list(animals.keys())
    sorted.sort()
    listed_animals = []
    for animal in sorted:
        listed_animals.append(f'{animal} | {animals[animal]}')
    s = "\n".join(listed_animals)
    out.append(f'List {lists}:\n{s}')
    lists += 1
    n = int(input())
print("\n".join(out))