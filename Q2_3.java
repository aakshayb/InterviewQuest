class Q2_3{

	public static boolean deleteNode(Node n) {
		if (n == null || n.next == null) {
			return false; // Failure
		}
		Node next = n.next;
		n.data = next.data;
		n.next = next.next;
		return true;
	}
	
	public static void main(String[] args){
		int[] data=new int[]{1,2,3,2,5};
		
		LinkList ll=new LinkList();
		for(int i=0;i<data.length;i++){
			ll.add(data[i]);
		}
		
		//ll.delete(3);
		//ll.print();
		
		deleteNode(ll.head.next.next);
		ll.print();
	}
}

class Node{
	public Object data;
	public Node next;
	
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
}	
	
class LinkList{
	public Node head;
    public Node tail;
    private int size;
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
    
	public void add(Object i){//�������β����ڵ�
		Node newnode = new Node();
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
	//ɾ���ڵ�ֵΪi�Ľڵ�
	public void delete(Object i){
		if(head == null){
			System.out.println("����Ϊ��");
			return;
		}
		Node temp = head;
		while(temp.getNext().getData() != i){
			temp= temp.getNext();
		}
		if(temp == null){
			System.out.println("û�иýڵ�");
			return;
		}
		temp.setNext(temp.getNext().getNext());
		size--;
	}
	
	public void print(){
		if(head == null){
			System.out.println("����Ϊ��");
			return;
		}
		Node temp = head;
		while(temp.getNext()!= null){
			System.out.println(temp.getData().toString());
			temp=temp.getNext();
		}
		System.out.println(temp.getData().toString());
	}
}

