let score1=score2=0
while read opp you; do
    let oppInt=$(echo $opp | bc)-10
    let youInt=$(echo $you | bc)-33
    let score1+=youInt+1+3*(2-(4+oppInt-youInt)%3)
    let score2+=3*youInt+1+(youInt+oppInt+2)%3
done < input.dat
echo part1: $score1, part2: $score2
