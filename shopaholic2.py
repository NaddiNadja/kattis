n = int(input())  #antal grejer

listOfClothes = []
listOfClothes = input().split(' ')

listOfClothes.sort(reverse=True)

discount = 0
for i in range(0, n):
    if (i+1) % 3 == 0:
        discount += int(listOfClothes[i])


print(discount)