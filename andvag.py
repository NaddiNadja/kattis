class UnionFind:
  def __init__(self, N):
    self.parent = [i for i in range(N)]
    self.sz = [1]*N
    self.weights = [0]*N
  def find(self, i):
    path = []
    while i != self.parent[i]:
      path.append(i)
      i = self.parent[i]
    for u in path: self.parent[u] = i
    return i
  def union(self, u, v, w):
    uR, vR = map(self.find, (u, v))
    if self.sz[uR] < self.sz[vR]:
      self.parent[uR] = vR
      self.weights[vR] = w | self.weights[uR] | self.weights[vR]
      self.weights[uR] = w | self.weights[uR] | self.weights[vR]
      self.sz[vR] += self.sz[uR]
    else:
      self.parent[vR] = uR
      self.weights[vR] = w | self.weights[uR] | self.weights[vR]
      self.weights[uR] = w | self.weights[uR] | self.weights[vR]
      self.sz[uR] += self.sz[vR]
    return True


n,m,q = map(int, input().split())
uf = UnionFind(n)

for i in range(m):
  a,b,f = map(int, input().split())
  uf.union(a-1, b-1, f)

for i in range(q):
  start, end = map(int, input().split())
  if (uf.find(start-1) == uf.find(end-1)):
    w = uf.weights[uf.find(start-1)]
    print(bin(w).count("1"))
  else: print(-1)