import sys

top = input().split()
N = int(top[0])
# K = top[1]

ftree = [0] * (N+2)
mem = [0] * (N+1)
out = []

def fenwicksum(pos):
    pos += 1
    sum = 0
    while pos > 0:
        sum += ftree[pos]
        pos -= (pos & -pos)
    return sum

for inp in sys.stdin:
    if inp[0] == 'F':
        k = int(inp.split()[1])
        change = 1 - 2*mem[k]  # val - old   =   1 - mem[k] - mem[k] 
        mem[k] = 1 - mem[k]

        k += 1
        while k < len(ftree):
            ftree[k] += change
            k += (k & -k)
            
    else:
        inputlist = inp.split()
        l = int(inputlist[1])
        r = int(inputlist[2])
        out.append(fenwicksum(r)-fenwicksum(l-1))

print('\n'.join(str(i) for i in out))
