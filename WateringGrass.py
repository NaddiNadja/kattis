import sys


for inp in sys.stdin:
    n,l,w = list(map(int, inp.split()))
    sprinklers = []
    # n sprinklers, l meters long, w meters wide
    for _ in range(n):
        x, r = list(map(int, inp.split()))
        # x is position, r is radius
    