n = int(input())
out = []
for i in range(n):
    if i % 2 == 0:
        out.append(input())
    else:
        input()
print("\n".join(x for x in out))