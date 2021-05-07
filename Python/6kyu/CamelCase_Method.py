def camel_case(s):
    next=True
    out = ""
    for x in s:
        if x == ' ':
            next=True
            continue
        if next:
            out+=x.upper()
        else:
            out+=x
        next=False
    return out
