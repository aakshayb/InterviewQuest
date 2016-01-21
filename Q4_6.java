import java.util.HashSet;

class Q4_6{
	public static TreeNode ancestor;
	//使用额外的空间存储
	public static TreeNode method1(TreeNode tn1,TreeNode tn2){
		if(tn1==null||tn2==null) return null;
		HashSet<TreeNode> set=new HashSet<TreeNode>();
		while(tn1.parent!=null){
			set.add(tn1);
			tn1=tn1.parent;
		}
		while(tn2.parent!=null){
			if(set.contains(tn2))
				return tn2;
			tn2=tn2.parent;
		}
		return null;
	}
	//不使用额外的空间
	public static TreeNode method2(TreeNode tn1,TreeNode tn2){
		if(tn1==null||tn2==null) return null;
		for(TreeNode p=tn1;p!=null;p=p.parent){
			TreeNode q=tn2;
			while(q.parent!=null){
				if(q==p)
					return q;
				q=q.parent;
			}
		}
		return null;
	}
	//不存在父指针的节点
	//ancestor会不断更新，直到最后一个共同的祖先
	public static void method3(TreeNode tn1,TreeNode tn2,TreeNode head){
		if(head==null||tn1==null||tn2==null) return;
		if(head!=null&&father(head,tn1)&&father(head,tn2)){
			ancestor=head;
			method3(tn1,tn2,head.lchild);
			method3(tn1,tn2,head.rchild);
		}
	}
	private static boolean father(TreeNode head,TreeNode tnode){
		if(head==null) return false;
		else if(head==tnode) return true;
		else return father(head.rchild,tnode)||father(head.lchild,tnode);
	}
	
	public static void main(String[] args){
		int[] arr={6,3,8,7,4,9};
		TreeNode root = TreeNode.createBinaryTree(arr);
		TreeNode tn1 = root.rchild.lchild;
		TreeNode tn2 = root.rchild.rchild;
		System.out.println(method1(tn1,tn2).value);
		System.out.println(method2(tn1,tn2).value);
		
		method3(tn1,tn2,root);
		System.out.println(ancestor.value);
	}
}

class TreeNode{
	int value;
	TreeNode lchild;
	TreeNode rchild;
	TreeNode parent;
	
	public static void insert(TreeNode tnode,int x,TreeNode p){
		if(tnode==null){
			tnode=new TreeNode();
			tnode.value=x;
			tnode.lchild=null;
			tnode.rchild=null;
			if(p.value>x)
				p.lchild=tnode;
			else
				p.rchild=tnode;
			tnode.parent=p;
			return;
		}
		
		if(x<tnode.value){
			insert(tnode.lchild,x,tnode);
		}else{
			insert(tnode.rchild,x,tnode);
		}
	}
	
	public static TreeNode createBinaryTree(int[] values){
		TreeNode root=new TreeNode();
		root.value=values[0];
		for(int i=1;i<values.length;i++){
			insert(root,values[i],root);
		}
		return root;
	}
}