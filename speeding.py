n = int(input())
max = 0
prevt, prevd = list(map(int, input().split()))
for _ in range(n-1):
    t,d = list(map(int, input().split()))
    speed = (d-prevd)/(t-prevt)
    if speed > max:
        max = speed
    prevd = d
    prevt = t
print(int(max))