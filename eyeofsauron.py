s = input()
eyeFound = False
left = 0
right = 0
for c in s:
    if eyeFound:
        if c == '|':
            right += 1
    else:
        if c == '|':
            left += 1
        else:
            eyeFound = True
if left == right:
    print("correct")
else:
    print("fix")