inp = input()
set = []
for c in inp:
    if c in set:
        print(0)
        exit(0)
    set.append(c)
print(1)