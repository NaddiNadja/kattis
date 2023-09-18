n, m, s, d = list(map(int, input().split()))
c = list(map(int, input().split()))
mp = {}

for i in range(int(s)):
    mp[i] = c[i]

sorted = {k: v for k, v in sorted(mp.items(), key=lambda item: item[1])}
keys = list(sorted.keys())
put = {}
pos = 0
while n>0 and pos<len(keys):
    insert = d - sorted[keys[pos]]
    n -= insert
    if n<0: insert += n
    put[keys[pos]] = insert
    pos+=1

if n > 0:
    print("impossible")
    exit()

sum = 0
while pos<len(keys):
    sum += sorted[keys[pos]]
    pos+=1

if sum < m:
    print("impossible")
    exit()

out = []

for i in range(s):
    if i in put: out.append(put[i])
    else: out.append(0)

print(" ".join(str(x) for x in out))