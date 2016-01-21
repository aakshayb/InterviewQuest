//import java.lang.StrictMath;
class Q8_1{
	//递归方法
	public static long fib0(long n){
		if(n<0) return -1;
		if(n==0) return 0;
		if(n==1) return 1;
		else return fib0(n-1)+fib0(n-2);
	}
	//公式法
	public static double fib1(int n){
		double gh5=java.lang.StrictMath.sqrt((double)5);
		return (java.lang.StrictMath.pow((1+gh5),n)-java.lang.StrictMath.pow((1-gh5),n))/(java.lang.StrictMath.pow((double)2,n)*gh5);
	}
	//迭代法
	public static long fib2(long n){
		if(n<0) return -1;
		if(n==0) return 0;
		int a=1;
		int b=1;
		for(int i=3;i<=n;i++){
			int c=a+b;
			a=b;
			b=c;
		}
		return b;
	}
	public static void main(String[] args){
		System.out.println(fib0(7)+"");
		System.out.println(fib1(7)+"");
		System.out.println(fib2(7)+"");
	}
}