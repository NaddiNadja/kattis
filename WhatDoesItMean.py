import sys
inp = input().split()
w = inp[1]

d = dict()

for inp in sys.stdin:
    inp = inp.split()
    d[inp[0]] = int(inp[1])

cache = dict()
def findprefix(s):
    meanings = 0
    if s in cache: 
        return cache[s]
    for i in range(1, len(s)-1):
        if s[:i] in d:
            temp = d[s[:i]]*findprefix(s[i:])
            meanings += temp
    if s in d: meanings+=d[s]
    cache[s] = meanings
    return meanings

print(findprefix(w))