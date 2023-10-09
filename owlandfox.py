T = int(input())
out = []
for _ in range(T):
    n = input()
    s = [""] * len(n)
    flipped = False
    for i in range(len(n)-1, -1, -1):
        if flipped:
            s[i] = n[i]
        else:
            if n[i] == "0": s[i] = "0"
            else:
                s[i] = str(int(n[i])-1)
                flipped = True
    if sum([int(c) for c in s]) == 0:
        out.append("0")
    else:
        out.append("".join(s))
print("\n".join(out))