out = []

# Get x as a bitstring of length n
get_binary = lambda x, n: format(x, 'b').zfill(n)

for i in range(2**12):
    s = get_binary(i,12)
    pebble = ""
    for c in s:
        if c == '0': pebble = pebble + '-'
        else: pebble = pebble + 'o'
    out.append(pebble)

print("\n".join(p for p in out))