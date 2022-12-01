# Elf class, simply contains list with calories
# for each item the elf is carrying
class Elf:
    def __init__(self, items=[]):
        self.items = items

    def AddItem(self, item):
        self.items.append(int(item))

    def IsEmpty(self):
        return len(self.items) == 0

    def Calories(self):
        return sum(self.items)


#Main
# > populate elf list
elves = []
data = open('input.dat')
iElf = Elf()
for line in data:
    line = line.strip()
    # check for blank line -- new elf
    if line == '':
        if not iElf.IsEmpty(): elves.append(iElf)
        iElf = Elf([])
        continue
    # otherwise add item to elf
    iElf.AddItem(line)

# > find max calorie elf
callist = [e.Calories() for e in elves]
print( max(callist) )

# > find max 3 (will modify callist)
top3 = 0
for i in range(3):
    top3 += callist.pop( callist.index( max(callist) ) )
print(top3)
