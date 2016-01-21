import java.util.*;

class Node {
	Node next = null;
	int data;
	public Node(int d) { 
		data = d; 
	}
	void appendToTail(int d) {
		Node end = new Node(d);
		Node n = this;
		while (n.next != null) {
			n = n.next; 
		}
		n.next = end;
	}
}

class Q2_1{
	public static void removeDuplicates(LinkedList ll){
		HashSet<Integer> nodeSet=new HashSet<Integer>();
		Node pre=ll.header;
		Node temp=ll.header;
		while(temp!=null){
			if(nodeSet.contains(temp.data)){
				if(temp==ll.tail){
					pre.next=temp.next;
					ll.tail=pre;
					break;
				}else{
					pre.next=temp.next;
					temp=temp.next;
				}
			}else{
				nodeSet.add(temp.data);
				pre=temp;
				temp=temp.next;
			}
		}
	}
	//不使用临时缓存
	public static void removeDuplicates2(LinkedList ll){
		Node current=ll.header;
		Node pre;
		Node temp;
		
		while(current!=null){
			pre=current;
			temp=current.next;
			while(temp!=null){
				if(current.data==temp.data){
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
			ll.print();
		}
	}
	public static void main(String[] args){
		int[] data=new int[]{1,2,3,2,5,2};
		LinkedList ll=new LinkedList();
		for(int i=0;i<data.length;i++){
			ll.add(data[i]);
		}
		System.out.println("before remove the LinkedList is:");
		ll.print();
		removeDuplicates();
		//removeDuplicates2();
		System.out.println("after remove the LinkedList is:");
		ll.print();
	}
}



class Node
{
	public Node next = null;
	public int data = 0;
	
	public Node(){}
	
	public Node(int data)
	{
		this.data = data;
		this.next = null;
	}
	
	public void setData(int data)
	{
		this.data = data;
	}	
}



class LinkedList 
{
	public Node header = null;
	public Node tail = null;
	
	public LinkedList(){}
	
	public void add(int data)
	{
		if(header == null)
		{
			Node node = new Node(data);
			header = node;
			tail = node;
		}
		else
		{
			Node node = new Node(data);
			tail.next = node;
			tail = node;
		}
	}
	
	public int getData(int index)
	{
		Node temp = header;
		for(int i=0;i<index;i++)
			temp = temp.next;
		return temp.data;
	}
	
	public void deleteHead()
	{
		header = header.next;
	}
	
	public void deleteTail()
	{
		Node temp = header;
		while(temp.next!=tail)
			temp = temp.next;
		tail = temp;
		tail.next = null;
	}
	
	public void deleteData(int data)
	{
		if(header.data == data) header = header.next;
		Node pre = header;
		Node temp = pre.next;
		while(temp.next!=null)
		{
			if(temp.data!=data)
			{
				pre = temp;
				temp = temp.next;
			}
			else
			{
				pre.next = temp.next;
				temp = temp.next;
			}
		}
		if(tail.data==data)
		{
			temp.next = null;
			tail = temp;
		}
	}
	
	public void deleteIndex(int index)
	{
		Node pre = header;
		Node temp = header;
		for(int i=0;i<index;i++)
		{
			pre = temp;
			temp = temp.next;
		}

		pre.next = temp.next;
	}
	
	public void print()
	{
		Node temp = this.header;
		while(temp.next!=null)
		{
			System.out.print(temp.data+"->");
			temp = temp.next;
		}
		System.out.print(tail.data);
		System.out.println();
	}
      public void creatLoop(int[] data)
	{
		HashMap<Integer> posMap = new HashMap<Integer>();
		for(int i=0;i<data.length;i++)
		{
			int item = data[i];
			if(!posMap.containsKey(item))
			{
				this.add(item);
				posMap.put(item, i);
			}
			else
			{
				int pos = posMap.get(item);
				Node node = this.getNode(pos+1);
				this.addNode(node);
			}
		}
	}
}