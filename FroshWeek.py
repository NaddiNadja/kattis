import sys

def mergesort(ls: list):
    inv = 0
    if len(ls) > 1:
        mid = len(ls)//2
        aux1 = mergesort(ls[:mid])
        aux2 = mergesort(ls[mid:])
        inv += aux1[1] + aux2[1]
        pos1, pos2 = 0, 0
        ls = []

        while pos1<len(aux1[0]) and pos2<len(aux2[0]):
            if (aux1[0][pos1] <= aux2[0][pos2]):
                ls.append(aux1[0][pos1])
                pos1 += 1
            else:
                ls.append(aux2[0][pos2])
                pos2 += 1
                inv += mid - pos1

        while pos1<len(aux1[0]):
            ls.append(aux1[0][pos1])
            pos1 += 1

        while pos2<len(aux2[0]):
            ls.append(aux2[0][pos2])
            pos2 += 1

    return [ls, inv]

n = int(input())
studentnumber = [0]*n
x = 0
for inp in sys.stdin:
    studentnumber[x] = int(inp)
    x += 1
invs = mergesort(studentnumber)
print(invs[1])