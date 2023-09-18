import math
D = int(input())

i = 0
while i < 200000:
    j = i+1
    while j*j - i*i < D:
        j += 1
    if j*j - i*i == D:
        print(str(i) + " " + str(j))
        exit()
    else: i += 1

print("impossible")