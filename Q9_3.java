class Q9_3{
	public static int search(int[] a,int fromIndex,int toIndex,int value){
		int low=fromIndex;
		int high=toIndex-1;
		while(low<=high){
			int mid=(low+high)>>>1;
		/*	int midVal=a[mid];
			if(a[low]<value){
				if(midVal>value)
					high=mid-1;
				else if(midVal<)
			}*/
			if(a[mid]==value) return mid;
			if(a[mid]>=a[low]){
				if(value<a[mid]&&value>=a[low])
					high=mid-1;
				else
					low=mid+1;
			}else{
				if(value<=a[high]&&value>a[mid])
					low=mid+1;
				else
					high=mid-1;
			}
		}
		return -1;
	}
	public static void main(String[] args){
		int[] a={
        	15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14
    	};
    	System.out.println(search(a,0,12,5));
	}
}