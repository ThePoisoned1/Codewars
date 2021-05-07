def narcissistic(value):
    pow = len(str(value))
    sum = 0
    for x in str(value):
        sum+=int(x)**pow
    return sum == value
