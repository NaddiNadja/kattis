from decimal import Decimal as D
import sys
sys.setrecursionlimit(10**6)

l, xn, xd, yn, yd, zn, zd = map(int, input().split())

if l == 0:
  print(1)
  exit()

def find(cur, frac: D):
  third = D(1) / D(3)
  if frac <= third:
    # first third
    if cur == l - 1:
      return 1
    return find(cur+1, frac * 3)
  if 2*third < frac:
    # third third
    if cur == l - 1:
      return 3
    return find(cur+1, (frac-2*third)*3)
  # second third
  if cur == l - 1:
    return 2
  return find(cur+1, (frac-third)*3)
  
x = find(0, D(xn)/D(xd))
y = find(0, D(yn)/D(yd))
z = find(0, D(zn)/D(zd))

if x == 1 or x == 3:
  if y == 2 and z == 2:
    print(0)
  else:
    print(1)
  exit()

if y == 1 or y == 3:
  if z == 2:
    print(0)
  else:
    print(1)
  exit()

print(0)