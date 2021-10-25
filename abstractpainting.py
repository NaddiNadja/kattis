t = int(input())
out = []
for _ in range(t):
    r,c = list(map(int, input().split()))
    solution = 18 * 6**(r+c-2) * 2**((r-1)*(c-1))
    out.append(solution)
print("\n".join(str(int(x)) for x in out))