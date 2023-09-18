t = int(input())
import sys
out = []
for inp in sys.stdin:
    turtles = list(map(int, inp.split()))
    before = 1
    total = 0
    for turt in turtles:
        if before*2 < turt:
            total = total + (turt - before*2)
        before = turt
    out.append(total)
print("\n".join(str(x) for x in out))