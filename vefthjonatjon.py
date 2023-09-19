import sys
n = int(input())
cpu, mem, hd = 0,0,0
for line in sys.stdin:
    parts = line.split()
    if parts[0] == 'J': cpu += 1
    if parts[1] == 'J': mem += 1
    if parts[2] == 'J': hd += 1
print(min(cpu, min(mem, hd)))