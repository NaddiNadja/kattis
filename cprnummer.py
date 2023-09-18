cpr = list(input())
sum = 0
exp = [4,3,2,7,6,5,0,4,3,2,1]
for i in range(len(cpr)):
    if i != 6:
        sum += int(cpr[i]) * exp[i]
if sum % 11 == 0:
    print(1)
else:
    print(0)
