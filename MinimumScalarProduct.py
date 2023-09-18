import sys

t = int(input())
case = 1
out = []
for _ in range(t):
    n = int(input())
    v1 = list(map(int, input().split()))
    v1.sort()
    v2 = list(map(int, input().split()))
    v2.sort()
    pos1, pos2 = 0, n-1
    result = 0
    for _ in range(n):
        result += v1[pos1]*v2[pos2]
        pos1 += 1
        pos2 -= 1
    out.append("Case #" + str(case) + ": " + (str(result)))
    case += 1
print("\n".join(i for i in out))

