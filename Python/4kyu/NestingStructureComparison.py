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
    return original == other
