def josephus_survivor(ppl, k):
    pplList = list(range(ppl))
    pos = 0
    while ppl > 1:
        pos = (pos + k - 1) % ppl
        pplList.pop(pos)
        ppl -= 1
    return pplList[0]+1
