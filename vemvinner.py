board = [1,2,3]
board[0] = input().split()
board[1] = input().split()
board[2] = input().split()

winner = "_"

for i in range(3):
    if board[1][i] == board[2][i] == board[0][i]:
        winner = board[1][i]
        break
    if board[i][1] == board[i][2] == board[i][0]:
        winner = board[i][1] 
        break

if winner == "_":
    if board[0][0] == board[1][1] == board[2][2]:
        winner = board[1][1]
    if board[0][2] == board[1][1] == board[2][0]:
        winner = board[1][1]

print(f'{"ingen" if winner == "_" else "Johan" if winner == "X" else "Abdullah"} har vunnit')