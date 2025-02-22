n = int(input())
follower = None
leader = None

class listnode:
  def __init__(self, x):
    self.val = x
    self.next = None
  
  def insertAfter(self, x):
    newnode = listnode(x)
    newnode.next = self.next
    self.next = newnode

def insertF(x):
  global follower
  cur = follower
  if cur == None:
    follower = listnode(x)
    return
  
  if cur.val > x:
    newnode = listnode(x)
    newnode.next = cur
    follower = newnode

  while cur and cur.next and cur.next.val < x:
    cur = cur.next
  cur.insertAfter(x)

def insertL(x):
  global leader
  cur = leader
  if cur == None:
    leader = listnode(x)
    return
  
  if cur.val > x:
    newnode = listnode(x)
    newnode.next = cur
    leader = newnode

  while cur and cur.next and cur.next.val < x:
    cur = cur.next
  cur.insertAfter(x)

for x in range(n):
  l, f = map(int, input().split())
  insertF(f)
  insertL(l)

  ls = leader
  fs = follower

  maximum = 0
  
  while ls and fs:
    dif = abs(fs.val - ls.val)
    if dif > maximum:
      maximum = dif
    ls = ls.next
    fs = fs.next
  print(maximum)
  