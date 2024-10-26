import sys

sys.setrecursionlimit(10**6)

n, m = map(int, input().split())

expected = []
actual = []
for _ in range(n):
  expected.append(int(input()))
for _ in range(m):
  actual.append(int(input()))

opt = {}

def time_dif_score(ms):
  if ms <= 15: return 7
  if ms <= 23: return 6
  if ms <= 43: return 4 
  if ms <= 102: return 2
  return 0

def solve(i, j):
  if (i,j) in opt:
    return opt[(i,j)]
  if i == n:
    return 0
  if j == m:
    return 0
  
  # either pair the actual press at index j with
  # the expected press at index i
  ms = abs(expected[i] - actual[j])
  score = time_dif_score(ms)
  take = 0
  if score != 0:
    take = score + solve(i+1, j+1)

  skip = 0
  if actual[j] > expected[i]:
    # we can skip the expected press at index i
    skip = solve(i+1, j)
  elif actual[j] < expected[i]:
    # we can skip the actual press at index j
    skip = solve(i, j+1)

  opt[(i,j)] = max(take, skip)
  return opt[(i,j)]

print(solve(0,0))

