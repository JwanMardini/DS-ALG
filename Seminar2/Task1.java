import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Task1 {
    private static Stack<Character> stack = new Stack<>();
    private static boolean inComment = false;

    
    private static char[] readFile(List<String> lines) {
        StringBuilder sb = new StringBuilder();
        for (String line : lines) {
            sb.append(line);
            //new line character
            sb.append('ä');
            
        }
        return sb.toString().toCharArray();
    }

    private static boolean checkSymbols(char[] content) {
        for (int i = 0; i < content.length; i++) {
            if (content[i] == '[' || content[i] == '{' || content[i] == '(') {
                stack.push(content[i]);
                continue;
            } else if (content[i] == ']' || content[i] == '}' || content[i] == ')') {
                if (stack.isEmpty()) {
                    System.out.println("There is no opening symbol for " + content[i]);
                } else if (stack.peek() == '[' || stack.peek() == '{' || stack.peek() == '(') {
                    stack.pop();
                }else{
                    System.out.println("There is no opening symbol for " + content[i]);
                }

            }else if(content[i] == '/'){
                if(inComment && content[i+1] == '*'){
                    stack.push(content[i]);
                    stack.push(content[i+1]);
                    i++;
                    inComment = true;
                    continue;
                }else if(inComment && content[i+1] == '/'){
                    inComment = true;
                    stack.push(content[i]);
                    stack.push(content[i+1]);
                    for (int j = i+2; j < content.length; j++) {
                        if(content[j] == 'ä'){
                            stack.pop();
                            stack.pop();
                            i = j;
                            inComment = false;
                            break;
                        }
                    }
                    continue;
                }
            }else if(inComment && content[i] == '*' && content[i+1] == '/'){
                if (stack.isEmpty() || stack.peek() != '*') {
                    System.out.println("There is no opening symbol for " + content[i] + content[i+1]);
                }else{
                    stack.pop();
                    stack.pop();
                    i++;
                }
                inComment = false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) throws IOException {
        /*try (Scanner sc = new Scanner(System.in)){
            while(true){
                try{
                    System.out.println("1. Enter file path");
                    System.out.println("2. Enter text");
                    System.out.println("3. Exit");
                    System.out.print(">> ");
                    int choice = sc.nextInt();
                    sc.nextLine();
                    if (choice == 1) {
                        System.out.print("Enter file path: ");
                        String filePath = sc.nextLine();
                        //read file
                        List<String> content = Files.readAllLines(Paths.get(filePath));
                        System.out.println(content);
                        char[] fileContent = readFile(content);
                        System.out.println(Arrays.toString(fileContent));
                        //check symbols
                        if (checkSymbols(fileContent)) {
                            System.out.println("The text is balanced");
                            System.out.println();
                        } else {
                            System.out.println("The text is not balanced, check the symbols");
                            System.out.println();
                        }

                    } else if (choice == 2) {
                        System.out.print("Enter text: ");
                        String text = sc.nextLine();
                        char[] fileContent = text.toCharArray();
                        System.out.println(Arrays.toString(fileContent));
                        //check symbols
                        if (checkSymbols(fileContent)) {
                            System.out.println("The text is balanced");
                        } else {
                            System.out.println("The text is not balanced, check the symbols");
                        }
                        
                    } else if (choice == 3) {
                        break;
                    } else {
                        System.out.println("Invalid choice");
                        System.out.println();
                        sc.nextLine();
                    }
                }catch(Exception e){
                    System.out.println("Invalid input");
                    System.out.println();
                    
                }
            }*/

        String filePath = "test.txt";
        //read file
        List<String> content = Files.readAllLines(Paths.get(filePath));
        System.out.println(content);
        System.out.println();
        char[] fileContent = readFile(content);
        System.out.println(Arrays.toString(fileContent));
        System.out.println();
        //check symbols
        if (checkSymbols(fileContent)) {
            System.out.println("The symbols are correct");
        } else {
            System.out.println("The symbols are not correct");
        }

    }

}



