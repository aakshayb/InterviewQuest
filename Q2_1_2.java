class Q2_1_2{
	public static void main(String[] args){
		int[] data={1,3,6,2,1,4,1};
		LinkList2<Integer> ll=new LinkList2<Integer>();
		
		for(int i=0;i<data.length;i++){
			ll.addHead(data[i]);
		}
		
		while(!ll.isEmpty()){
			Node temp=ll.head;
			System.out.println(temp.data);
			ll.head=temp.next;
		}
	}
}
class LinkList2<T>{
	public Node<T> head,tail;
	
	public LinkList2(){
		head=tail=null;
	}
	
	public boolean isEmpty(){
		return head==null;
	}
	
	public void addHead(T item){
		head=new Node<T>(item);
		if(tail==null)
			tail=head;
	}
	
	public void addTail(T item){
		if(!isEmpty()){
			tail.next=new Node<T>(item);
			tail=tail.next;
		}else{
			head=tail=new Node<T>(item);
		}
	}
}

class Node<T>{
	T data;
	Node<T> next;
	
	Node(T data,Node<T> next){
		this.data=data;
		this.next=next;
	}
	
	Node(T data){
		this(data,null);
	}
}