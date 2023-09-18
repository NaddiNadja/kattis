k = int(input())
me = list(input())
friend = list(input())

same = 0

for i in range(len(me)):
    if me[i] == friend[i]: same+=1

out = len(me) - abs(same-k)
print(str(out))