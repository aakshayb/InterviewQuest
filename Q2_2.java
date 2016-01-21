import java.util.*;

class Q2_2{
	public static Object nthtoLastNode(LinkList ll,int n) {
		Node head=ll.head;
		Node node = head;
		int count=n-1; 
		while (count >= 1 && node.next != null) {
			count--;
			node = node.next;
		}
		//链表的长度小于n
		if (count != 0) return null;
		
		while (node.next != null) {
			head = head.next;
			node = node.next;
		}
		return head.data;
	}
	public static void main(String[] args){
		int[] data=new int[]{1,2,3,2,5,2};
		
		LinkList ll=new LinkList();
		for(int i=0;i<data.length;i++){
			ll.add(data[i]);
		}
		
		System.out.println(nthtoLastNode(ll,4));
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
    
	public void add(Object i){//在链表结尾插入节点
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
}

