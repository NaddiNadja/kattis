import sys
import itertools

out = []
for inp in sys.stdin:
    k, n = list(map(int, inp.split()))
    total = (k+1)**n

    if n == 1:
        out.append(str(100))
        continue

    cache = dict()
    def solve(s):
        if len(s) == 1:
            result = False
        elif abs(int(s[0])-int(s[1])) < 2:
            result = True
        else:
            result = solve(s[1:])
        cache[s] = result
        return result
    
    print(list(itertools.product([range(k+1) for i in range(n)])))
    print(str(k**n))