n, s, m = [int(x) for x in input().split()]
board = [int(x) for x in input().split()]
visited = [False for _ in board]

cur = s-1
hops = 0

while 0 <= cur < n:
    if visited[cur]:
        print("cycle")
        break

    val = board[cur]
    visited[cur] = True
    if val == m:
        print("magic")
        break
    
    hops += 1
    cur += val

if cur < 0: print("left")
if cur >= n: print("right")
print(hops)