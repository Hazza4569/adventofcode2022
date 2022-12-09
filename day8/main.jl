grid = reduce(vcat, [ [parse(Int, c) for c in line]' for line in readlines(open("input.dat")) ])
println( length(grid) - sum([
    minimum( [
        maximum(arr) for arr in [grid[x+1:end,y], grid[1:x-1,y], grid[x,y+1:end], grid[x,1:y-1]]
    ] ) >= grid[x,y]
    for x in 2:size(grid,1)-1 for y in 2:size(grid,2)-1
]) )
println( maximum([
    prod([
        sum( replace([findfirst(isequal(1), [t >= grid[x,y] for t in arr ])], nothing=>length(arr)) )
        for arr in [grid[x+1:end,y], reverse(grid[1:x-1,y]), grid[x,y+1:end], reverse(grid[x,1:y-1])]
    ])
    for x in 2:size(grid,1)-1 for y in 2:size(grid,2)-1 
]) )
