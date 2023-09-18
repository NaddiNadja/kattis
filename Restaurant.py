import sys

n = int(input())
s1, s2 = 0, 0

out = []

for inp in sys.stdin:
    i = inp.split()
    if (i[0] == "DROP"):
        m = int(i[1])
        s1 += m
        out.append("DROP 2 " + i[1])
    elif (i[0] == "TAKE"):
        m = int(i[1])
        if (s2 == 0):
            s2 += s1
            s1 -= s1
            out.append("MOVE 2->1 " + str(s2))
        elif (s2 < m):
            out.append("TAKE 1 " + str(s2))
            m -= s2
            s2 = s1
            s1 -= s1
            out.append("MOVE 2->1 " + str(s2))
        s2 -= m
        out.append("TAKE 1 " + str(m))
    else:
        n = int(inp)
        if n == 0: break
        out.append('')
        s1, s2 = 0, 0
print('\n'.join(out[x] for x in range(len(out))))

