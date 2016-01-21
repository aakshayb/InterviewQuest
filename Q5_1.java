class Q5_1{
	public static void print_binary(int n){
		String binaryNum="";
		while(n>=1){
			binaryNum+=n%2;
			n=n/2;
		}
		StringBuffer num = new StringBuffer(binaryNum);
		System.out.println(num.reverse().toString());
	}
	//方法一
	public static int update_bits(int n,int m,int i,int j){
		int max=~0;//全为1
		System.out.println(max+"");
		int left=max-((1<<j+1)-1);
		int right=((1<<i)-1);
		int mask=left|right;
		return (n&mask)|(m<<i);
	}
	//方法二
	public static int update_bits1(int n,int m,int i,int j){
		int ret=(1<<i)-1;
		ret&=n;
		return ((n>>(j+1))<<(j+1))|(m<<i)|ret;
	}
	public static void main(String[] args){
		int n=1<<10,m=21;           //n以十进制形式存储，为1024
		//System.out.println(n+"");
		int ans = update_bits(n, m, 2, 6);
		//System.out.println(ans+"");
		print_binary(n);
		print_binary(m);
		print_binary(ans);
	}
}