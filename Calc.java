import java.util.Scanner;
import java.util.Stack;

public class Calc {

    private static int priority (char token){
        if (token == '*' || token == '/') return 3;
        else if(token == '+' || token == '-') return 2;
        else if(token == '(') return 1;
        else if(token == ')') return -1;
        else return 0;

    }


    public static String Expres(String Exp) {
        Scanner scanner = new Scanner(System.in);
        Exp = scanner.nextLine();

        String box = "";
        Stack<Character> stack = new Stack<>();

        int prior;
        for (int a = 0; a < Exp.length(); a++) {
            prior = priority(Exp.charAt(a));

            String rome ="";
            if (prior == 0) box += Exp.charAt(a);
            if (prior == 1) stack.push(Exp.charAt(a));
            if (prior > 1) {

                box += " ";

                while (!stack.empty()) {
                    if (priority(stack.peek()) >= prior) box += stack.pop();
                    else break;
                }
                stack.push(Exp.charAt(a));
            }
            if (prior == -1) {
                box += " ";
                while (priority(stack.peek()) != 1) box += stack.pop();
                stack.pop();
            }

        }
            while (!stack.empty()) box += stack.pop();

        return box;
    }

    public static double Answer (String ans){
        String operand = "";
        Stack<Double> stk = new Stack<>();

        for (int i = 0; i < ans.length(); i++){
            if (ans.charAt(i) == ' ') continue;

            if (priority(ans.charAt(i)) == 0){

                while (ans.charAt(i) != ' ' && priority(ans.charAt(i)) == 0) {
                    operand += ans.charAt(i++);
                    if (i == ans.length()) break;}

                    stk.push(Double.parseDouble(operand));
                    operand = new String();
                    if (operand.equals("I")) return 1;
                    if (operand.equals("II")) return 2;
                    if (operand.equals("III")) return 3;
                    if (operand.equals("IV")) return 4;
                    if (operand.equals("V")) return 5;
                    if (operand.equals("VI")) return 6;
                    if (operand.equals("VII")) return 7;
                    if (operand.equals("VIII")) return 8;
                    if (operand.equals("IX")) return 9;
                    if (operand.equals("X")) return 10;


                }
                if (priority(ans.charAt(i)) > 1){

                    double a = stk.pop(), b= stk.pop();

                    if (ans.charAt(i) == '+') stk.push(b + a);
                    if (ans.charAt(i) == '-') stk.push(b - a);
                    if (ans.charAt(i) == '*') stk.push(b * a);
                    if (ans.charAt(i) == '/') stk.push(b / a);
                }

            }

        return stk.pop();

    }
}
