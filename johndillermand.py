h,w = list(map(int, input().split()))

if h != 0 and w != 0:
    map = []
    for x in range(h):
        map.append(list(input()))

    endfound = False
    posx = 0
    posy = 0

    while not endfound:
        map[posy][posx] = '.'
        if posy < h-1:
            if map[posy+1][posx] == 'O' or map[posy+1][posx] == '#':
                posy += 1
                continue
        if posy > 0:
            if map[posy-1][posx] == 'O' or map[posy-1][posx] == '#':
                posy -= 1
                continue
        if posx < w-1:
            if map[posy][posx+1] == 'O' or map[posy][posx+1] == '#':
                posx += 1
                continue
        if posx > 0:
            if map[posy][posx-1] == 'O' or map[posy][posx-1] == '#':
                posx -= 1
                continue
            
        
        endfound = True

    for i in map:
        print("".join(x for x in i))