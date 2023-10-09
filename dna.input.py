from random import randint
n = 10**6
print(n)
out = []
for i in range(n):
    r = randint(1,10)
    if r % 2 == 0: out.append("B")
    else: out.append("A")

print("".join(out))

