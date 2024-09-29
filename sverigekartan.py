from collections import defaultdict, deque

r = int(input())
c = int(input())
u = int(input())
S = (0,0)
sweden = []
for y in range(r):
  line = input()
  if 'S' in line: S = (line.index("S"), y)
  sweden.append([c for c in line])
changes = []
for _ in range(u):
  i,j = map(int, input().split())
  changes.append((i-1,j-1))

is_sweden = set()

def bfs(fr, graph, isinitial):
  global is_sweden
  visited = set()
  queue = deque()

  size = 0
  visited.add(fr)
  queue.append(fr)
  isConnected = False

  while queue:
    v = queue.popleft()
    size += 1
    adj = [(v[0]+1, v[1]), (v[0]-1, v[1]), (v[0], v[1]+1), (v[0], v[1]-1)]

    for u in adj:
      if u[0] < 0 or u[0] >= len(graph[0]): continue
      if u[1] < 0 or u[1] >= len(graph): continue
      if graph[u[1]][u[0]] == ".": continue
      if u in is_sweden:
        isConnected = True
      elif u not in visited:
        visited.add(u)
        queue.append(u)
  if isinitial or isConnected:
    is_sweden = is_sweden.union(visited)
    return size
  return 0

bfs(S, sweden, True)
print(len(is_sweden))
for change in changes:
  sweden[change[0]][change[1]] = "#"
  bfs((change[1],change[0]), sweden, False)
  print(len(is_sweden))
