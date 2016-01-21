import java.util.Arrays;

class Q9_7{
	public static int k=1;
	public static void main(String[] args){
		Person[] person=new Person[]{new Person(65,100),new Person(70,150),
			new Person(56,90),new Person(75,190),new Person(60,95),new Person(60,150),new Person(68,110)};
		//sorting by height
		Arrays.sort(person);
		System.out.println(arrange(person));
	}

	public static int arrange(Person[] person){
		int[] d=new int[100];
		d[0]=person[0].weight;
		for(int i=1;i<person.length;++i){
			if(person[i].weight>=d[k-1])
				d[k++]=person[i].weight;
			else{
				int j;
				for(j=k-1;j>=0&&d[j]>person[i].weight;--j);
				d[j+1]=person[i].weight;
			}
		}
		return k;
	}

}

class Person implements Comparable<Person>{
	int height;
	int weight;

	public Person(int height,int weight){
		this.height=height;
		this.weight=weight;
	}

	public int compareTo(Person o){
		if(this.height>o.height){
			return 1;
		}else{
			return -1;
		}
	}
	public String toString(){
		return "("+this.height+","+this.weight+")";
	}
}