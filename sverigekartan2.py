class UnionFind:
  def __init__(self, N):
    self.parent = [i for i in range(N)]
    self.sz = [1]*N
  def find(self, i):
    path = []
    while i != self.parent[i]:
      path.append(i)
      i = self.parent[i]
    for u in path: self.parent[u] = i
    return i
  def union(self, u, v):
    uR, vR = map(self.find, (u, v))
    if uR == vR: return False
    if self.sz[uR] < self.sz[vR]:
      self.parent[uR] = vR
      self.sz[vR] += self.sz[uR]
    else:
      self.parent[vR] = uR
      self.sz[uR] += self.sz[vR]
    return True
  def size(self, i):
    return self.sz[self.find(i)]

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
uf = UnionFind(r*c)

for y in range(r):
  for x in range(c):
    adj = [(x+1, y), (x-1, y), (x, y+1), (x, y-1)]
    for x1, y1 in adj:
      if x1 < 0 or x1 >= len(sweden[0]): continue
      if y1 < 0 or y1 >= len(sweden): continue
      if sweden[y][x] not in "#S" or sweden[y1][x1] not in "#S": continue
      uf.union(y*c+x, y1*c+x1)

print(uf.size(S[1]*c+S[0]))
for y, x in changes:
  sweden[y][x] = "#"
  adj = [(x+1, y), (x-1, y), (x, y+1), (x, y-1)]
  for x1, y1 in adj:
    if x1 < 0 or x1 >= len(sweden[0]): continue
    if y1 < 0 or y1 >= len(sweden): continue
    if sweden[y][x] not in "#S" or sweden[y1][x1] not in "#S": continue
    uf.union(y*c+x, y1*c+x1)
  print(uf.size(S[1]*c+S[0]))
