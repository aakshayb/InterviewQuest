class Q1_1{
	public static void main(String[] arg){
		String s1="i am navy.";
		String s2="abcdefghijklmnopqstuvwxyzABCDEF1234567890";
		System.out.println(isUniqueChars0(s1));
		System.out.println(isUniqueChars0(s2));
		
		//System.out.println(isUniqueChars1(s1));
		//System.out.println(isUniqueChars1(s2));
		
		//System.out.println(isUniqueChars2(s1));
		//System.out.println(isUniqueChars2(s2));
	}
	
	public static boolean isUniqueChars0(String str){
		boolean[] char_set=new boolean[256];
		for(int i=0;i<str.length();i++){
			int val=str.charAt(i);
			if(char_set[val]) return false;
			char_set[val]=true;
		}
		return true;
	}
	/*//位运算
	public static boolean isUniqueChars1(String str){
		int char_set[8]={0};
		for(int i=0;i<str.length();++i){
			int v=str.charAt(i);
			int idx=v/32, shift=v%32;
			if(char_set[idx]&(1<<shift)) return false;
			char_set[idx] |=(1<<shift);
		}
		return true;
	}  */
	//字符集只是a-z(或是A-Z)
	public static boolean isUniqueChars2(String str){
		int checker=0;
		for(int i=0;i<str.length();++i){
			int val=str.charAt(i)-'a';
			if((checker&(1<<val))>0) return false;
			checker|=(1<<val);
		}
		return true;
	}
}