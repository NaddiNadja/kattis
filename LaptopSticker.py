wc,hc,ws,hs = list(map(int, input().split()))

if wc-2 < ws or hc-2 < hs:
    print(0)
else:
    print(1)