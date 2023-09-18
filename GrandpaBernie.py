m = {}
n = int(input())
for i in range(n):
    inp = input().split()
    # s = inp[0]
    # y = inp[1]
    if inp[0] not in m:
        m[inp[0]] = []
    m[inp[0]].append(int(inp[1]))
q = int(input())
for s in m:
    m[s].sort()
printls = []
for i in range(q):
    inp = input().split()
    # s = inp[0]
    # k = inp[1]
    printls.append(m[inp[0]][int(inp[1])-1])
print('\n'.join(str(printls[x]) for x in range(q)))