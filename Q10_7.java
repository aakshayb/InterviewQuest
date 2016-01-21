/*
1. 初始化结果res=1和队列q3,q5,q7
2. 分别往q3,q5,q7插入1*3,1*5,1*7
3. 求出三个队列的队头元素中最小的那个x，更新结果res=x
4. 如果x在：
    q3中，那么从q3中移除x，并向q3，q5，q7插入3*x,5*x,7*x
    q5中，那么从q5中移除x，并向q5，q7插入5*x,7*x
    q7中，那么从q7中移除x，并向q7插入7*x
5. 重复步骤3－5，直到找到第k个满足条件的数
注意，当x出现在q5中，我们没往q3中插入3*x，那是因为这个数在q5中已经插入过了。
*/

import java.util.LinkedList;

class Q10_7{
	public static void main(String[] args){
		for(int i=1;i<20;++i){
			System.out.println(get_num(i)+" ");
		}
	}

	public static int mini(int a, int b){
    	return a < b ? a : b;
	}
	public static int mini(int a, int b, int c){
    	return mini(mini(a, b), c);
	}
	public static int get_num(int k){
		if(k<=0) return 0;
		int val=1;
		LinkedList<Integer> q3=new LinkedList<Integer>();
		LinkedList<Integer> q5=new LinkedList<Integer>();
		LinkedList<Integer> q7=new LinkedList<Integer>();
		q3.add(3);
		q5.add(5);
		q7.add(7);
		for(--k;k>0;--k){
			val=mini(q3.peek(),mini(q5.peek(),q7.peek()));
			if(val==q7.peek()){
				q7.remove();
			}else{
				if(val==q5.peek()){
					q5.remove();
				}else{
					if(val==q3.peek()){
						q3.remove();
						q3.add(3*val);
					}
				}
				q5.add(5*val);
			}
			q7.add(7*val);
		}
		return val;
	}
}