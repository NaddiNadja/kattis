import sys
n, p, s = input().split()
out = []
for inp in sys.stdin:
    line = inp.split()
    keep = True
    if p not in line[1:]: keep = False

    if keep: out.append("KEEP")
    else: out.append("REMOVE")
print("\n".join(line for line in out))