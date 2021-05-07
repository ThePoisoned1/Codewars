    out = []
    previous = None
    for x in iterable:
        if previous != x:
            out.append(x)
        previous = x
    return out
