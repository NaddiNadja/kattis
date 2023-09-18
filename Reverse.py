ls = []
for i in range(int(input())): ls.append(int(input()))
print('\n'.join(str(ls[abs(x-len(ls))-1]) for x in range(len(ls))))