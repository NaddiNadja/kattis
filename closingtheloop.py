N = int(input())
out = []
for j in range(N):
    S = int(input())
    bag = input().split()
    reds = []
    blues = []
    for rope in bag:
        color = rope[-1:]
        length = int(rope[:-1])-1
        if color == "R": reds.append(length)
        else: blues.append(length)
    reds.sort(reverse=True)
    blues.sort(reverse=True)

    maxlength = 0
    for i in range(min(len(reds),len(blues))):
        maxlength += reds[i]+blues[i]

    out.append(f'Case #{j+1}: {maxlength}')
print("\n".join(out))