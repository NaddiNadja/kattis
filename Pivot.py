n = input()
a = input().split()
count = 0
for i in range(len(a)):
    pivot = True
    x = int(a[i])
    j = 0
    while j < i:
        if int(a[j]) > x: pivot = False
        j += 1
    j = i+1
    while j < len(a):
        if int(a[j]) < x: pivot = False
        j += 1
    if pivot: count += 1
print(count)