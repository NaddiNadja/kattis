import sys
n = int(input())
running = False
secs = 0
totaltime = 0
for inp in sys.stdin:
    if running:
        secs += int(inp) - totaltime
    totaltime = int(inp)
    running = not running
if running: print("still running")
else: print(secs)
    
