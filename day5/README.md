# Day 5: Go

_Stacks of crates..._

Go is a language I've been interested in for quite a while but never
taken the time to look into. This was an interesting introduction.
Like Java I think it's better suited to large projects rather than
short scripts, unlike Java I don't hate the syntax. It takes a fairly
novel approach to things like labelling types, it manages to diverge
from the C-style standards in a way that makes sense.

This problem was one of the more involved ones so far, and it took a
fair bit of code to achieve. Go might not have been the ideal language
for it (there doesn't seem to be a native stack implementation, I had
to do it myself), but I think my solution fell out fairly elegantly.

The natural representation for the stacks is a stack. The problem
being that reading in the data line by line would mean you need to
construct the stacks from the top down -- probably by switching them
for a deque. Instead I split the file on the blank line and looped
backwards over the stack definitions to insert items in the natural
order.

My initial thought for solving the second part might have been moving
the items through an intermediate stack, so the double change leaves
the order as it was originally. Since I was anyway implementing my own
stack however, it was simple enough to define push/pop methods that
behaved as intended.
