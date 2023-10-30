import java.util.Scanner;

public class task2_Word_Converter {
    
 public static void main(String[] args) 
 {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Word Counter");
        System.out.print("Enter a sentence: ");
        String input = scanner.nextLine();

        int wordCount = countWords(input);
        System.out.println("Word count: " + wordCount);

        scanner.close();
    }

    public static int countWords(String input) 
    {
        if (input == null || input.isEmpty()) 
        {
            return 0;
        }

        String[] words = input.split("\\s+"); // Split the input into words using whitespace as the delimiter
        return words.length;
    }
}

