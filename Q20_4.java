class Q20_4{
	public static void main(String[] args){
		System.out.println(count2sR(279));
		System.out.println(count2sI(2540));
	}

	public static int count2sR(int n){
		if(n==0) return 0;
		int power=1;
		while(10*power<n)
			power*=10;
		int first=n/power;
		int remainder=n%power;

		//counts 2s from first digit
		int nTwosFirst=0;
		if(first>2) 
			nTwosFirst+=power;
		else if(first==2)
			nTwosFirst+=remainder+1;

		//count 2s from all other digits
		int nTwosOther=first*count2sR(power-1)+count2sR(remainder);

		return nTwosFirst+nTwosOther;
	}

	public static int count2sI(int num){
		int countof2s=0,digit=0;
		int j=num,seendigits=0,position=0,pow10_pos=1;

		while(j>0){
			digit=j%10;
			int pow10_posMinus1=pow10_pos/10;
			countof2s+=digit*position*pow10_posMinus1;

			if(digit==2){
				countof2s+=pow10_pos;
			}
			seendigits=seendigits+pow10_pos*digit;
			pow10_pos*=10;
			position++;
			j=j/10;
		}
		return countof2s;
	}
}