package codeSprint;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Details{

	TreeSet<Integer> inserted;
	TreeSet<Integer> deleted;

	public Details(){
		inserted = new TreeSet<>();
		deleted = new TreeSet<>();
	}
}


public class FileCommand {
	static HashMap<String, Details> fileMap = new HashMap<>();
	public static String[] parseFileName(String fileName){
		String fetchedNumber = "";
		if(fileName.charAt(fileName.length() -1 ) != ')'){
			fetchedNumber = "0";
		}else{
    		for(int i = fileName.length() -1; i >= 0; i --){
    			if(fileName.charAt(i) == '('){
    				fileName = fileName.substring(0,i);
    				break;
    			}else{
    				if(fileName.charAt(i)  != ')'){
    					fetchedNumber = fileName.charAt(i) + fetchedNumber;
    				}
    			}
    		}
		}
		return new String[]{fileName,fetchedNumber};
	}
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        // Process each command
        
        for(int a0 = 0; a0 < q; a0++){
            // Read the first string denoting the command type
            String command = in.next();
            
            if(command.equals("rnm")){
            	String existingFile[] = parseFileName(in.next());
            	String fileName = existingFile[0];
            	String result = "";
            	deleteCommand(existingFile);
    			if(Integer.parseInt(existingFile[1]) == 0){
    				result += "r "+fileName+ " -> ";	
    			}else{
    				result += "r "+fileName+"("+ Integer.parseInt(existingFile[1]) + ") -> ";
    			}
    		
            	String newFile[] = parseFileName(in.next());
            	fileName = newFile[0];
            	int newNo = insertFileName(fileName);
            	
            	if(newNo == 0){
    				result += fileName;	
    			}else{
    				result += fileName+"("+ newNo + ")";
    			}
            	System.out.println(result);
            }else{
            	if(command.equals("crt")){
            		// create
            		String fileName = in.next();
            		int no = insertFileName(fileName);
            		if(no == 0){
    					System.out.println("+ "+fileName);	
    				}else{
    					System.out.println("+ "+fileName+"("+ no + ")");
    				}
            	}else if(command.equals("del")){
            		String fileName = in.next();
            		String parsedFileName[] = parseFileName(fileName);
            		fileName = parsedFileName[0];
            		deleteCommand(parsedFileName);
            		if(Integer.parseInt(parsedFileName[1]) == 0){
        				System.out.println("- "+fileName);	
        			}else{
        				System.out.println("- "+fileName+"("+ Integer.parseInt(parsedFileName[1]) + ")");
        			}
            	}
            }
        }
        in.close();
    }
	private static int insertFileName(String fileName) {
		int result = 0;
		if(fileMap.containsKey(fileName)){
			Details details = fileMap.get(fileName);
			if(details.deleted.size() > 0){
				int no = 0;
				for(int eachDeletedNo: details.deleted){
					no = eachDeletedNo;
					break;
				}
				details.deleted.remove(no);
				details.inserted.add(no);
				result = no;
			}else{
				int newNo = 0;
				for(int lastInsertedNo: details.inserted.descendingSet()){
					newNo = lastInsertedNo;
					break;
				}
				newNo += 1;
				details.inserted.add(newNo);
				result = newNo;
			}
			fileMap.put(fileName, details);
			return result;
		}else{
			Details details = new Details();
			details.inserted.add(0);
			fileMap.put(fileName, details);
			return result;
		}
	}
	private static void deleteCommand(String[] parsedFileName) {
		String fileName = parsedFileName[0];
		if(fileMap.containsKey(fileName)){
			Details details = fileMap.get(fileName);
			int no = Integer.parseInt(parsedFileName[1]);
			details.inserted.remove(no);
			details.deleted.add(no);
			fileMap.put(fileName, details);
		}
	}
}


