import java.util.*;

class Q3_6{

	public static Stack<Integer> sort(Stack<Integer> s) {
		Stack<Integer> r = new Stack<Integer>();
		while(!s.isEmpty()) {
			int tmp = s.pop();
			while(!r.isEmpty() && r.peek() > tmp) {
				s.push(r.pop());
			}
			r.push(tmp);
		}
		return r;
	}
	public static void main(String[] args){
		int[] a={3,6,2,9,7};
		Stack<Integer> s=new Stack<Integer>();
		for(int i=0;i<a.length;i++)
			s.push(a[i]);
		s=sort(s);
		while(!s.isEmpty()){
			System.out.print(s.pop()+" ");
		}
	}
}
