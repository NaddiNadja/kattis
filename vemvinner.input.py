from random import randint

def get(i):
    if i == 0: return "_"
    if i == 1: return "X"
    if i == 2: return "O"

for x in range(3):
    print(f'{get(randint(0,2))} {get(randint(0,2))} {get(randint(0,2))}')

print()