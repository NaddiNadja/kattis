n = int(input())
i = 1
layers = 0
while n > 0:
    square = i**2
    n -= square
    if n >= 0:
        layers += 1
        i += 2
print(layers)