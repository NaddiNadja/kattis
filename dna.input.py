from random import randint
n = 10**6
print(n)
out = []

def getCharAllB():
    return "B"

def getCharAllA():
    return "A"

def getCharRandom():
    r = randint(1,10)
    if r % 2 == 0: return "B"
    else: return "A"

def getCharAlternating(i):
    if i % 2 == 0: return "B"
    else: return "A"

for i in range(n):
    out.append(getCharRandom())
    # out.append(getCharAllB())
    #out.append(getCharAlternating(i))


print("".join(out))

