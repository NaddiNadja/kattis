s = input()

ks = s.count('k')
bs = s.count('b')

if ks == 0 and bs == 0:
    print("none")
elif ks > bs:
    print("kiki")
elif ks < bs:
    print("boba")
else:
    print("boki")