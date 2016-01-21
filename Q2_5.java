import java.util.*;

class Q2_5{
	
	public static String loopStart(LinkList ll) {
		HashSet<String> hs=new HashSet<String>();
		Node<String> node=ll.head;
		while(node!=null){
			if(hs.contains(node.getData())) 
				return node.getData();
			hs.add(node.getData());
			node=node.getNext();
		}
		return "";
	}
	
	public static void main(String[] args){	
		String[] str={"A","B","C","D","E","C"};
		LinkList<String> ll=new LinkList<String>();
		for(int i=0;i<str.length;i++){
			ll.add(str[i]);
		}
		System.out.println(loopStart(ll));
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
	
		//在链表结尾插入节点
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
			System.out.println("链表为空");
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

