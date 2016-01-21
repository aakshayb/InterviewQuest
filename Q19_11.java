import java.util.*;
/*
Design an algorithm to find all pairs of integers within an array which sum to a specified value.

*/
class Q19_11{
	public static void main(String[] args){
		int[] a={5,2,-4,9,4,3,8,6};
		int sum=10;
		printPairSum(a,sum);
	}

	public static void printPairSum(int[] a,int sum){
		if(a==null||a.length<2) return;

		Arrays.sort(a);
		int low=0,high=a.length-1;
		while(low<high){
			if(a[low]+a[high]>sum){
				high--;
			}else if(a[low]+a[high]<sum){
				low++;
			}else{
				System.out.println(a[low]+" "+a[high]);
				low++;
				high--;
			}
		}
	}
}