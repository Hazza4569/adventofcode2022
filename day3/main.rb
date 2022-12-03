require 'set'

# Function to convert characters to the numbers required
def char_value(char)
  return char.ord < 97 ? char.ord - 38 : char.ord - 96
end

# Initialise file and counters
rucksacks = File.open('input.dat','r').readlines
part1_sum=0
part2_sum=0

# Find duplicates between compartments
rucksacks.each do |rucksack|
  duplicate = nil
  # Split into 2 compartments
  compartment1 = rucksack[0,rucksack.size/2]
  compartment2 = rucksack[rucksack.size/2..]
  compartment1.each_char do |c|
    if compartment2.include? c
      duplicate = c
      break
    end
  end
  # Error check
  if !duplicate
    puts "Didn't find a duplicate??"
    break
  end
  # Add to sum
  part1_sum += char_value(duplicate) 
end
puts part1_sum

# Loop over each set of three rucksacks, i.e. each group
rucksacks.each_slice(3).to_a.each do |group|
  badge = nil
  # Fill a set with all characters shared between rucksacks 1 and 2
  candidates = Set.new
  group[0].each_char do |c|
    if group[1].include? c then candidates << c end
  end
  # Check which characters from the set are alson in rucksack 3
  candidates.each do |c|
    if group[2].include? c
      badge = c
      break
    end
  end
  # Error check
  if !badge
    puts "Didn't find a badge??"
    break
  end
  # Add to sum
  part2_sum += char_value(badge)
end
puts part2_sum
