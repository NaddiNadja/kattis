n = int(input())
board = [int(x) for x in input().split()]

sum = 0

for s in range(1, n+1):
    for m in board:
        visited = [False for _ in board]
        cur = s-1
        hops = 0

        while 0 <= cur < n:
            if visited[cur]:
                break

            val = board[cur]
            visited[cur] = True
            if val == m:
                sum += 1
                break
            
            hops += 1
            cur += val

print(sum)