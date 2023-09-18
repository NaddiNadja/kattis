import sys

n = int(input())

length = int(input())

for inp in sys.stdin:
    l = int(inp)
    length += l-1

print(length)