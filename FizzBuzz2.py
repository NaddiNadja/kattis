n, m = list(map(int, input().split()))

def fizzbuzz(i):
    s = ''
    if i % 3 == 0:
        s += 'fizz'
    if i % 5 == 0:
        s += 'buzz'
    if i % 3 != 0 and i % 5 != 0:
        s += str(i)
    return s

def fizzbuzzErrors(s):
    inp = s.split()
    errors = abs(m-len(inp))

    for i in range(1,len(inp)+1):
        correct = fizzbuzz(i)
        if inp[i-1] != correct:
            errors += 1
    
    return errors

import sys
best = 1
minErrors = fizzbuzzErrors(input()) 
for i in range(2,n+1):
    err = fizzbuzzErrors(input())
    if minErrors > err:
        minErrors = err
        best = i

print(best)