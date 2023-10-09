v = int(input())
n = int(input())
out = []
for _ in range(n):
    s, k = input().split()
    k = int(k)
    out.append(f'{s} {"opin" if int(k) >= v else "lokud"}')
print("\n".join(out))