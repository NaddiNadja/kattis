import sys 

sys.setrecursionlimit(1000000)

n, t = map(int, input().split())
buildings = []
for _ in range(n):
  p, c = map(int, input().split())
  buildings.append((p,c,c/p))

startmoney = buildings[0][0]
buildings.sort(key=lambda x: x[2], reverse=True)

opt = {}

def solve(tjener, har):
  if har >= t: return 0
  if (tjener, har) in opt: return opt[(tjener, har)]
  
  ny_har = tjener+har
  secs = solve(tjener, ny_har)

  for building in buildings:
    p, c, r = building
    if c > ny_har:
      continue
    ny_tjener = tjener+p
    secs = min(secs, solve(ny_tjener, ny_har-c))
    break

  
  opt[(tjener, har)] = secs+1
  return opt[(tjener, har)]

print(solve(startmoney, 0))