a = input()
b = input()

opt = {}

def solve(i,j):
    if (i,j) in opt: return opt[(i,j)]
    if i >= len(a): return (len(b[j:]), b[j:])
    if j >= len(b): return (len(a[i:]), a[i:])

    if a[i] == b[j]:
        solv = solve(i+1,j+1)
        res = (solv[0]+1, a[i]+solv[1])
    else:
        takea = solve(i+1, j)
        takeb = solve(i, j+1)

        res = (takea[0]+1, a[i]+takea[1]) if takea[0] < takeb[0] else (takeb[0]+1, b[j]+takeb[1])
    
    opt[(i,j)] = res
    return res

print(solve(0,0)[1])