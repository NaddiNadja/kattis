n = int(input())

print(f'+{"".join(["-" for _ in range(n)])}+')
for i in range(n):
    print(f'|{"".join([" " for _ in range(n)])}|')
print(f'+{"".join(["-" for _ in range(n)])}+')