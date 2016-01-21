import java.util.ArrayList;  
import java.util.Arrays;  
import java.util.Comparator;  
import java.util.HashMap;  

class Q20_7{
	public static void main(String[] args){
		String[] arr = createGiantArray();  
        printLongestWord(arr);
	}

	static class LengthComparator implements Comparator<String>{
		public int compare(String o1,String o2){
			return o2.length()-o1.length();
		}
	}

	public static String printLongestWord(String[] arr){
		HashMap<String,Boolean> map=new HashMap<String,Boolean>();
		for(String str:arr){
			map.put(str,true);
		}
		Arrays.sort(arr,new LengthComparator());

		for(String s:arr){
			if(canBuildWord(s,true,map)){
				System.out.println(s);
				return s;
			}
		}
		return "";
	}

	// DFS深搜  
	public static boolean canBuildWord(String str,boolean isOriginalWord,HashMap<String,Boolean> map){
		if(map.containsKey(str)&&!isOriginalWord){  // 一个词只能由其他词组成，自己不能组成自己！  
			return map.get(str);
		}
		for(int i=1;i<str.length();i++){
			String left=str.substring(0,i);
			String right=str.substring(i);
			if(map.containsKey(left)&&map.get(left)==true&&canBuildWord(right,false,map)){
				return true;
			}
		}
		map.put(str,false);  // 记录str不能被其他的单词表示，如果以后再遇到str就可以不继续找了 
		return false;
	}

	public static String[] createGiantArray() {  
        String arr[] = {"test", "tester", "testertest", "testing", 
                "apple", "seattle", "banana",  "batting", "ngcat", 
                "batti","bat", "testingtester", "testbattingcat"};
        return arr;
    }
}