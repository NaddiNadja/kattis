inp = input()
cur = 'P'
days = 0;

for c in inp:
    if c != cur: days = days + 1
    if cur == 'P': cur = 'E'
    elif cur == 'E': cur = 'R'
    else: cur = 'P'

print(days)