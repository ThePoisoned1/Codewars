def josephus(items,k):
    itemsLen = len(items)
    out = []
    pos = 0
    while itemsLen > 0:
        pos = (pos + k - 1) % itemsLen
        out.append(items.pop(pos))
        itemsLen -= 1
    return out
