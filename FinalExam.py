n = int(input())
import sys
prev = input()
total = 0
for inp in sys.stdin:
    inp = inp.strip()
    if inp == prev: total = total + 1
    prev = inp
print(total)