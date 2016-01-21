class Q9_1{
	//error
	public static int[] mergeSortedArray(int[] a,int[] b,int n,int m){
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(b[i]<a[j]){
					for(int k=n;k>j;k--)
						a[k]=a[k-1];
					a[j]=b[i];
					n+=1;
					break;
				}
			}
		}
		return a;
	}

	public static void merge(int[] a,int[] b,int n,int m){
		int k=m+n-1;
		int i=n-1;
		int j=m-1;

		while(i>=0&&j>=0){
			if(a[i]>b[j]){
				a[k--]=a[i--];
			}else{
				a[k--]=b[j--];
			}
		}
		while(j>=0){
			a[k--]=b[j--];
		}
	}
	
	public static void main(String[] args){
		int[] a =new int[10];
		a[0]=1;
		a[1]=3;
		a[2]=5;
		int[] b = new int[5];
		b[0]=2;
		b[1]=4;
		b[2]=6;
		b[3]=7;
		b[4]=8;
		System.out.println(a.length+" "+b.length);
		//int[] c=mergeSortedArray(a,b,3,5);
		merge(a,b,3,5);
		for(int i=0;i<8;i++){
			System.out.print(a[i]+" ");
		}
	}
}