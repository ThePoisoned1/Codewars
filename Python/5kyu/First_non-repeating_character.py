def first_non_repeating_letter(s):
    aux = s.lower()
    for x in range(len(aux)):
        repeated = False
        for y in range(len(aux)):
            if y == x: continue
            if aux[y] == aux[x]:
                repeated = True
                break
        if repeated == False: return s[x]
    return ''
