class Q4_5{
	public static TreeNode successor(TreeNode tnode){
		if(tnode==null) return null;
		if(tnode.rchild!=null){
			TreeNode tn=tnode.rchild;
			while(tn.lchild!=null){
				tn=tn.lchild;
			}
			return tn;
		}else{
			TreeNode p=tnode.parent;
			while(p!=null&&p.rchild==tnode){
				tnode=p;
				p=p.parent;
			}
			return p;
		}
	}
	public static void main(String[] args){
		int[]  arr={2,1,9,8,7,10};
		TreeNode root = TreeNode.createBinaryTree(arr);
		TreeNode t = root.rchild.lchild;
		TreeNode n= successor(t);
		System.out.println(n.value);
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