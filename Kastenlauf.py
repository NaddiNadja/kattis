def rangecheck(x, y):
    return abs(x[0]-y[0]) + abs(x[1]-y[1]) <= 1000

def search(pos, aux, visited, g):
    if rangecheck(pos, g):
        visited.append(g)
        return True
    for k in aux:
        if rangecheck(pos, k):
            if k not in visited:
                temp = aux.copy()
                temp.remove(k)
                visited.append(k)
                if search(k, temp, visited, g):
                    return True
    return False

t = int(input())
for i in range(t):
    n = int(input())
    home = [int(x) for x in input().split()]
    stores = []
    for j in range(n):
        stores.append([int(x) for x in input().split()])
    goal = [int(x) for x in input().split()]
    if search(home, stores, [], goal):
        print("happy")
    else:
        print("sad")