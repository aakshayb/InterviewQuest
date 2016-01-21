class Q10_4{
	public static int INF=~(1<<31);
	public static void main(String[] args){
		int[] a={8,0,-8,-5,9};
		int[] b={3,5,3,0,-3};
		for(int i=0;i<5;i++){
			System.out.print(sub(a[i],b[i])+" ");
			System.out.print(times(a[i],b[i])+" ");
			System.out.println(divide(a[i],b[i]));
		}
	}
	public static void swap(int a,int b){
		a=a^b;
		b=a^b;
		a=a^b;
	}
	public static int flipsign(int a){
		int d=a<0?1:-1;
		int opa=0;
		while(a!=0){
			a+=d;
			opa+=d;
		}
		return opa;
	}

	public static int abs(int a){
		if(a<0) a=flipsign(a);
		return a;
	}

	public static boolean opsign(int a,int b){
		return (a<0&&b>0)||(a>0&&b<0);
	}

	public static int sub(int a,int b){
		return a+flipsign(b);
	}

	public static int times(int a,int b){
		int aa=abs(a);
		int bb=abs(b);
		int res=0;
		if(aa<bb) swap(aa,bb);
		for(int i=0;i<bb;++i,res+=aa);
		if(opsign(a,b)) res=flipsign(res);
		return res;
	}

	public static int divide(int a,int b){
		if(b==0) return INF;
		int aa=abs(a); 
		int bb=abs(b);
		int res=0;
		for(;(aa-=bb)>=0;++res);
		if(opsign(a,b))
			res=flipsign(res);
		return res;
	}
}