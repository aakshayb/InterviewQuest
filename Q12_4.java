import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class Q12_4{
	//error
	public static void print_duplicates0(int[] a){
		int size=32000/32+1;
		int[] bitmap = new int[size];
		for(int i=0;i<a.length;i++){
			int number = a[i];
			int idx = number/32;
			int offset = number%32;
			int k=1<<offset;
			if((bitmap[idx]|k)==(bitmap[idx]&k))
				System.out.print(a[i]+" ");
			bitmap[idx]=bitmap[idx]|k;
		}
	}

	public static void print_duplicates(int[] a,int n,int bitsize){
		BitMap bm=new BitMap(bitsize);
		for(int i=0;i<n;++i){
			if(bm.get(a[i]-1))   // bitmap starts at 0, number starts at 1
				System.out.println(a[i]);
			else
				bm.set(a[i]-1);
		}
	}
	public static void main(String[] args){
		int a[] = {
        	1,2,3,4,5,32000,7,8,9,10,11,1,2,13,15,16,32000,11,5,8
    	};
    	print_duplicates(a,20,32000);
	}
}
class BitMap{
	public int[] bits;
	public BitMap(int size){
		bits=new int[size];
	}
	public boolean get(int pos){
		return (bits[pos/32]&(1<<(pos&0x1f)))!=0;   // true if bit is 1, else: false
	}
	public void set(int pos){
		bits[pos/32]|=(1<<(pos&0x1f));
	}
}
