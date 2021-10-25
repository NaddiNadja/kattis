import sys

class TrieNode:
    def __init__(self, char): 
        self.c = char
        self.count = 0
        self.children = [None]*26
    def add(self, char):
        val = ord(char)-ord('a') 
        if self.children[val] == None:
            self.children[val] = TrieNode(char)
        else: 
            self.children[val].count += 1
        return self.children[val]
    def getCount(self):
        return self.count

n = int(input())
out = []
root = TrieNode(None)
for inp in sys.stdin:
    array = list(inp.strip())
    position = root
    for c in array:
        position = position.add(c)
    out.append(position.getCount())
print("\n".join(str(i) for i in out))