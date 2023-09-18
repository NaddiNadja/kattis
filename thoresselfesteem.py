def longestcommonsubstring(s1, s2):
    substring = ''
    for i in range(min(len(s1), len(s2))):
        if s1[i] == s2[i]:
            substring += s1[i]
        else:
            break
    return substring

n = int(input())
position = 0
prefix = ''
for i in range(n):
    name = input()
    if name == 'ThoreHusfeldt':
        position = i
        break
    else:
        lcs = longestcommonsubstring(name, 'ThoreHusfeldt')
        if len(lcs) > len(prefix):
            prefix = lcs

if position == 0:
    print('Thore is awesome')
elif len(prefix) > 11:
    print('Thore sucks')
else:
    print(prefix+'ThoreHusfeldt'[len(prefix)])