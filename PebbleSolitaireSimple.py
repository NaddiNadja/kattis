def listToString(s):
    return "".join(c for c in s)

n = int(input())

cache = dict()
def play(s: list):
    numO = s.count('o')
    if "oo" not in s:
        return numO
    elif s in cache:
        return cache[s]
    else:
        temp = list(s)
        result = numO
        for pos in range(10):
            x = pos
            if s[x] == 'o' and s[x+1] == 'o' and s[x+2] == '-':
                temp[x] = '-'
                temp[x+1] = '-'
                temp[x+2] = 'o'
                if result > play(listToString(temp)): result = play(listToString(temp))
                temp = list(s)
        for pos in range(10):
            x = abs(pos-11)
            if s[x] == 'o' and s[x-1] == 'o' and s[x-2] == '-':
                temp[x] = '-'
                temp[x-1] = '-'
                temp[x-2] = 'o'
                if result > play(listToString(temp)): result = play(listToString(temp))
                temp = list(s)
        cache[s] = result
        return result
        
out = []
for _ in range(n):
    s = input()
    out.append(str(play(s)))
print("\n".join(res for res in out))