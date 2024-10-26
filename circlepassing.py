from collections import defaultdict, deque

class IndexedMinPQ:
  def __init__(self,N):
    self.N = N
    self.key = [None for _ in range(self.N)]
    self.pq = [None for _ in range(self.N+1)]
    self.qp =[None for _ in range(self.N)]
    self.total = 0

  def insert(self,i,key):
    assert type(i) is int
    if i >= self.N:
      raise IndexError('index is out of the range of PQ.')
    if self.key[i] is not None:
      raise IndexError('index is already in the PQ.')
    self.total += 1
    self.key[i] = key
    self.pq[self.total] = i
    self.qp[i] = self.total
    self.__swim(self.total)

  def __swim(self,i):
    par_i = i//2 # parent of i

    while par_i > 0 :
      key = self.key[self.pq[i]]
      parent_key = self.key[self.pq[par_i]]
      if parent_key < key:
        break
      self.pq[i], self.pq[par_i] = self.pq[par_i], self.pq[i]
      self.qp[self.pq[i]], self.qp[self.pq[par_i]] = self.qp[self.pq[par_i]],self.qp[self.pq[i]]
      i = par_i
      par_i = i // 2

  def deleteMin(self):
    if not self.isEmpty():
      out = self.pq[1]
      self.key[self.pq[1]] = None
      self.qp[self.pq[1]] = None
      self.pq[1] = self.pq[self.total]
      self.qp[self.pq[1]] = 1
      self.pq[self.total] = None
      self.total -= 1
      self.__sink(1)
      return out
    raise IndexError('IndexedMinPQ is empty.')

  def __sink(self,i):
    chi_i = i * 2 # child of i
    if chi_i <= self.total:
      key = self.key[self.pq[i]]
      child_key = self.key[self.pq[chi_i]]
      other_child = chi_i + 1
      if other_child <= self.total:
        other_child_key =  self.key[self.pq[other_child]]
        if other_child_key < child_key:
          chi_i = other_child
          child_key = other_child_key
      if child_key < key:
        self.pq[i], self.pq[chi_i] = self.pq[chi_i], self.pq[i]
        self.qp[self.pq[i]], self.qp[self.pq[chi_i]] = self.qp[self.pq[chi_i]], self.qp[self.pq[i]]
        self.__sink(chi_i)

  def isEmpty(self):
    return self.total == 0

  def decreaseKey(self,i,key):
    if i < 0 or i > self.N:
      raise IndexError('index i is not in the range.')
    if self.key[i] is None:
      raise IndexError('index i is not in the PQ.')
    assert type(i) is int
    assert key < self.key[i]
    self.key[i] = key
    self.__swim(self.qp[i])



n, m, q = map(int, input().split())
ks = list(map(int, input().split()))
graph = defaultdict(list)
for i in range(2*n):
  left = i+1 if i+1 < 2*n else 0
  right = i-1 if i-1 >= 0 else 2*n-1
  graph[i] = [left, right]
for k in ks:
  a, b = k, k+n
  graph[a].append(b)
  graph[b].append(a)


def dijkstra(graph, s, t):
  n = len(graph)
  dist = [float('inf')] * n
  pathTo = [None] * n
  pq = IndexedMinPQ(n)
  for v in graph:
    pq.insert(v, dist[v])
  
  dist[s] = 0
  pq.decreaseKey(s, 0)

  while not pq.isEmpty():
    v = pq.deleteMin()
    if v == t:
      break
    neighbours = graph[v]
    for u in neighbours:
      weight = 1
      if dist[v] + weight < dist[u]:
        dist[u] = dist[v] + weight
        pathTo[u] = v
        pq.decreaseKey(u, dist[u] + min(abs(u-t), abs(2*n-(u-t))))

  path = deque()
  cur = t
  while cur != s:
    if pathTo[cur] == None:
      return None
    path.appendleft(cur)
    cur = pathTo[cur]
  return path

out = []
for i in range(q):
  x, y = map(int, input().split())
  out.append(len(dijkstra(graph, x, y)))

print("\n".join(map(str, out)))