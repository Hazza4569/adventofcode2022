score=0
while read opp you; do
    # Convert A,B,C or X,Y,Z -> 0,1,2
    oppInt=`expr $(echo $opp | bc) - 10`
    youInt=`expr $(echo $you | bc) - 33`
    # Score for win/lose/draw
    let score+=3*youInt
    # Score for r/p/s choice
    # > work out if you've used rock/paper/scissors by rotating your 0/1/2
    # > depending on opponent's choice
    # > shift: 0>2, 1>0, 2>1
    let intShift=(oppInt+2)%3
    # > Apply the shift
    let shiftedInt=(youInt+intShift)%3
    # > calculate score increment
    let score+=shiftedInt+1
done < input.dat
echo $score
