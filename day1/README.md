# Day 1: Python

_Calorie counting elves..._

Some simple python code to parse the input file and construct a list
of elves. Could simply be a list of lists but created the elf class in
anticipation of some more complex behaviour being required in the
second part. Was not required in the end so the class basically does
nothing besides name the list as an elf, but I'll leave it in as it
kind of helps follow what the code is doing.

Have seen an alternate solution to getting the top 3 which would
replace the last 4 lines of my code with
```python
callist.sort()
print( sum(callist[-3:]) )
```
This is ultimately neater and probably more pythonic as a solution,
but likely more computationally expensive (not that it matters much in
this case)
