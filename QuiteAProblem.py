import sys
out = []
for inp in sys.stdin:
    if "problem" in inp.lower(): out.append("yes")
    else: out.append("no")
print("\n".join(s for s in out))