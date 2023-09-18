import sys

n = int(input())
prices = [int(x) for x in input().split()]
q = int(input())

i = 0
lines = []
for line in sys.stdin:
    i += 1
    lines.append(line.split())
    if i == q:
        break

d = {}
out = []

totalamountofinflation = 0

for p in prices:
    if p in d:
        d[p] += 1
    else:
        d[p] = 1

lastsum = 0
for price, amount in d.items():
    lastsum += amount*(price+totalamountofinflation)

for line in lines:    
    if line[0] == "SET":
        set_from = int(line[1]) - totalamountofinflation
        set_to = int(line[2]) - totalamountofinflation
        if set_from in d:
            lastsum = lastsum + (d[set_from]*(int(line[2])-int(line[1])))
            old = d[set_from]
            d[set_from] = 0
            if set_to in d:
                d[set_to] += old
            else:
                d[set_to] = old
    elif line[0] == "INFLATION":
        totalamountofinflation += int(line[1])
        lastsum = lastsum + len(prices)*int(line[1])
    
    out.append(lastsum)

print("\n".join([str(sum) for sum in out]))
    