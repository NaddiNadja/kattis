n = int(input())
inp = []

class interval:
    def __init__(self, startend):
        self.start = startend[0]
        self.end = startend[1]
    def __lt__(self,other):
        return self.end < other.end
    def __gt__(self,other):
        return self.end > other.end    
    def __eq__(self,other):
        return self.end == other.end
    def __le__(self,other):
        return self.end <= other.end
    def __ge__(self,other):
        return self.end >= other.end    
    def __ne__(self,other):
        return self.end != other.end
    def overlaps(self,other):
        return self.end > other.start and self.start < other.end

for i in range(n):
    inp.append(interval(list(map(int, input().split()))))

inp.sort()

cur = inp[0]
sum = 1
for i in inp:
    if not cur.overlaps(i):
        cur.end = i.end
        sum += 1

print(sum)