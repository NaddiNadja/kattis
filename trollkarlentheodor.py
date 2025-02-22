import math 
n, s, a = map(int, input().split())
hs = list(map(int, input().split()))
lo = 1
hi = sum(hs) 

def roundup(x):
  return math.ceil(x / s) * s

def canitbedone(rounds):
  baselife = list(map(lambda x: x - rounds * a, hs))
  baselife = list(filter(lambda x: x > 0, baselife))
  baselife = list(map(roundup, baselife))
  lifeleft = sum(baselife)
  if lifeleft <= rounds*s:
    return True 
  return False

def bisect_right(lo, hi):
  while lo < hi:
    mid = (lo + hi) // 2
    if canitbedone(mid):
      hi = mid
    else:
      lo = mid + 1
  return lo

print(bisect_right(lo,hi))