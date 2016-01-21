import java.util.*;

class Q3_2{
	public static void main(String[] args) {
		StackWithMin1 s1 = new StackWithMin1();
		StackWithMin2 s2 = new StackWithMin2();
		int[] arr = new int[]{6,3,4,6,9,1};
		for(int i=0;i<arr.length;i++){
			s1.push(arr[i]);
			s2.push(arr[i]);
		}
		System.out.println(s1.min());
		System.out.println(s2.min());
		s1.pop();
		s2.pop();
		System.out.println(s1.min());
		System.out.println(s2.min());
	}
}

class StackWithMin1{
	LinkedList<Integer[]> values ;
	public StackWithMin1(){
		values = new LinkedList<Integer[]>();
	}
	
	public int  pop(){
		return values.pop()[0];
	}
	public void push(int val){
		//第一个元素入栈设置初始最小值
		if(values.peek()==null){
			values.push(new Integer[]{val,val});
		}
		int min = values.peek()[1];
		if(min<val){
			values.push(new Integer[]{val,min});
		}else{
			values.push(new Integer[]{val,val});
		}
	}
	public int min(){
		int min = values.pop()[1];
		return min;
	}
	
}
class StackWithMin2{
	LinkedList<Integer> values;
	LinkedList<Integer> S;//额外栈
	public StackWithMin2(){
		values = new LinkedList<Integer>();
		S = new LinkedList<Integer>();
	}
	public void push(int val ){
		Integer sPeek = S.peek();
		values.push(val);
		if(sPeek==null||val<=sPeek){
			S.push(val);
		}
	}
	public int pop(){
		Integer t = values.pop();
		if(t<=S.peek()){
			S.pop();
		}
		return t;
	}
	public int min(){
		return S.peek();
	}
}