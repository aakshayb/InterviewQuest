class Q5_7{
	
	public static int fetch(int a[],int i,int j){
		return (a[i]>>j)&1;
	}
	public static int get(int[] a ,int i){
		int result = 0 ;
		for(int j=31;j>=0;--j){
			result = result<<1|fetch(a,i,j);
		}
		return result ;
	}
	
	public static void main(String[] args){
		
	}
}
