# Day 7: Kotlin

_Directory cleanup..._

Kotlin today, essentially Java++. Definitely a notable improvement
over java, much nicer to use. Has some of the Ruby-style loops where
you can call forEach directly on an object which is nice, and I like
the approach to nullable objects where you can use `!!` to tell it to
go ahead and use it anyway -- very handy for small scripts like this.

Today's problem was one of the most annoying so far. I built a
directory class to link each directory to its subdirectories and
handle size calculation, and then stored all the directories in a
dictionary from their name. Fairly straightforward, but took a good
chunk of code to achieve.

I wasn't initially using full paths, just had a member in the class to
track what the parent directory was and then used the dictionary to
allow `cd ..` to function. This was neat enough, but became
problematic when faced with a path like
`/somedir/someotherdir/somedir`. The second `somedir` became a
subdirectory of itself (as they had the same name so the dictionary so
were seen as equivalent) and created an infinite loop, giving me stack
overflow errors. I'm not sure if this was a deliberate inclusion in
the puzzle or if I got unlucky with my input data.

The solution was then to store directories in the dictionary by their
full path rather than just the name. So I ditched the parent member of
the directory class and just tracked the full pwd path at any time,
using string manipulation now to achieve a `cd ..`.
