import sys
import time

start_time = time.time()    

sys.setrecursionlimit(2_000_000)

n = int(input())
s = input()

opt = {}

def solve(s, i, flipped):
    if (i, flipped) in opt: 
        return opt[(i, flipped)] 
    if i < 0: 
        return 0

    cur = s[i] 
    if cur == 'A' and not flipped or cur == 'B' and flipped:
        result = solve(s, i-1, flipped)
    else:
        fliponce = 1 + solve(s, i-1, flipped)
        flipall = 1 + solve(s, i-1, not flipped)
        result = fliponce if fliponce < flipall else flipall
    opt[(i, flipped)] = result
    return result

print(solve(s, n-1, False))

print("--- %s seconds ---" % (time.time() - start_time))