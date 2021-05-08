import math


class Sudoku(object):
    def __init__(self, data):
        self.data = data
        self.height = len(data)
        self.width = len(data[0])

    def checkContent(self):
        for line in self.data:
            if len(line) != self.height:
                return False
            for item in line:
                if isinstance(item,bool) or not isinstance(item, int) or item < 1 or item > self.height:
                    return False
        return True

    def checkColumns(self):
        numsInColumn = set({})
        for i in range(self.width):
            numsInColumn.clear()
            for j in range(self.height):
                numsInColumn.add(self.data[i][j])
            if self.height != len(numsInColumn):
                return False
        return True

    def checkRows(self):
        numsInRow = set({})
        for row in self.data:
            numsInRow.clear()
            for num in row:
                numsInRow.add(num)
            if self.height != len(numsInRow):
                return False
        return True

    def checkLittleSquares(self):
        l = int(math.sqrt(self.height))
        numsInSq = set({})
        for i in range(0, self.width, l):
            numsInSq.clear()
            startRow = i % l * l
            startCol = l * int(i / l)
            for j in range(startRow, startRow+l):
                for k in range(startCol, startCol+l):
                    numsInSq.add(self.data[j][k])
            if self.height != len(numsInSq):
                return False
        return True

    def is_valid(self):
        if self.height != self.width:
            return False
        if (self.height != (math.isqrt(self.height)**2)):
            return False
        if not self.checkContent():
            return False
        return self.checkRows() and self.checkColumns() and self.checkLittleSquares()
