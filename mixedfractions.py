import sys
out = []
for line in sys.stdin:
    a,b = map(int, line.split())
    if a == b == 0:
        break
    out.append(f'{a//b} {a%b} / {b}')
print("\n".join(out))