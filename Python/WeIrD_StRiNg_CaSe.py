def to_weird_case(words):
    upper = True
    out = ""
    for x in words:
        if x == ' ':
            upper = True
            out+= x
            continue
        if upper:
            out+=x.upper()
        else:
            out+=x.lower()
        upper = not upper
    return out
                        
        
