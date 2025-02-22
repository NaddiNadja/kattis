"""sum of the integers from 1 to n"""
n = int(input())

def sum_of_integers(n):
  return n*(n+1)//2

threes = sum_of_integers(n//3)*3
fives = sum_of_integers(n//5)*5 
fifteens = sum_of_integers(n//15)*15

print(threes + fives - fifteens)