from random import randrange

n = 20
c = [0]*n
for color in range(1, n):
    start = randrange(1, n)
    end = randrange(start, n)
    num = c[start]
    for i in range(start, end):
        if c[i] != num:
            break
        else:
            c[i] = color

uniq = set(c)
colors = {x:y for x, y in zip(uniq, range(1, len(uniq)+1))}

for i in range(n):
    c[i] = colors[c[i]]

print(str(n))
print(' '.join(map(str, c)))