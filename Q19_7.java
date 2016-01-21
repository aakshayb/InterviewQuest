class Q19_7{
	public static boolean g_invalid=false;
	public static void main(String[] args){
		int[] a={2,-8,3,-2,4,-10};
		int max_sum=getMaxSum(a);
		if(g_invalid)
			System.out.println("Invalid Input!");
		else
			System.out.println(max_sum);
	}
	public static int getMaxSum(int[] a,int n){
		if(a==null||n<=0){
			g_invalid=true;
			return 0;
		}
		g_invalid=false;

		int max_sum=1<<31;
		int cur_sum=0;
		for(int i=0;i<n;++i){
			if(cur_sum<=0)
				cur_sum=a[i];
			else
				cur_sum+=a[i];
			if(cur_sum>max_sum)
				max_sum=cur_sum;
		}
		return max_sum;
	}
	//method2, but if the array is all negative numbers, can't use this method
	public static int getMaxSum(int[] a){
		int maxsum=0;
		int sum=0;
		for(int i=0;i<a.length;i++){
			sum+=a[i];
			if(maxsum<sum){
				maxsum=sum;
			}else if(sum<0){
				sum=0;
			}
		}
		return maxsum;
	}
}