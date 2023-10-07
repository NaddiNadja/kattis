s = input()

right = 0
sum = 0

for c in s:
    if c == '<':
        sum += right
    if c == '>':
        right += 1

print(sum)