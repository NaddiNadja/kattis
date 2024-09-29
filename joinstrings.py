import sys
n = int(input())
strings = []
for _ in range(n):
  line = sys.stdin.readline().strip()
  strings.append([line])
appends = []
for _ in range(n-1):
  a,b = map(int, sys.stdin.readline().split())
  appends.append((a-1, b-1))

for a, b in appends:
  strings[a] = strings[a]+strings[b]
  strings[b] = []

if len(appends) == 0:
  print("".join(strings[0]))
else:
  print("".join(strings[a]))