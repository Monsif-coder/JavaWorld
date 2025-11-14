import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextStatsAnalyzer {

    public static void main(String[] args) {

        // Declaration and initialization of variables
        int[] letterCounts = new int[26];
        String fullText = "";

        // Read from the input file 
        String filePath = "text.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                
                // Add line to fullText
                fullText += line + " ";
                
                // Convert to lowercase
                line = line.toLowerCase();

                // Count each character
                for (int i = 0; i < line.length(); i++) {
                    char c = line.charAt(i);
                    
                    if (Character.isLetter(c)) {
                        int index = c - 'a';
                        letterCounts[index]++;
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        // Split fullText into words
        String[] allWords = fullText.split("[\\p{Punct}\\s]+");

        String longestWord = allWords[0];  // Start with first word

        for (String word : allWords) {
            
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }

        int totalWordCount = allWords.length; // Get the total number of words

        // Write results to output file
        String outputFile = "output.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            
            // Write header
            writer.write("===== TEXT ANALYSIS RESULTS =====");
            writer.newLine();
            writer.newLine();
            
            // Write character frequencies
            writer.write("Character Frequencies:");
            writer.newLine();
            
            for (int i = 0; i < 26; i++) {
                char letter = (char)('a' + i);        // Convert index to letter
                int count = letterCounts[i];          // Get the count for this letter
                
                writer.write(letter + ": " + count);  // Write to file
                writer.newLine();
            }
            
            writer.newLine();
            
            // Write word statistics
            writer.write("Word Statistics:");
            writer.newLine();
            writer.write("Total words: " + totalWordCount);
            writer.newLine();
            writer.write("Longest word: " + longestWord);
            writer.newLine();

        } catch (IOException e) {
            System.out.println("Error writing to the file: " + e.getMessage());
        }
        
        System.out.println("Analysis complete! Results written to " + outputFile);
    }
}
