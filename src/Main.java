import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String inputFile;
        String outputFile;
        int numGenerations;

        Scanner in = new Scanner(System.in);

        // instructions for the user
        System.out.println("Enter the starting sprite file: ");
        inputFile = in.next();



        System.out.println(readFileContents(inputFile).toString());
        System.out.println(mirror(inputFile).toString());

        in.close();
    }
    static String readFileContents(String filename) throws FileNotFoundException {
        String text = "";

        File file = new File(filename);
        Scanner scnr = new Scanner(file);

        // scans the file contents.
        while (scnr.hasNextLine()) {
            Scanner fileText = new Scanner(scnr.nextLine());
            fileText.useDelimiter("");

            while (fileText.hasNext()) {
                text += fileText.next();
            }
            text += "\n";
        }

        return text;
    }
    public static String mirror(String filename) throws FileNotFoundException {
        String text = "";

        File file = new File(filename);
        Scanner scnr = new Scanner(file);

        int length = 0;
        while (scnr.hasNextLine()) {
            String line = scnr.nextLine();
            int temp = line.length();
            if (length < temp) {
                length = temp;
            }
        }
        scnr.close();

        Scanner in = new Scanner(file);
        // scans the file contents.
        while (in.hasNextLine()) {
            String temp = in.nextLine();
            temp = fill(length-temp.length(),temp);
            text += reverse(temp);

            text += "\n";
        }
        in.close();

        return text;
    }
    public static String reverse(String input){
        char[] in = input.toCharArray();
        int begin=0;
        int end=in.length-1;
        char temp;
        while(end>begin){
            temp = in[begin];
            in[begin]=in[end];
            in[end] = temp;
            end--;
            begin++;
        }
        return new String(in);
    }

    public static String fill(int x, String text) {
        for (int i = 0; i < x; i++) {
            text = " " + text;
        }
        return text;
    }
}
