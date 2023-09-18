n,q = list(map(int, input().split()))
locations = list(map(int, input().split()))
output = []
for i in range(q):
    o,a,b = list(map(int, input().split()))
    if o == 1:
        locations[a-1] = b
    else:  
        output.append(abs(locations[a-1]-locations[b-1]))
print("\n".join(str(x) for x in output))