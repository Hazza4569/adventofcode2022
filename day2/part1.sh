score=0
while read opp you; do
    # Convert A,B,C or X,Y,Z -> 0,1,2
    oppInt=`expr $(echo $opp | bc) - 10`
    youInt=`expr $(echo $you | bc) - 33`
    # Score for picking rock, paper, or scissors:
    let score+=youInt+1
    # Score for win/draw/loss:
    # > calculate win/draw/loss score by rotating opponents 0/1/2
    # > depending on what you choose.
    # > If rock, need to shift by 1; paper shift by 0; scissors shift by 2.
    # > This transformation achieves that:
    let intShift=(4-youInt)%3
    # > Apply the shift
    let shiftedInt=(oppInt+intShift)%3
    # > calculate score increment
    let score+=3*(2-shiftedInt)
done < input.dat
echo $score
