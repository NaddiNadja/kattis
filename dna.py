n = int(input())
s = input()

moves = 0
avalue = 'A'

for i in range(len(s)-1, -1, -1):
    if s[i] == avalue: 
        continue
    moves += 1
    if s[i-1] != avalue:
        avalue = 'A' if avalue == 'B' else 'B'
    
print(moves)