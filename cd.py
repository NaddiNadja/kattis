import sys
n,m = map(int, sys.stdin.readline().split())
out = []
while not (n == m == 0):
    jack = set()
    for _ in range(n):
        jack.add(sys.stdin.readline())
    sum = 0
    for _ in range(m):
        if sys.stdin.readline() in jack: sum+=1
    out.append(sum)
    n,m = map(int, sys.stdin.readline().split())
print("\n".join([str(x) for x in out]))