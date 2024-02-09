class UnionFind:
  def __init__(self, N):
    self.parent = [i for i in range(N)]
    self.sz = [1]*N
    self.N = N
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
  def groups(self):
    roots = [self.find(i) for i in range(self.N)]
    return len(set(roots))

n, m, k = map(int, input().split())
rows = [] # there are N rows
for _ in range(n):
  rows.append(input())

uf = UnionFind(k)

for i in range(m):
  u = ord(rows[0][i]) - ord("A")
  for j in range(1, n):
    v = ord(rows[j][i]) - ord("A")
    uf.union(u, v)
    u = v

print(uf.groups())