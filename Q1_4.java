class Q1_4{
	public static boolean isAnagrams(String str1,String str2){
		if(str1.length()!=str2.length())
			return false;
		return change(str1).equals(change(str2));
	}
	public static String change(String str){
		char[] arr=str.toCharArray();
		qsort(arr,0,str.length()-1);
		return new String(arr);
	}
	public static void qsort(char[] s,int l,int r){
		int i,j;
		char x;
		if(l<r){
			i=l;
			j=r;
			x=s[i];
			while(i<j){
				while(i<j&&s[j]<x) j--;
				if(i<j) s[i++]=s[j];
				while(i<j&&s[i]>x) i++;
				if(i<j) s[j--]=s[i];
			}
			s[i]=x;
			qsort(s,l,i-1);
			qsort(s,i+1,r);
		}
	}
	//方法二
	public static boolean isAnagrams2(String str1,String str2){
		if(str1.length()!=str2.length())
			return false;
		int[] t=new int[256]; //初始化默认为0
		for(int i=0;i<str1.length();i++){
			++t[(int)str1.charAt(i)];
			--t[(int)str2.charAt(i)];
		}
		for(int i=0;i<t.length;i++){
			if(t[i]!=0)
				return false;
		}
		return true;
	}
	public static void main(String[] args){
		String str1="abcdd";
		String str2="dabdc";
		System.out.println(isAnagrams(str1,str2));
		System.out.println(isAnagrams2(str1,str2));
	}
}