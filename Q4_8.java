import java.util.Stack;

class Q4_8{
	public static void findSum(TreeNode head,int sum){
		if(head==null) return;
		TreeNode tnode=head;
		int tmp=0;
		for(int i=1;tnode!=null;i++){
			tmp+=tnode.value;
			if(tmp==sum)
				print(head,i);
			tnode=tnode.parent;
		}
		findSum(head.lchild,sum);
		findSum(head.rchild,sum);
	}
	private static void print(TreeNode tnode,int level){
		Stack<Integer> s=new Stack<Integer>();
		for(int i=0;i<level;i++){
			s.push(tnode.value);
			tnode=tnode.parent;
		}
		while(s.size()>0){
			System.out.print(s.pop()+" ");
		}
	}
	public static void main(String[] args){
		int[] arr={5,1,3,8,6,10};
		TreeNode root=TreeNode.createBinaryTree(arr);
		findSum(root,23);
	}
}
