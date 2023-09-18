inp = input().split()
h = int(inp[0])
root = 2**(h+1)-1
pos = 1

if len(inp) != 1: 
    s = inp[1]
    for i in range(len(s)):
        if s[i] == "L": pos = pos*2
        else: pos = pos*2+1

print(abs(pos-root)+1)