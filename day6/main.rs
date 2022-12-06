use std::collections::HashSet;

fn main()
{
    // read file, set unique char length, and initialise result variable
    let datastream = std::fs::read_to_string("input.dat").expect("file err");
    let n_unique = 14;
    let mut rtn = 0;
    // loop over characers (skipping first n_unique-1)
    'outer: for i in n_unique-1..datastream.len() {
        // add previous n_unique chars to a set
        let mut set = HashSet::new();
        for j in i+1-n_unique..i+1
        {
            let c2 = datastream.chars().nth(j).expect("no c2");
            // if char exists in set, continue to next character
            if !set.insert(c2) { continue 'outer; }
        }
        // if it reaches here, we've found a unique character
        rtn = i;
        break
    }
    // print result
    println!("{:?}", rtn+1)
}
