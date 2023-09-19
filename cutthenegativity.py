n = int(input())

out = []

for i in range(n):
    dep = i+1
    line = input().split()
    for j in range(len(line)):
        arr = j+1
        if int(line[j]) >= 0:
            out.append(f'{dep} {arr} {line[j]}')

print(len(out))
print("\n".join(out))