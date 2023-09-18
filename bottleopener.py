n = int(input())
k = int(input())

if k < n:
    out = []
    for i in range(k):
        out.append("open " + str(i+1) + " with " + str(n))
    print("\n".join(x for x in out))
else:
    print("impossible")