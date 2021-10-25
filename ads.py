h,w = list(map(int, input().split()))
regex = r'[^a-zA-Z0-9?!,. +]'
map = []

for _ in range(h):
    map.append(input())

import re

def findWidth(x,y):
    length = 0
    while x < len(map[y]) and map[y][x] == '+':
        length += 1
        x += 1
    return length

def checkImage(x,y,width):
    ym = y + 1
    isad = False
    while map[ym][x:x+width] != '+'*width:
        if '++' in map[ym]:
            xm = map[ym].find('++')
            widthm = findWidth(xm, ym)
            ym = checkImage(xm,ym,widthm)
            if ym >= h:
                break
        if len(re.findall(regex, map[ym][x:x+width])) > 0:
            isad = True
        ym += 1
    if isad:
        while y <= ym:
            map[y] = map[y][0:x] + ' '*width + map[y][x+width:]
            y += 1
    return ym+1

for y in range(h):
    if '++' in map[y]:
        x = map[y].find('++')
        width = findWidth(x, y)
        y = checkImage(x,y,width)
        if y >= h:
            break

print("\n".join(x for x in map))