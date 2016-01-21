class Q2_4{

	public static LinkList addList(LinkList ll1,LinkList ll2){
		LinkList<Integer> ll=new LinkList<Integer>();
		Node<Integer> node1=ll1.head;
		Node<Integer> node2=ll2.head;
		int one=0;
		if(node1==null) return ll2;
		if(node2==null) return ll1;
		while(node1!=null&&node2!=null){
			int value=node1.getData()+node2.getData()+one;
			if(value>=10){
				ll.add(value%10);
				one=1;
			}else{
				ll.add(value);
				one=0;
			}
			node1=node1.getNext();
			node2=node2.getNext();
		}
		while(node1!=null) {
			ll.add(one+node1.getData());  //若有进位呢？
			node1=node1.getNext();
			one=0;
		}
		while(node2!=null){
			ll.add(one+node2.getData());
			node2=node2.getNext();
			one=0;
		}
		return ll;
	}
	public static void main(String[] args){	
		int[] data1=new int[]{};
		int[] data2=new int[]{5,9,2};
		LinkList<Integer> ll1=new LinkList<Integer>();
		LinkList<Integer> ll2=new LinkList<Integer>();
		for(int i=0;i<data1.length;i++){
			ll1.add(data1[i]);
		}
		for(int i=0;i<data2.length;i++){
			ll2.add(data2[i]);
		}
		
		addList(ll1,ll2).print();
	}
}

class Node<T>{
	public T data;
	public Node<T> next;
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public Node<T> getNext() {
		return next;
	}
	public void setNext(Node<T> next) {
		this.next = next;
	}
}	
	
class LinkList<T>{
	public Node<T> head;
    public Node<T> tail;
    private int size;
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
    
	public void add(T i){
	
		//ÔÚÁŽ±íœáÎ²²åÈëœÚµã
		Node<T> newnode = new Node<T>();
		newnode.setData(i);
		if(head == null){
			head = newnode;
			tail = newnode;
			size ++ ;
		}
		else {
			tail.setNext(newnode);
			tail = newnode;
			size ++ ;
		}
	}
	
	public void print(){
		if(head == null){
			System.out.println("ÁŽ±íÎª¿Õ");
			return;
		}
		Node<T> temp = head;
		while(temp.getNext()!= null){
			System.out.print(temp.getData().toString());
			temp=temp.getNext();
		}
		System.out.println(temp.getData().toString());
	}
}

