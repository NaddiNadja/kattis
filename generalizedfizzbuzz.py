n, a, b = map(int, input().split())

fizz, buzz, fizzbuzz = 0, 0, 0

for i in range(1, n+1):
  res = 0
  if (i % a == 0): res += 1 # fizz
  if (i % b == 0): res += 2 # buzz
  if (res == 1): fizz += 1
  if (res == 2): buzz += 1
  if (res == 3): fizzbuzz += 1

print(fizz, buzz, fizzbuzz)