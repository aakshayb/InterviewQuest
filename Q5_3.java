class Q5_3{
	/*public static int binaryOneNum(int n){
		int sum=0;
		while(n!=0){
			if(n%2==1){
				sum++;
			}
			n/=2;
		}
		return sum;
	}
	public static int findSmallest(int n){
		int temp=binaryOneNum(n);
		for(int i=n+1;;i++){
			if(binaryOneNum(i)==temp) 
				return i;
		}
	}
	public static int findBiggest(int n){
		int temp=binaryOneNum(n);
		for(int i=n-1;;i--){
			if(binaryOneNum(i)==temp)
				return i;
		}
	}*/
	public static int next(int x){
		int max_int = ~(1<<31);
		int num = count_one(x);
		if(num == 0 || x == -1) return -1;
		for(++x; count_one(x) != num && x < max_int; ++x);
		if(count_one(x) == num) return x;
		return -1;    
	}
	public static int previous(int x){
		int min_int = (1<<31);
		int num = count_one(x);
		if(num == 0 || x == -1) return -1;
		for(--x; count_one(x) != num && x > min_int; --x);
		if(count_one(x) == num) return x;
		return -1; 
	}
	public static int count_one(int x){
		int cnt = 0;
		for(int i=0; i<32; ++i){
			if((x&1)==1) ++cnt;
			x >>= 1;
		}
		return cnt;
	}
	
	public static int hammingWeight(int n){
		n=(n&(0x55555555))+((n>>1)&(0x55555555));
		n=(n&(0x33333333))+((n>>2)&(0x33333333));
		n=(n&(0x0f0f0f0f))+((n>>4)&(0x0f0f0f0f));
		n=(n&(0x00ff00ff))+((n>>8)&(0x00ff00ff));
		n=(n&(0x0000ffff))+((n>>16)&(0x0000ffff));
		return n;
	}
	
	public static int next1(int x){
		int xx = x, bit = 0;
		for(; (x&1) != 1 && bit < 32; x >>= 1, ++bit);
		for(; (x&1) != 0 && bit < 32; x >>= 1, ++bit);
		if(bit == 31) return -1; //011.., none satisify
		x |= 1;
		x <<= bit; // wtf, x<<32 != 0,so use next line to make x=0
		if(bit == 32) x = 0; // for 11100..00
		int num1 = hammingWeight(xx) - hammingWeight(x);
		int c = 1;
		for(; num1 > 0; x |= c, --num1, c <<= 1);
		return x;
	}

	public static int previous1(int x){
		int xx = x, bit = 0;
		for(; (x&1) != 0 && bit < 32; x >>= 1, ++bit);
		for(; (x&1) != 1 && bit < 32; x >>= 1, ++bit);
		if(bit == 31) return -1; //100..11, none satisify
		x -= 1;
		x <<= bit;
		if(bit == 32) x = 0;
		int num1 = hammingWeight(xx) - hammingWeight(x);
		x >>= bit;
		for(; num1 > 0; x = (x<<1) | 1, --num1, --bit);
		for(; bit > 0; x <<= 1, --bit);
		return x;
	}
	
	public static void main(String[] args){
		int number=11;
		//System.out.println(""+next1(number));
		//System.out.println(""+previous1(number));
		
		//求整数的二进制表示中1的个数
		int count=0;
		while(number>0){
			count++;
			number&=(number-1);
		}
		System.out.println(count);
	}
}