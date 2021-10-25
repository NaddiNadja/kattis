n = input()
busnumbers = [int(x) for x in input().split()]
busnumbers.sort()

startval = busnumbers[0]
prevval = busnumbers[0]

printstr = ""

for x in busnumbers[1:]:
    if (x != prevval+1):
        if (prevval-startval > 1):
            printstr += str(startval) + "-" + str(prevval) + " "
        elif (prevval-startval == 0):
            printstr += str(startval) + " "
        else:
            printstr += str(startval) + " " + str(prevval) + " "
        startval = x
    prevval = x

if (prevval-startval > 1):
    printstr += str(startval) + "-" + str(prevval) + " "
elif (prevval-startval == 0):
    printstr += str(startval) + " "
else:
    printstr += str(startval) + " " + str(prevval) + " "

print(printstr[0:len(printstr)-1])