import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class Seminar2 {
    private static char[] readFile(String filePath) {
        File file = new File(filePath);
        char[] content = new char[(int) file.length()];
        try (FileReader reader = new FileReader(file)) {
            reader.read(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    private static void check(char[] content) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < content.length; i++) {
            char currentChar = content[i];
            if (currentChar == '[' || currentChar == '{' || currentChar == '(') {
                stack.push(currentChar);
            } else if (currentChar == '/' && content[i + 1] == '*') {
                stack.push(currentChar);
                stack.push(content[i + 1]);
                i++;
            } else if (currentChar == '/' && content[i + 1] == '/') {
                stack.push(currentChar);
                stack.push(content[i + 1]);
                i++;
            } else if (currentChar == ']' || currentChar == '}' || currentChar == ')') {
                if (stack.isEmpty()) {
                    System.out.println("Error: " + currentChar + " at position " + i);
                    return;
                }
                char lastChar = stack.pop();
                if (currentChar == ']' && lastChar != '[') {
                    System.out.println("Error: " + currentChar + " at position " + i);
                    return;
                } else if (currentChar == '}' && lastChar != '{') {
                    System.out.println("Error: " + currentChar + " at position " + i);
                    return;
                } else if (currentChar == ')' && lastChar != '(') {
                    System.out.println("Error: " + currentChar + " at position " + i);
                    return;
                }
            } else if (currentChar == '*' && content[i + 1] == '/') {
                // Handle the end of a multi-line comment
                while (!stack.isEmpty() && stack.pop() != '*') {
                    // Pop characters until the closing '/' of the multi-line comment is found
                }
                // Check if stack is not empty before popping '*'
                if (!stack.isEmpty() && stack.pop() != '/') {
                    System.out.println("Error: " + currentChar + " at position " + i);
                    return;
                }
                i++; // Increment to skip the closing '/'
            }
        }
    }

    public static void main(String[] args) {
        String filePath = "test.txt";
        char[] content = readFile(filePath);
        check(content);
    }
}
