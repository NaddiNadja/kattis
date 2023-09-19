s1 = input()
s2 = input()
i, j = 0, 0
out = []
while i<len(s1) and j<len(s2):
    if s1[i] < s2[j]:
        out.append(s1[i])
        i+=1
    else:
        out.append(s2[j])
        j+=1
out.append(s1[i:])
out.append(s2[j:])
print("".join(out))