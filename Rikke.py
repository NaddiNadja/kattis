amount = int(input())
first = input().split()
lown, highn = first[0], first[0]
lowp, highp = int(first[1]), int(first[1])

while (lowp == highp):
    parts = input().split()
    name = parts[0]
    price = int(parts[1])
    if price < lowp:
        lown, lowp = name, price
    elif price > highp:
        highn, highp = name, price

while price == lowp or price == highp:
    parts = input().split()
    name = parts[0]
    price = int(parts[1])

if price < lowp:
    print(lown)
elif price > highp:
    print(highn)
else:
    print(name)