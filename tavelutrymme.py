n, r, c = map(int, input().split())
ideas = list(map(int, input().split()))

opt = {}

def solve(i, blue, red):
  if i in opt:
    # (blue, red) = where each of them has form
    # (current row, used in last row)
    return opt[i]
  if i == n:
    return blue, red
  
  # take blue
  take_blue, take_red = None, None
  if ideas[i] <= r - blue[1]:
    # there is room for this idea on this row
    new_blue = (blue[0], blue[1] + ideas[i])
    take_blue = solve(i+1, new_blue, red)
  else:
    # no room for this idea on this row
    if blue[0] <= c-1:
      # there are more rows
      new_blue = (blue[0] + 1, ideas[i])
      take_blue = solve(i+1, new_blue, red)
    else:
      take_blue = (float('inf'), float('inf'))
  if ideas[i] <= r - red[1]:
    # there is room for this idea on this row
    new_red = (red[0], red[1] + ideas[i])
    take_red = solve(i+1, blue, new_red)
  else:
    # no room for this idea on this row
    if red[0] <= c-1:
      # there are more rows
      new_red = (red[0] + 1, ideas[i])
      take_red = solve(i+1, blue, new_red)
    else:
      take_red = (float('inf'), float('inf'))
  
  if take_blue[0] == take_red[0] == float('inf'):
    return (float('inf'), float('inf'))

  if take_blue[0] < take_red[0]:
    opt[i] = take_blue
    return take_blue
  elif take_blue[0] > take_red[0]:
    opt[i] = take_red
    return take_red
  else:
    if take_blue[1] < take_red[1]:
      opt[i] = take_blue
      return take_blue
    else:
      opt[i] = take_red
      return take_red

hej = solve(0, (0,0), (0,0))