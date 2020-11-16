package _requirements.part3;
import java.io.*;
import java.util.*;

public class HW2_Part3 {
	
	public static void main(String[] args) throws FileNotFoundException {
		HW2_Part3 input = new HW2_Part3();
		String[] line = new String[] {};
		List<String[]> expList = new ArrayList<String[]>();
		List<String[]> results = new ArrayList<String[]>();

		// scan and grab the text file
		Scanner textScanner = new Scanner (new File(
				"src/_requirements/part3/expressions.txt"));
		
		while (textScanner.hasNext()){	
	        line = textScanner.nextLine().split("");
			expList.add(line);
		}

		// make the stack
		//input.stack(expList, results);
		
		// print the results
	    for (var exp: expList) {
	    	//for (var r: results) {
			System.out.print("The value of ");
				   	
			String equation = Arrays.toString(exp)
					.replace(",", "")
					.replace("[", "")
					.replace("]", "")
					.replaceAll("\\s","")
					.trim();
				   	
			System.out.print(equation);
			System.out.print(" is ");
			System.out.print("result");
			System.out.print("\n");	    		
	    	 //}
	    }
	}
	
	public List<String[]> stack(List<String[]> expList, List<String[]> results) {
		
		LinkedStack<String> operators = new LinkedStack<String>(); // +,-,*,
		LinkedStack<String> operands = new LinkedStack<String>();  // 1,2,3

		for (var exp: expList) {
	    	for (int n = 0; n < exp.length; n++) {  		
	    		String test = exp[n].toString();

	    		if (exp[n].toString() == "(" ) {
	    			String test2 = "match";
	    			continue;
	    			}
	    		
	    		else if (exp[n].toString() == "0"
	    				|| exp[n].toString() == "1" || exp[n].toString() == "2" 
	    				|| exp[n].toString() == "3" || exp[n].toString() == "4" 
	    				|| exp[n].toString() == "5" || exp[n].toString() == "6"
	    				|| exp[n].toString() == "7" || exp[n].toString() == "8" 
	    				|| exp[n].toString() == "9") {
	    			operands.push(exp[n].toString());
	    			}
	    		
	    		else if (exp[n].toString() == "+" || exp[n].toString() == "-" 
	    				|| exp[n].toString() == "*" || exp[n].toString() == "/") {
	    			operators.push(exp[n].toString());
	    			}
	    		
	    		else if (exp[n].toString() == ")") {

	                // operand 1 
	                String op1 = operands.top(); 
	                operands.pop(); 
	  
	                // operand 2 
	                String op2 = operands.top(); 
	                operands.pop(); 
	  
	                // operator 
	                String op = operators.top(); 
	                operators.pop();

	                // Add operands and operator 
	                String tmp = Integer.parseInt(op1) + op + Integer.parseInt(op2);
	                System.out.println(tmp);
	                operands.push(tmp);               
	    		}
	    		
    		}
	    	String[] result = operands.top().split(" ");
	    	results.add(result);
	    }
		return results; 
	}

}