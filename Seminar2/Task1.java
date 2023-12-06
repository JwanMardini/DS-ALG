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



    private static boolean checkSymbols(List<String> content) {
        for (String line : content) {
            char[] lineContent = line.toCharArray();
            for (int i = 0; i < lineContent.length; i++){
                if (!inComment && lineContent[i] == '/' && lineContent[i + 1] == '/'){
                    break;
                }
                if (!inComment && lineContent[i] == '/' && lineContent[i + 1] == '*'){
                    inComment = true;
                    i++;
                    continue;
                }
                if (inComment && lineContent[i] == '*' && lineContent[i + 1] == '/'){
                    inComment = false;
                    i++;
                    continue;
                }
                if(!inComment && lineContent[i] == '(' || lineContent[i] == '{' || lineContent[i] == '['){
                    stack.push(lineContent[i]);
                }
                if(!inComment && lineContent[i] == ')' || lineContent[i] == '}' || lineContent[i] == ']'){
                    if(stack.isEmpty()){
                        return false;
                    }
                    char top = stack.pop();
                    if(top == '(' && lineContent[i] != ')'){
                        return false;
                    }
                    if(top == '{' && lineContent[i] != '}'){
                        return false;
                    }
                    if(top == '[' && lineContent[i] != ']'){
                        return false;
                    }
                }

            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) throws IOException {
        try (Scanner sc = new Scanner(System.in)){
            while(true){
                try{
                    System.out.println();
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
                        //check symbols
                        if (checkSymbols(content)) {
                            System.out.println("The text is balanced");
                            
                        } else {
                            System.out.println("The text is not balanced, check the symbols");
                        }

                    } else if (choice == 2) {
                        System.out.print("Enter text: ");
                        String text = sc.nextLine();
                        List<String> content = Arrays.asList(text);
                        System.out.println(content);
                        //check symbols
                        if (checkSymbols(content)) {
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
                    
                }
            }

        /*String filePath = "test.txt";
        //read file
        List<String> content = Files.readAllLines(Paths.get(filePath));
        System.out.println(content);
        //check symbols
        if (checkSymbols(content)) {
            System.out.println("The symbols are correct");
        } else {
            System.out.println("The symbols are not correct");
        }*/

    }

}
}
