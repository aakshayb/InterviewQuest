class Q8_2{
	//
	public static int path(int m,int n){
		return factorial(m-1+n-1)/(factorial(m-1)*factorial(n-1));
	}
	public static int factorial(int n){
		if(n==0) return 1;
		else return n*factorial(n-1);
	}
	//recursion
	public static int path1(int m,int n){
		if(m==1||n==1) return 1;
		else return path1(m-1,n)+path1(m,n-1);
	}
	public static void main(String[] args){
		int m=4;
		int n=3;
		System.out.println(path(m,n));
		System.out.println(path1(m,n));
	}
}

