letters = [c for c in input()]
m = input().split()
out = []
for word in m:
    banned = False
    for letter in letters:
        if letter in word:
            banned = True
            break
    if banned:
        out.append('*'*len(word))
    else:
        out.append(word)
print(" ".join(out))