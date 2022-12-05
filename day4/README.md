# Day 4: Java

__Camp cleanup double counting...__

A language I've been wanting to try out for a long time -- Java.
Having so far used 3 scripting languages, solving today's problem in
Java felt clunky. Of course this probably isn't Java's ideal use case
and perhaps it shines much more in large projects, but some things
felt fairly ridiculous. As far as I can tell you can't open a file
without catching the file not found exception -- why can't I just let
it throw the exception if it doesn't find the file?? Adds an
unnecessary extra indent to all of my code which I am not a fan of.
Also something as simple as printing is so long and clunky.

The solution itself was simple, and I didn't do anything fancy with it
in the interest of time. Looping over the input file and using a
couple splits on each line to extract the 4 integers relevant to the
problem, then some basic comparisons to work out if one set contains
the other or if there is any overlap.

For some reason, not adding curly braces on line 31 to enclose the
else if changed the answer... but my C++ brain is telling me that
should work as a one liner. Quite odd.
