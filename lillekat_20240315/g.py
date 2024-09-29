from collections import defaultdict
n, m = map(int, input().split())
gin = defaultdict(list)
gout = defaultdict(list)
for i in range(m):
  a, b = map(int, input().split())
  gin[b].append(a)
  gout[a].append(b)
  gout[b]

out = []

start = 0
while gout:
  if start == 0:
    for b in gout:
      if len(gin[b]) == 0:
        start = b
        break
  if start == 0:
    print("IMPOSSIBLE")
    exit()
  out.append(start)
  newstart = 0
  for b in gout[start]:
    gin[b].remove(start)
    if len(gin[b]) == 0:
      newstart = b
  del gout[start]
  start = newstart

print("\n".join(map(str, out)))