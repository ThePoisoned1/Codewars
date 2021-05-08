def next_bigger(n):
    strNum = str(n)
    ending = []
    for x in range(len(strNum)-1, 0,-1):
        if int(strNum[x]) > int(strNum[x-1]):
            out = strNum[0:x]
            ending += strNum[x:]
            ending = sorted(ending)
            ending.insert(0,strNum[x-1])
            for y in range(1, len(ending)):
                if ending[y] > ending[0]:
                    out += ending.pop(y)
                    break
            ending = sorted(ending)
            out += "".join(ending)
            return int(out)
    return -1
