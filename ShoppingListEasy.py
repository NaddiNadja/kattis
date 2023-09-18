nm = input().split()
ls = input().split()
ls.sort()
include = [True for i in range(int(nm[1]))]
for i in range (1,int(nm[0])):
    inp = input()
    for i in range (int(nm[1])):
        if ls[i] not in inp: 
            include[i] = False
count = 0
for b in include: 
    if b == True: 
        count+=1
print(count)
for i in range (int(nm[1])): 
    if include[i] == True:
        print(ls[i])
