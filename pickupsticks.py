n, m = [int(x) for x in input().split()]

ontopof = {} #adj graph
below = {}
indegree = {}

for i in range(1, n+1):
    ontopof[i] = set()
    below[i] = set()

for i in range(m):
    a, b = [int(x) for x in input().split()]
    ontopof[a].add(b)
    below[b].add(a)

for i in range(1, n+1):
    indeg = len(below[i])
    if indeg in indegree:
        indegree[indeg].append(i)
    else:
        indegree[indeg] = [i]

def reducedegree(i):
    indegree[len(below[i])].remove(i)
    indeg = len(below[i])-1
    if indeg in indegree:
        indegree[indeg].append(i)
    else:
        indegree[indeg] = [i]

ontop = -1
order = []
while ontop == -1:
    if len(order) == n:
        print("\n".join([str(i) for i in order]))
        exit(0)

    if 0 in indegree and len(indegree[0]) > 0:
        ontop = indegree[0][0]
        indegree[0].pop(0)

    if ontop == -1: 
        print("IMPOSSIBLE")
        exit(0)
    
    while ontop != -1:
        order.append(ontop)
        allbelow = ontopof[ontop]
        next = -1
        for i in allbelow:
            reducedegree(i)
            below[i].remove(ontop)
            if len(below[i]) == 0:
                next = i
        if next != -1: below.pop(next)
        ontop = next