package main

import ( "fmt"; "io/ioutil"; "strings"; "strconv" )

func main() {
    multimove := true //< boolean to switch between part1/2 mechanics
    // Read in file
    file, _ := ioutil.ReadFile("input.dat")
    // Split into initial sate and instructions
    sections := strings.Split( string(file), "\n\n" )
    initial_state:= strings.Split( sections[0], "\n" )
    // Go through initial state and construct stacks
    n_stacks := int( len(initial_state[0])/4. + 1 )
    fmt.Println( n_stacks )
    stacks := make( []Stack, n_stacks )
    // > loop over lines of initial state (in reverse to form stacks)
    for line:=len(initial_state)-2; line>=0; line-- {
        // > loop over stacks to locate letters and pop to correct location
        for i, _ := range stacks {
            letter := string(initial_state[line][1+i*4])
            if letter == " " { continue }
            stacks[i].Push(letter)
        }
    }
    // Print initial state
    fmt.Println("Initial:")
    for _, stack := range stacks { stack.Print() }
    // Loop through instructions and make modifications
    instructions:= strings.Split( sections[1], "\n" )
    for _, inst := range instructions {
        words := strings.Split(inst, " ")
        if len(words) < 1 || words[0] != "move" { continue }
        // > extract numbers from instructions
        n_move, _ := strconv.Atoi(words[1])
        x_start, _ := strconv.Atoi(words[3])
        x_end, _ := strconv.Atoi(words[5])
        // > move either one at a time or all at once
        if multimove {
            stacks[x_end-1].PushMulti(stacks[x_start-1].PopN(n_move))
        } else {
            for i:=0; i<n_move; i++ {
                stacks[x_end-1].Push( stacks[x_start-1].Pop() )
            }
        }
    }
    // Print final state
    fmt.Println("Final:")
    for _, stack := range stacks { stack.Print() }
    // Print output needed to solve puzzle
    for _, stack := range stacks { fmt.Printf("%v", stack.Peek()) }
    fmt.Printf("\n")
}

// Stack definition (with generic item interface)
type Item interface{}

type Stack struct {
    items []Item
}

// Push a single item from the top
func (stack *Stack) Push(item Item) {
    stack.items = append(stack.items, item)
}

// Pop a single item from the top
func (stack *Stack) Pop() (rtn Item) {
    n := len(stack.items)
    if n < 1 { return nil }
    rtn = stack.items[n-1]
    stack.items = stack.items[:n-1]
    return
}

// Peek at top element in the stack
func (stack *Stack) Peek() (rtn Item) {
    n := len(stack.items)
    if n < 1 { return nil }
    rtn = stack.items[n-1]
    return
}

// Push multiple items to the top, without flipping order
func (stack *Stack) PushMulti(items []Item) {
    stack.items = append(stack.items, items...)
}

// Pop N items from the top, without flipping order
func (stack *Stack) PopN(n_pop int) (rtn []Item) {
    n := len(stack.items)
    if n < n_pop { return nil }
    rtn = stack.items[n-n_pop:]
    stack.items = stack.items[:n-n_pop]
    return
}

// Print stack to console
func (stack *Stack) Print() {
    fmt.Printf("Stack [")
    for _, item := range stack.items {
        fmt.Printf(" %v ", item)
    }
    fmt.Printf("]\n")
}
