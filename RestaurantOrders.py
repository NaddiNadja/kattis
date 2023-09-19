n = int(input())
c = list(map(int, input().split()))
m = int(input())
orders = list(map(int, input().split()))

for s in orders:
    cache = dict()

    def solve(x):
        if x == 0:
            return 0
        

