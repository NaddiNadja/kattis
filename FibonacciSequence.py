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