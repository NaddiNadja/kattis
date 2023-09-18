onemove = {0:[6,9],2:[3],3:[2,5],5:[3],6:[0,9],9:[0,6]}
twomoves = {0:[8],3:[9],5:[6],6:[5],8:[0],3:[9]}

xy = input().split()
for i in range(len(input[0])):
    if xy[0][i] == xy[1][i]: continue
    else: x = 0
