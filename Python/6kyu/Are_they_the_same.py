def comp(array1, array2):
    if array1 is None or array2 is None: return False
    if not array1 and array2: return False
    if not array2 and array1: return False
    limit = len(array2)
    for x in range(limit):
        print(array1[x])
        if (array1[x]*array1[x]) not in array2:
            return False
        array2.remove(array1[x]*array1[x])
    return True
