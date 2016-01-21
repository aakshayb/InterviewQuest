class Q20_1{
	public static void main(String[] args){
		System.out.println(add_no_arithm(759,674));
		System.out.println(add_no_arithm1(7,5));
	}

	public static int add_no_arithm(int a,int b){
		if(b==0) return a;
		int sum=a^b;  //add without carrying
		int carry=(a&b)<<1; //carry,but don't add
		return add_no_arithm(sum,carry);  //recurse
	}

	//recurse iteration
	public static int add_no_arithm1(int a,int b){
		while(b!=0){
			int sum=a^b;
			int carry=(a&b)<<1;
			a=sum;
			b=carry;
		}
		return a;
	}
}