import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountingPointMutations {
    public static void main(String[] args) {
        String filename = "src/rosalind_hamm.txt";
        // Load DNA strings from file
        String s = loadDNAStringFromFile(filename, 1);
        String t = loadDNAStringFromFile(filename, 2);
        // Count point mutations
        System.out.println(countPointMutations(s, t)); // 490
    }


    /**
     * Counts the number of point mutations between two DNA strings.
     *
     * @param s the first DNA string
     * @param t the second DNA string
     * @return the number of point mutations between the two DNA strings (Hamming distance)
     */
    public static int countPointMutations(String s, String t) {
        int count = 0;
        // Iterate over the two strings and count the number of differences
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Loads a DNA string from a file based on the line number.
     *
     * @param fileName         the name of the file to load the DNA string from
     * @param lineNumberToLoad the line number of the file to load the DNA string from (Starts at 1)
     * @return the DNA string loaded from the file
     */
    public static String loadDNAStringFromFile(String fileName, int lineNumberToLoad) {
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            // Read the file line by line
            for (int i = 0; i < lineNumberToLoad; i++) {
                line = br.readLine();
                // If the line number is reached, return the line
                if (i == lineNumberToLoad - 1) {
                    return line;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
