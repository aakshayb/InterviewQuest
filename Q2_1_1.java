class Q2_1_1{

	//Time Limit Exceeded
	public static int removeDuplicates(int[] A) {
        int len=A.length;
        for(int i=0;i<len-1;i++){
            for(int j=i+1;j<len;j++){
                if(A[i]==A[j]){
                    int t=j;
                    while(t<len-1){
                        A[t++]=A[t];
                    }
                    len--;
                }
            }
        }
        return len;
    }

    public static int removeDuplicates1(int[] A){
    	if(A.length<2) 
    		return A.length;
    	int i=1;
    	int j=0;
    	while(i<A.length){
    		if(A[i]==A[j]){
    			i++;
    		}else{
    			A[++j]=A[i++];
    		}
    	}
    	return j+1;
    }

    public static int removeDuplicates2(int[] A){
        int n=A.length;
        if (n == 0)
              return 0;
              
        int start = 0;
        int key = A[0];
        for(int i = 0; i < n; i++)
            if (A[i] != key){
                A[start++] = key;
                key = A[i];                
            }  
        A[start++] = key;
        return start;
    }

	public static void main(String[] args){
		int[] a={1,1,5,3,7,3};
		//System.out.println(removeDuplicates2(a));
		System.out.println(removeDuplicates1(a));
        for(int i=0;i<a.length;i++)
            System.out.print(a[i]+" ");
	}
}