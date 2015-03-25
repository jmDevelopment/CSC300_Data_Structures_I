package CSC300_HW6;

import java.util.Scanner;
import java.util.Stack;

public class BalancedApp {

	
	public static void main(String[] args){
		
		String equation = "345*+2/";
		Scanner sc = new Scanner(equation);
	    Stack<Integer> stack = new Stack<Integer>();

	    while (sc.hasNext()) {
	    	System.out.println(sc.nextInt());
	        if (sc.hasNextInt()) {
	            stack.push(sc.nextInt());
	            continue;
	        }
	        int b = stack.pop();
	        int a = stack.pop();
	        char op = sc.next().charAt(0);
	        if      (op == '+') stack.push(a + b);
	        else if (op == '-') stack.push(a - b);
	        else if (op == '*') stack.push(a * b);
	        else if (op == '/') stack.push(a / b);
	        else if (op == '%') stack.push(a % b);
	    }

	    sc.close();
	    System.out.println(stack.pop());
	}
	
}
