class Q1_5{
	public static String replaceSpaces(String str){
		String strTemp="";
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)!=' '){
				strTemp+=str.charAt(i);
			}else{
				strTemp+="%20";
			}
		}
		return strTemp;
	}
	
	public static char[] replaceSpaces2(char[] str){
		int spaceNum=0;
		int len=str.length;
		for(int i=0;i<len;i++){
			if(str[i]==' ')
				spaceNum++;
		}
		char[] arr=new char[len+spaceNum*2];
		for(int i=0,j=0;i<len;i++){
			if(str[i]!=' '){
				arr[j]=str[i];
				j++;
			}else{
				arr[j]='%';
				arr[j+1]='2';
				arr[j+2]='0';
				j+=3;
			}
		}
		return arr;
	}
	public static void main(String[] args){
		String str="i am navy!";
		char[] str2={'i',' ','a','m',' ','n','a','v','y','!'};
		System.out.println(replaceSpaces(str));
		System.out.println(replaceSpaces2(str2));
	}
}