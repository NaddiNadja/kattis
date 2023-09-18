import sys

n, m = map(int, input().split())

count = 2**n
forbiddenpairs = []

for inp in sys.stdin:
    a, b = map(int, inp.split())
    forbiddenpairs.append(2**(a-1) + 2**(b-1))

count = 0
for i in range(2**n):
    count+=1
    for j in forbiddenpairs:
        if j & i == j: 
            count-=1
            break
    
print(count)