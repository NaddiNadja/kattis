s = input()
s1 = s[:len(s)//2]
s2 = s[len(s)//2:]

def rotatesingle(c, val):
    return chr(((ord(c)-65 + val) % 26)+65)

def rotate(s):
    val = 0
    for c in s:
        val += ord(c)-65
    new_s = ""
    for c in s:
        new_s += rotatesingle(c, val)
    return new_s

rs1 = rotate(s1)
rs2 = rotate(s2)
out = ""
for i in range(len(rs1)):
    out += rotatesingle(rs1[i], ord(rs2[i])-65)
print(out)