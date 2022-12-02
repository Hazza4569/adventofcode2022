# Day 2: Bash

_Rock, paper, scissors tournament..._

Decided to get bash out of the way early -- it's one I'm familiar with
but not a language typically suited to these sorts of problems.
Today's problem is essentially just comparing integers and making sums
so actually a nice one for bash to handle. Boy did it take a while to
run though, several seconds to process the full input.

My initial thought was to just nest some switch cases to 'bash' the
problem out quickly, but then I realised there would be a fairly
elegant solution where the input could essentially be translated
directly into the scores with a bit of rotation and arithmetic.

Part 2 was essentially the same as Part 1, just rotating the opposite
set of inputs in a different pattern. Didn't see a neat way to do the
two parts in the same script, and they're so short anyway, so I split
them into a script each.
