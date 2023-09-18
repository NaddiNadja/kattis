n = int(input())


def fib(f2, f1, i):
    if i == n:
        return f2+f1+1
    else:
        return fib(f1, f2+f1+1, i+1)

if n == 1: print(1)
elif n == 2: print(2)
else: 
    f2 = 1
    f1 = 2
    i = 2
    while i < n:
         oldf2 = f2
         f2 = f1
         f1 = oldf2+f1+1
         i += 1
    print(f1 % (10**9+7))