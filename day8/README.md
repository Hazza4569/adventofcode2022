# Day 8: Julia

_Treehouse location scouting..._

Julia seems interesting. Kind of a more mathematically focused python,
with a focus on arrays being vectors and matrices, and 1-based
indexing. Very pythonic syntax so some things were fairly easy to pick
up. Other things seemed like they should have been easier... I spend
far too long on the first line of code trying to take a 2D nested list
comprehension statement and make a matrix from it.

For some reason today I wanted to do as much as possible with list
comprehension, which made for an interesting exercise. In the end I
did essentially everything with it. My solution is 3 lines of code, 1
to read in the grid, 1 to solve part 1, and 1 to solve part 2. I've
not commented it, it's just a bit of a mess and I'm embracing that. I
don't think the fact that I have 3 lines of code is a comment on the
ease of the problem, but rather just shows that list comprehension is
far too powerful. It took me quite a while to solve this one though
because of my obsession with using list comprehension.

Here's what the code looks like really just on 3 lines:
```julia
grid = reduce(vcat, [ [parse(Int, c) for c in line]' for line in readlines(open("input.dat")) ])
println( length(grid) - sum([ minimum( [ maximum(arr) for arr in [grid[x+1:end,y], grid[1:x-1,y], grid[x,y+1:end], grid[x,1:y-1]] ] ) >= grid[x,y] for x in 2:size(grid,1)-1 for y in 2:size(grid,2)-1 ]) )
println( maximum([ prod([ sum( replace([findfirst(isequal(1), [t >= grid[x,y] for t in arr ])], nothing=>length(arr)) ) for arr in [grid[x+1:end,y], reverse(grid[1:x-1,y]), grid[x,y+1:end], reverse(grid[x,1:y-1])] ]) for x in 2:size(grid,1)-1 for y in 2:size(grid,2)-1 ]) )
```
