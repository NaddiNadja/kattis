s = input()
k = int(input())

mincuts = []

for b in range(26):
  m = chr(ord("a")+b)
  i = 0
  cuts = 0
  while i < len(s):
    if s[i] != m:
      i += k
      cuts += 1
    else:
      i += 1
  mincuts.append(cuts)

print(min(mincuts))
