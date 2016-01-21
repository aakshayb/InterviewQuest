class Q1_2{
	//字符串反转方法一：
	private static void reserse(char[] arr){
		/*for(int start=0,end=arr.length-1;start<end;start++,end--){  //或：  for(int i=0;i<arr.length/2;i++)
			swap(arr,start,end);
		}*/
		//或：  
		int length=arr.length;
		for(int i=0;i<length/2;i++){
			swap(arr,i,length-1-i);
		}
	}
	public static String reserseString(String str){
		//将字符串转换为字符数组
		char[] arr=str.toCharArray();
		//将字符数组反转
		reserse(arr);
		//将字符数组转化为字符串
		return new String(arr);
	}
	private static void swap(char[] arr,int x,int y){
		char temp=arr[x];
		arr[x]=arr[y];
		arr[y]=temp;
	}
	//方法二：直接用字符串反转
	public static String reserseString2(String str){
		String tempStr="";
		for(int i=str.length()-1;i>=0;i--){
			tempStr+=str.charAt(i);
		}
		return tempStr;
	}
	
	public static void main(String[] args){
		String str="1234567890";
		System.out.println(reserseString(str));
		System.out.println(reserseString2(str));
	}
}