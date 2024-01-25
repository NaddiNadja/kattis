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
  def isSame(self, u, v):
    return self.find(u) == self.find(v)


n, m, q = map(int, input().split())
# islands, distrusting pairs, queries

uf = UnionFind(n+1)
distrusts = UnionFind(n+1)

for i in range(m):
    u, v = map(int, input().split())
    distrusts.union(u, v)

for i in range(q):
    u, v = map(int, input().split())
    if not distrusts.isSame(u,v) :
        print("APPROVE")
        distrusts.union(u, v)
    else:
       print("REFUSE")