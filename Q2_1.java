import java.util.*;

class Q2_1{
	public static void removeDuplicates(LinkList ll){
		HashSet hs=new HashSet();
		Node pre=ll.head;
		Node temp=ll.head;
		while(temp!=null){
			if(hs.contains(temp.getData())){
				if(temp==ll.tail){
					pre.next=temp.next;
					ll.tail=pre;
					break;
				}else{
					pre.next=temp.next;
					temp=temp.next;
				}
			}else{
				hs.add(temp.getData());
				pre=temp;
				temp=temp.next;
			}
		}
		
		Iterator it =hs.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	//不使用临时缓存
	public static void removeDuplicates2(LinkList ll){
		Node current=ll.head;
		Node pre;
		Node temp;
		
		while(current!=null){
			pre=current;
			temp=current.next;
			while(temp!=null){
				if(current.getData()==temp.getData()){
					if(temp==ll.tail){
						pre.next=temp.next;
						ll.tail=pre;
						break;
					}else{
						pre.next=temp.next;
						temp=temp.next;
					}
				}else{
					pre=temp;
					temp=temp.next;
				}
			}
			current=current.next;
		}
		ll.print();
	}
	public static void main(String[] args){
		int[] data=new int[]{1,2,3,2,5,2};
		/*
		//若使用java.util.*中的链表LinkedList
		LinkedList ll=new LinkedList();
		for(int i=0;i<data.length;i++){
			ll.add(data[i]);
		}
		HashSet hs=new HashSet();
		Iterator it =ll.iterator();
		while(it.hasNext()){
			hs.add(it.next());
		}
		
		Iterator it1 =hs.iterator();
		while(it1.hasNext()){
			System.out.println(it1.next());
		}
		*/
		
		LinkList ll=new LinkList();
		for(int i=0;i<data.length;i++){
			ll.add(data[i]);
		}
		removeDuplicates(ll);
		//removeDuplicates2(ll);
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
	
	public void print(){
		if(head == null){
			System.out.println("链表为空");
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

