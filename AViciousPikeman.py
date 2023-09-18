n, T = list(map(int, input().split()))
a,b,c,t = list(map(int, input().split()))

problems = [0 for i in range(n)]
problems[0] = t
for i in range(1,n):
    t = ((a*t+b) % c) + 1
    problems[i] = t

problems.sort()

count = 0
totaltime = problems[0]
solved = 0
penalty = 0

while totaltime < T and count < n:
    count += 1
    solved += 1
    penalty = (penalty + totaltime) % 1000000007
    if (count<n): totaltime += problems[count]

print(str(solved) + " " + str(penalty))