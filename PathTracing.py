import sys

maxx, minx, maxy, miny, curx, cury = 0,0,0,0,0,0

ls = []

for s in sys.stdin:
    inp = s.strip()
    if (inp == "down"):
        ls.append(1)
        cury -= 1
        if (cury<miny): 
            miny = cury
    elif (inp == "up"):
        ls.append(2)
        cury += 1
        if (cury>maxy): 
            maxy = cury
    elif (inp == "left"):
        ls.append(3)
        curx -= 1
        if (curx<minx): 
            minx = curx
    elif (inp == "right"):
        ls.append(4)
        curx += 1
        if (curx>maxx): 
            maxx = curx
    # down = 1, up = 2, left = 3, right = 4

m = [[" " for i in range(maxx-minx+1)] for j in range(maxy-miny+1)]
x = abs(minx)
y = maxy

for i in ls:
    if (i == 1):
        y += 1
    if (i == 2):
        y -= 1
    if (i == 3):
        x -= 1
    if (i == 4):
        x += 1
    m[y][x] = "*"
m[y][x] = "E"
m[maxy][abs(minx)] = "S"

print((maxx-minx+3)*"#")
for l in range(0,len(m)):
    printstr = "#"
    for k in range(0,len(m[l])):
        printstr += m[l][k]
    printstr += "#"
    print(printstr)
print((maxx-minx+3)*"#")