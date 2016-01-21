/*

Write a method to randomly generate a set of m integers from an array of size n. Each element must have equal probability of being chosen.

*/

import java.util.Random;

class Q20_3{
	public static void main(String[] args){
		int n=9,m=5;
		int[] a={
			1,2,3,4,5,6,7,8,9
		};
		pickMRandomly(a,n,m);
		for(int i=0;i<m;i++){
			System.out.print(a[i]+" ");
		}
	}
	public static void swap(int[] a,int i,int j){
		int t=a[i];
		a[i]=a[j];
		a[j]=t;
	}
	public static void pickMRandomly(int[] a,int n,int m){
		Random random = new Random();
		for(int i=0;i<m;++i){
			int j=random.nextInt(n-1)%(n-1-i+1) + i;
			swap(a,i,j);
		}
	}
}