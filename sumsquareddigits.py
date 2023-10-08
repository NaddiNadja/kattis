P = int(input())

def numberToBase(n, b):
    digits = []
    while n:
        digits.append(int(n % b))
        n //= b
    return digits[::-1]

out = []
for i in range(P):
    K, b, n = map(int, input().split())
    diff_base = numberToBase(n, b)
    ssd = 0
    for val in diff_base:
        ssd += int(val)**2
    out.append(f'{K} {ssd}')

print("\n".join(out))