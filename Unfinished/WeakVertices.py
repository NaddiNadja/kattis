import sys
for inp in sys.stdin:
    n = int(input())
    matrix = []*n
    for i in range(n):
        matrix[i] = input().split()
    out = []
    for i in range(n):
        weak = True
        for j in range(n):
            if matrix[i][j] == 1:
                break