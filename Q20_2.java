/*
Write a method to shuffle a deck of cards. It must be a perfect shuffle - in other words, each 52! permutations of the deck has to be equally likely. 
Assume that you are given a random number generator which is perfect.
*/

class Q20_2{


	public static void main(String[] args){
		//Random(Timer(0));
		int n=9;
		int[] a={1,2,3,4,5,6,7,8,9};
		randomShuffle(a,n);
		for(int i=0;i<n;++i){
			System.out.println(a[i]);
		}
	}

	public static void swap(int[] a,int i,int j){
		int t=a[i];
		a[i]=a[j];
		a[j]=t;
	}

	public static void randomShuffle(int[] a,int n){
		for(int i=0;i<n;++i){
			int j=(int)(Math.random()*(n-i)) + i;  //create i to n-1 random
			swap(a,i,j);
		}
		
	}
}