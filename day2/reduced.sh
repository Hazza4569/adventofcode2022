let score1=score2=0
while read opp you; do
    let oppInt=$(echo $opp | bc)-9
    let youInt=$(echo $you | bc)-32
    let score1+=youInt+3*(2-(4+oppInt-youInt)%3)
    let score2+=3*youInt-2+(youInt+oppInt)%3
done < input.dat
echo part1: $score1, part2: $score2
