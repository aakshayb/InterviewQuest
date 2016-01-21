import java.util.Arrays;
import java.util.Comparator;

class Q9_2{
	public static void main(String[] args){
		String[] s= new String[]{
				"yzax","axyz","abc","bac","zyxa","fg","gf"
		};
		Arrays.sort(s,new AnagramComparator());
		for(int i=0;i<s.length;i++){
			System.out.println(s[i]);
		}
	}
}

class AnagramComparator implements Comparator<String>{
	public String sortChars(String s){
		char[] content=s.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}

	public int compare(String s1,String s2){
		return sortChars(s1).compareTo(sortChars(s2));
	}
}