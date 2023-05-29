/*
Practice files to help get ready for Ex 5.22, modified triangle printing program.
 */

public class PracticeShapes {
    public static void main(String[] args) {

        int n = 5;

        // A. Printing a square shape.
        System.out.println("A");
        for (int i = 1; i <= n; i++) {  // Outer loop prints number of rows.
            for (int j = 1; j <= n; j++) {  // Inner loop prints the number of columns.
                System.out.print(" * "); // After each iteration of the for loops, the required stars are printed.
            }
            System.out.println();  // The println statement moves the output to the next line before reverting to the first for loop.
        }
        // B. Printing an increasing triangle shape.
        System.out.println("B");
        for (int i = 1; i <= n; i++) {  // Outer loop goes from 1 to n, prints number of rows. No change from square shape.
            for (int j = 1; j <= i; j++) {  // Inner loop continuation condition is set from 1 to i instead of 1 to n, incrementing the stars at same rate as the rows.
                System.out.print(" * "); // After each iteration of the for loops, the required number of stars are printed.
            }
            System.out.println();  // The println statement moves the output to the next line before returning to the outer loop.
        }
        // C. Decreasing triangle pattern.
        System.out.println("C");
        for (int i = 1; i <= n; i++) {  // Outer loop goes from 1 to n, prints number of rows. No change from square shape.
            for (int j = i; j <= n; j++) {  /* Start condition is set to int j = i, loop will run from 1-5 printing five *, four *, three, two, finally one *.
             * Outer loop from 1 to n, inner loop from i to n.
             */
                System.out.print(" * "); // After each iteration of the for loops, the required number of stars are printed.
            }
            System.out.println(); // println line
        }
        // D. Right sided triangle. Requires decrementing spaces and incrementing stars.
        System.out.println("D");
        for (int i = 1; i <= n; i++) { // Outer loop outputs number of rows - 5.
            for (int j = i; j <= n; j++) {  // Same as nested loop for decreasing triangle.
                System.out.print("   ");  // Prints spaces.
            }
            for (int j = 1; j <= i; j++) {  // Same as outer loop for increasing triangle.
                System.out.print(" * ");
            }
            System.out.println(); //println line sticks to the end of the outer loop.
        }
        // E. Hill pattern [upright triangle].
        System.out.println("E");
        for (int i = 1; i <= n; i++) { // Outer loop produces decreasing triangle of spaces.
            for (int j = 1; j <= i; j++) {
                System.out.print("   ");
            }
            for (int j = 1; j < i; j++) {
                System.out.print(" * ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
        // F. Reverse Hill pattern [upside down triangle].
        System.out.println("F");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("   ");
            }
            for (int j = 1; j <= n; j++) {
                System.out.print(" * ");
            }
            for (int j = 1; j <= n; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
    }
}