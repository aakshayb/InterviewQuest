import java.util.LinkedList;
import java.util.Iterator;

class Q8_3{
	//recursion
	//n is the length of the set, index act as marking, at the beginning of 0
	public static LinkedList<LinkedList<Integer>> recursionSubSet(int[] set,int n,int index){
		LinkedList<LinkedList<Integer>> subsets=new LinkedList<LinkedList<Integer>>();
		if(index==n){   //judge the end
			LinkedList<Integer> subset=new LinkedList<Integer>();
			subsets.add(subset);
		}else{
			LinkedList<LinkedList<Integer>> part=recursionSubSet(set,n,index+1);
			int v=set[index];
			for(int i=0;i<part.size();i++){
				LinkedList<Integer> subset=part.get(i);
				subsets.add(subset);
				LinkedList<Integer> newsubset = new LinkedList<Integer>();
				for(Integer entry:subset){
					newsubset.add(entry);
				}
				newsubset.add(v);
				subsets.add(newsubset);
			}
		}
		return subsets;
	}
	//binary
	//n is the length of the set
	public static LinkedList<LinkedList<Integer>> binarySubSet(int[] set,int n){
		LinkedList<LinkedList<Integer>> subsets=new LinkedList<LinkedList<Integer>>();
		int max=1<<n;   //the number of total subset
		for(int i=0;i<max;++i){
			LinkedList<Integer> subset=new LinkedList<Integer>();
			int index=0;
			int j=i;
			while(j>0){
				if((j&1)==1){  //judge the byte
					subset.add(set[index]);
				}
				j>>=1;
				++index;
			}
			subsets.add(subset);
		}
		return subsets;
	}

	public static void main(String[] args){
		int[] dataset={1,2,3,4};
		Iterator<LinkedList<Integer>> it=recursionSubSet(dataset,dataset.length,0).iterator();
		while(it.hasNext()){
			LinkedList<Integer> set=it.next();
			System.out.println(set);
		}
		System.out.println("");
		Iterator<LinkedList<Integer>> it1=binarySubSet(dataset,dataset.length).iterator();
		while(it1.hasNext()){
			LinkedList<Integer> set=it1.next();
			System.out.println(set);
		}
	}
}