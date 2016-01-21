class Q8_7{
	
	// traverse
	public static int traverseCount(int n){
		int count=0;

		for(int i=0;i<=n/25;i++){
			for(int j=0;j<=n/10;j++){
				for(int k=0;k<=n/5;k++){
					for(int l=0;l<=n;l++){
						int sum=25*i+10*j+5*k+l;
						if(sum==n)
							count++;
						else if(sum>n)
							break;
					}
				}
			}
		}
		return count;
	}
	//recursion
	public static int recurCount(int sum,int c,int n){
		int count=0;
		if(sum<=n){
			if(sum==n) return 1;
			if(c>=25) 
				count+=recurCount(sum+25,25,n);
			if(c>=10)
				count+=recurCount(sum+10,10,n);
			if(c>=5)
				count+=recurCount(sum+5,5,n);
			if(c>=1)
				count+=recurCount(sum+1,1,n);
		}
		return count;
	}
	public static void main(String[] args){
		int n=27;
		//System.out.println(count(n));
		System.out.println(traverseCount(n));
		System.out.println(recurCount(0,25,n));
	}
}