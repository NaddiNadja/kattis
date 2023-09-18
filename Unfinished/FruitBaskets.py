n = int(input())
ls = list(map(int,input().split()))
ls.sort()
totalweight = 0
for i in ls:
    totalweight += i*2**(n-1)


for i in range(len(ls)):
    val = ls[i]
    totalweight -= val
    pos = i+1
    for j in range(pos,len(ls)):
        for k in range(len(ls)-j):
            val += ls[pos+k]
            if val < 200:
                totalweight -= val
            else:
                break

print(totalweight)