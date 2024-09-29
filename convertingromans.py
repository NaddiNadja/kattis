""" Made with team 'gavtyvene fra gribskov' at ncpc 2023 """
roman = {"I": 1, "V": 5, "X": 10, "L": 50, "C": 100, "D": 500, "M": 1000}

n = int(input())

for i in range(n):
    s = input()

    hi = s[len(s)-1]

    sums = roman[hi]

    for j in range (len(s)-2, -1, -1):
        if roman[s[j]] < roman[hi]:
            sums -= roman[s[j]]
        else:
            hi = s[j]
            sums += roman[hi]
    print(sums)