from collections import deque, defaultdict


n, q = map(int, input().split())
graph = defaultdict(list)
for i in range (n+1):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)

def bfsPath(graph, fr, to):
  visited = set()
  queue = deque()
  
  visited.add(fr)
  # queue holds elements and path to this element.
  queue.append((fr, [fr]))

  while queue:
    v, path = queue.popleft()
    visited.add(v)
    
    for u in graph[v]:
      if u not in visited:
        visited.add(u)
        new_path = path + [u]
        if u == to:
            return new_path
        queue.append((u, new_path))
    
  return None

def dfsCycle(graph, fr):
    queue = deque()
    # queue holds elements and path to this element.
    queue.append((fr, [fr]))

    while queue:
        v, path = queue.pop()
        
        for u in graph[v]:
            if u not in path:
                new_path = path + [u]
                queue.append((u, new_path))
            elif u != path[-2]:
                path.index(u)
                graph[v].remove(u)
                graph[u].remove(v)
                return path[path.index(u):]

cycle1 = set(dfsCycle(graph, 1))
cycle2 = set(dfsCycle(graph, 1))

c_intersection = cycle1.intersection(cycle2)
has_third_cycle = len(c_intersection) >= 2

c1_unique = cycle1 - cycle2
if len(c1_unique) == 0 or not has_third_cycle: c1_unique = cycle1

c2_unique = cycle2 - cycle1
if len(c2_unique) == 0 or not has_third_cycle: c2_unique = cycle2



print(cycle1, cycle2)
print(has_third_cycle)

for i in range(q):
    u, v = map(int, input().split())
    path = bfsPath(graph, u, v)
    blabla = [0, 0, 0] # is in cycle1, is in cycle2, is inboth
    for vertex in path:
        if vertex in c_intersection and blabla[2] == 0:
            blabla[2] = 1
        elif vertex in c1_unique and blabla[0] == 0:
            blabla[0] = 1
        elif vertex in c2_unique and blabla[1] == 0:
            blabla[1] = 1
    if has_third_cycle:
        print(1+sum(blabla))
    else:
        print(1+sum(blabla[:-1]))