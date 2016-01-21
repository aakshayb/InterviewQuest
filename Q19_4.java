class Q19_4{
	public static void main(String[] args){
		System.out.println(findMax(5,9));
	}
	public static int findMax(int a,int b){
		int t=a-b;
		int k=(t>>31)&1;
		return a-k*t;
	}
}