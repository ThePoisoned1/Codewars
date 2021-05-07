def parse(data):
    out = []
    pts = 0
    for x in data:
        if x == 'i': pts+=1
        elif x == 'd': pts-=1
        elif x == 's': pts=pts**2
        elif x == 'o': out.append(pts)
    return out
        
