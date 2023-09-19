s = input()
sum = 0
for c in s:
    if c.upper() in ['A','E','I','O','U']:
        sum += 1
print(sum)