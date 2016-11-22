package main;


import java.util.*;


public class Express {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		while(scan.hasNextLine()){
			String input = scan.nextLine();
			input = input.replaceAll(" ","");
			String arraySplit[] = input.split("/");
			String expression,operations;
			operations = expression = "";
			if(arraySplit.length > 1){
			expression = input.split("/")[0];
			operations = input.split("/")[1];
			operations = operations.replaceAll("RR", "");
			operations = operations.replaceAll("S+", "S");
			}else{
				expression = input.split("/")[0];
			}
			for(int i = 0; i < operations.length(); i ++){
				if(operations.charAt(i) == 'R'){
					expression = reverse(expression);
				}else if(operations.charAt(i) == 'S'){
					expression = simplify(expression);
				}
			}
			System.out.println(expression);
		}
		scan.close();
	}
	private static String simplify(String expression){
		String result = "";
		TreeMap<Integer, Integer> startEndIndex = new TreeMap<Integer,Integer>();
		if(expression.length() == 0){
			return result;
		}
		for(int i =0; i < expression.length(); i ++ ){
			if(expression.charAt(i) == '('){
				startEndIndex.put(i,null);
			}
		}
		for(Integer eachStartIndex : startEndIndex.keySet()){
			int count =0;
			for(int i =eachStartIndex; i < expression.length(); i ++){
				if(expression.charAt(i) == '('){
					count += 1;
				}
				if(expression.charAt(i) == ')'){
					count -= 1;
					if(count == 0){
						startEndIndex.put(eachStartIndex, i);
						break;
					}
				}
			}
		}
		int previous  = -1;
		for(Integer eachStartIndex : startEndIndex.keySet()){
			int current = eachStartIndex;
			if(previous + 1 == current){
				expression = removeParathessis(expression,eachStartIndex,startEndIndex.get(current));
			}
			previous = current;
		}
		result = expression.replaceAll(" ", "");
		return result;
	}
private static String removeParathessis(String expression, int start, int end) {
		// TODO Auto-generated method stub
	   expression = expression.substring(0,start) +  " " + expression.substring(start+1,end) +" "+ expression.substring(end+1,expression.length());
		
		return expression;
	}
	
	private static String reverse(String input) {
		input = new StringBuilder(input).reverse().toString();
		input = input.replaceAll("\\(", "+");
		input = input.replaceAll("\\)", "(");
		input = input.replaceAll("\\+", ")");
		return input;
	}

}




/*
private static String simplify(String expression) {
	Stack<Integer> stack=new Stack<>();
	int bracesCount=0;
	String s="";
	for(int i=0;i<expression.length();i++)
	{
		if(expression.charAt(i)=='(')
		{
			bracesCount++;
			if(i>0 && Character.isLetter(expression.charAt(i-1)))
			{
				s+="(";
			}
			else {
				stack.push(bracesCount);
			}
		}
		else if(expression.charAt(i)==')') {
			if(!stack.isEmpty() && stack.peek()==bracesCount)
			{
				stack.pop();
			}
			else{
				s+=")";
			}
			bracesCount--;
		}
		else {
			s+=expression.charAt(i);
		}
	}
	return s;
}
*/