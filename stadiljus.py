n = int(input())
x = int(input())
y = int(input())
ls = list(map(int, input().split()))
ls.sort()
total_paid = 0
i = 0
while i<len(ls) and (total_paid+ls[i]*x)/(i+1) <= y:
  total_paid += ls[i]*x
  i+=1
print(i)