def toOnlyBracketsAndComma(item):
    out = ""
    item = item.replace("\'[\'", "")
    item = item.replace("\']\'", "")
    item = item.replace("\',\'", "")
    for x in item:
        if x in ["[", "]", ","]:
            out += x
    return out


def same_structure_as(original, other):
    original = toOnlyBracketsAndComma(str(original))
    other = toOnlyBracketsAndComma(str(other))
    print(original)
    print(other)
    return original == other


same_structure_as([1,[1,1]],[[2,2],2])
