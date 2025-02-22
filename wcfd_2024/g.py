from collections import defaultdict,deque

n = int(input())
ns = []
for _ in range(n):
  inp = input().split()
  ns.append((inp[0], inp[2:]))
g = int(input())
gs = []
for _ in range(g):
  inp = input().split()
  gs.append((inp[0], int(inp[1]), inp[3:]))
t = int(input())
ts = []
for _ in range(t):
  inp = input().split()
  ts.append((inp[0], int(inp[1]), inp[3:]))

source = 0
terminal = n+g+t+1

def buildNetworkGraph():
  adj_graph = defaultdict(defaultdict)
  
  for gname, gnum, gall in gs:
    adj_graph[source][gname] = gnum
    for nname, nall in ns:
        if all(x not in nall for x in gall):
          adj_graph[gname][nname+"s"] = 10

  for nname, nall in ns:
    adj_graph[nname+"s"][nname] = 1
  
  for tname, tnum, tall in ts:
    adj_graph[tname][terminal] = tnum
    for nname, nall in ns:
        if all(x not in nall for x in tall):
          adj_graph[nname][tname] = 10
  
  return adj_graph

networkGraph = buildNetworkGraph()


def dfs(graph, fr, to): # O(e+v)
    queue = deque()
    visited = set()

    queue.append(([fr], 10*9, fr)) # add path to this v, minimum edge, and v
    visited.add(fr)

    while queue:
        path, min_flow, u = queue.popleft()
        for v in graph[u]:
            if v not in visited and graph[u][v] > 0: 
                visited.add(v)
                new_path = path + [v]
                new_min_flow = min(min_flow, graph[u][v])
                if v == to: 
                    return new_path, new_min_flow
                queue.append((new_path, new_min_flow, v))
    return None, 0

def fordfulkerson(graph, source, sink):
  """ graph is 2d-array network graph with graph[u][v] = 
  cap describing an edge from u, v. """
  maxflow = 0
  
  while True: 
    path, minflow = dfs(graph, source, sink)
    if path is None:
      return maxflow
    maxflow += minflow
    for i in range(len(path)-1):
      fr = path[i]
      to = path[i+1]
      graph[fr][to] -= minflow
      
      if fr != source and to != sink: 
        if fr in graph[to]: 
          graph[to][fr] += minflow
        else: 
          graph[to][fr] = minflow

print(fordfulkerson(networkGraph, source, terminal))