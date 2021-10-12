import sys

m = {} # tal -> ord
n = {} # ord -> tal

for inp in sys.stdin:
    if (inp.strip() == "clear"):
        m = {}
        n = {}
    elif (inp[0] == 'd'):
        ls = inp.split() # har altid formen: def (ord) 3
        if (ls[1] in n):
            del m[n[ls[1]]]
        m[int(ls[2])] = ls[1] 
        n[ls[1]] = int(ls[2]) # this illegal
    elif (inp[0] == 'c'):
        known = True
        i = inp[5:len(inp)-1].strip() # har altid formen: calc x + y - z =
        ls = i.split()
        if ls[0] in n:
            val = n[ls[0]] 
            for x in range(1,len(ls)-1,2):
                if ls[x+1] in n:
                    tal = n[ls[x+1]] 
                    if (ls[x] == '-'):
                        val -= n[ls[x+1]] 
                    elif (ls[x] == '+'):
                        val += n[ls[x+1]]
                else:
                    known = False
                    break
        else: 
            known = False

        if (known) and (val in m):
            i += " " + m[val]
        else:
            i += " unknown"
            
        print(i)       