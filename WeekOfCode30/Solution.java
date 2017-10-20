package WeekOfCode30;
import java.util.*;

public class Solution {	
	static int comboCount;
	static long functionCall;
	static int height;
	static HashSet<String> vowels;
	static HashSet<String> general;
	static HashSet<String> consonents;
	static HashMap<String,String> mimoize = new HashMap<String,String>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String vowelss[]={"a","e","i","o","u"};
        String consonants[]={"b","c","d","f","g","h","j","k","l","m","n","p","q","r","s", "t", "v", "w", "x","z"};
        
        general = new HashSet<String>();
        vowels = new HashSet<String>();
        for(int i=0;i<vowelss.length;i++){
        	general.add(vowelss[i]);
        	vowels.add(vowelss[i]);
        }
        consonents = new HashSet<String>();
        for(int i=0;i<consonants.length;i++){
        	general.add(consonants[i]);
        	consonents.add(consonants[i]);
        }
		
		
		height = in.nextInt();
		comboCount = 0;
		functionCall = 0;
		System.out.println(trieDFS(0,"",true,false));
		System.err.println("combination ===>" + comboCount);
		//System.err.println("function call ===>" + functionCall);
		in.close();
	}
	public static String trieDFS(int currentheight,String s,boolean isFirst,boolean isVowelLevel){
		//functionCall++;
//		if(mimoize.containsKey(s)){
//			return mimoize.get(s);
//		}
//		else{
		String result = "";
		if(currentheight == height){
			s += "\n";
			comboCount ++;
			return s;
		}else{
			if(isFirst){
				for(String c : general){
					if(!c.equals("y")){
						if(vowels.contains(c)){
							result += trieDFS(currentheight + 1,s+c ,false,false);
						}else{
							result += trieDFS(currentheight + 1,s+c ,false,true);
						}
					}
				}
			}else{
				if(isVowelLevel){
					for(String c : vowels){
						result += trieDFS(currentheight + 1,s+c ,false,false);
					}
				}else{
					for(String c : consonents){
						if(!c.equals("y") && !vowels.contains(c)){	
							result += trieDFS(currentheight + 1,s+c ,false,true);
						}
					}
				}
			}
			//mimoize.put(s, result);
			return result;
		}
	//}
	}
	
}
