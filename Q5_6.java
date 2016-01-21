class Q5_6{
	public static void print_binary(int x){
		String s="";
		for(int i=0;i<32&&x!=0;++i,x>>=1){
			if((x&1)==1) s="1"+s;
			else s="0"+s;
		}
		System.out.println(s);
	}
	public static int swap_bits(int x){
		return ((x&0x55555555)<<1)|((x>>1)&0x55555555);
	}
	public static int swap_bits1(int x){
		return ((x&0x55555555)<<1)|((x&0xAAAAAAAA)>>1);
	}
	public static void main(String[] args){
		int x = -7665543;
		print_binary(x);
		print_binary(swap_bits(x));
		print_binary(swap_bits1(x));
	}
}