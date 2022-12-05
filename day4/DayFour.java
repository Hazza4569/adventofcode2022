import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

class DayFour
{
    public static void main(String[] args)
    {
        int sublists=0;
        int overlaps=0;
        try {
            // Read input data
            Scanner input = new Scanner( new File("input.dat") );
            // Loop over lines
            while ( input.hasNextLine() ) {
                String line = input.nextLine();
                // Get 4 limits
                int[] limits = new int[4];
                int limitIndex = 0;
                for ( String s : line.split(",") ) for ( String s2 : s.split("-") )
                    limits[limitIndex++] = Integer.parseInt(s2);
                // Check if one is sublist of the other (one negative difference
                // or either limit the same)
                if ( (limits[0] - limits[2])*(limits[1]-limits[3]) <= 0 )
                {
                    sublists++;
                    overlaps++;
                }
                // Check overlaps in the case that the first list is the lower
                else if (limits[0] <= limits[2]) 
                    { if (limits[1] >= limits[2]) overlaps++; } //< curly braces??
                // ...and with the second being the lower 
                else if (limits[0] <= limits[3]) overlaps++;
            }
            System.out.println(sublists);
            System.out.println(overlaps);
            input.close();
        }
        catch (FileNotFoundException e) { e.printStackTrace(); }
    }
}
