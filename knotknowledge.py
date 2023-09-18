n = int(input())
x = set(input().split())
y = set(input().split())
print("".join(i for i in (x-y)))