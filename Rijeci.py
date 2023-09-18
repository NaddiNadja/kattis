k = int(input())

prevA = 1
prevB = 0

for _ in range(k):
    nextA = prevB
    nextB = prevB+prevA
    prevA = nextA
    prevB = nextB

print(str(prevA) + " " + str(prevB))