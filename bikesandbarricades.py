n = int(input())
barricades = []
minimum = -1
for i in range(n):
  x1,y1,x2,y2 = map(int, input().split())

  if x1 < 0 and x2 < 0 or x1 > 0 and x2 > 0 or x1 == x2:
    # no intersection with y-axis
    continue

  leftmost = (x1, y1) if x1 < x2 else (x2, y2)
  rightmost = (x1, y1) if x1 > x2 else (x2, y2)
  a = (rightmost[1] - leftmost[1]) / (rightmost[0] - leftmost[0])
  b = leftmost[1] - a*leftmost[0]

  if b < 0:
    # intersection with y-axis is below 0
    continue
  elif minimum < 0 or b < minimum:
    minimum = b

print(minimum)
