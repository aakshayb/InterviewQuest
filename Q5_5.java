class Q5_5{
	public static int hammingWeight(int n){
		n=(n&(0x55555555))+((n>>1)&(0x55555555));
		n=(n&(0x33333333))+((n>>2)&(0x33333333));
		n=(n&(0x0f0f0f0f))+((n>>4)&(0x0f0f0f0f));
		n=(n&(0x00ff00ff))+((n>>8)&(0x00ff00ff));
		n=(n&(0x0000ffff))+((n>>16)&(0x0000ffff));
		return n;
	}
	public static int convert_num(int num1,int num2){
		return hammingWeight(num1^num2);
	}
	public static void main(String[] args){
		int num1=31;
		int num2=14;
		System.out.println(convert_num(num1,num2)+"");
	}
}