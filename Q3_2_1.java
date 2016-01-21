class Q3_2_1{
	public static void main(String[] args){
		StackWithMin swm=new StackWithMin();
		
		
		
		
		
		
		
	}
}

class StackWithMin extends Stack<NodeWithMin>{N
	void push(int value){
		int newMin=value<min()?value:min();
		super.push(new NodeWithMin(value,newMin));
	}
	
	public int min(){
		if(this.isEmpty()){
			return Integer.MAX_VALUE;
		}else{
			return peek().min;
		}
	}
}

class NodeWithMin{
	public int value;
	public int min;
	public NodeWithMin(int v,int min){
		value=v;
		this.min=min;
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

class Stack<T>{
	Node<T> top;
	T pop(){
		if(top!=null){
			T item=top.data;
			top=top.next;
			return item;
		}
		return null;
	}
	void push(T item){
		Node t=new Node(item);
		t.next=top;
		top=t;
	}
	T peek(){
		return top.data;
	}
}
