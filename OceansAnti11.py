import sys

cache = dict() #Memoization, dynamic programming
def fib(n):
    if n == 1 or n == 2:
        return 1
    elif n in cache:
        return cache[n]
    else:
        result = fib(n-1) + fib(n-2)
        cache[n] = result
        return result

T = int(input())
out = []
for inp in sys.stdin:
    out.append(fib(int(inp)+2) % 1000000007)

print("\n".join(str(i) for i in out))