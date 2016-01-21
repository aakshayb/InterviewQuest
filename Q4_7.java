import java.util.HashSet;

class Q4_7{
	//暴力法
	public static boolean method0(TreeNode tn1,TreeNode tn2){
		if(tn2==null) return true;
		else return subtree(tn1,tn2);
	}
	private static boolean subtree(TreeNode tn1,TreeNode tn2){
		if(tn1==null) return false;
		else if(tn1.value==tn2.value){
			if(match(tn1,tn2)) return true;
		}
		else return subtree(tn1.lchild,tn2)||subtree(tn1.rchild,tn2);
		return false;
	}
	private static boolean match(TreeNode tn1,TreeNode tn2){
		if(tn1==null&&tn2==null) return true;
		else if(tn1==null||tn2==null) return false;
		else if(tn1.value!=tn2.value) return false;
		else return match(tn1.lchild,tn2.lchild)&&match(tn1.rchild,tn2.rchild);
	}
	//对二叉树每个节点生成一个hash值
	public static boolean method1(TreeNode tn1,TreeNode tn2){
		hash(tn1);
		hash(tn2);
		HashSet<Integer> set=new HashSet<Integer>();
		preTraverse(tn1,set);
		if(set.contains(tn2.hashValue))
			return true;
		else
			return false;
	}
	private static void preTraverse(TreeNode tn1,HashSet<Integer> set){
		if(tn1==null) return;
		set.add(tn1.hashValue);
		preTraverse(tn1.lchild,set);
		preTraverse(tn1.rchild,set);
	}
	private static int hash(TreeNode tnode){
		if(tnode==null) return 0;
		if(tnode.lchild==null&&tnode.rchild==null)
			tnode.hashValue=tnode.value;
		else
			tnode.hashValue=3*tnode.value+5*hash(tnode.lchild)+7*hash(tnode.rchild);
		return tnode.hashValue;
	}
	
	
	public static void main(String[] args){
		int[] arr1 = {5,1,3,8,6,10};
		int[] arr2 = {8,6,10};
		TreeNode t1 = TreeNode.createBinaryTree(arr1);
		TreeNode t2 = TreeNode.createBinaryTree(arr2);
		System.out.println(method0(t1,t2));
		System.out.println(method1(t1,t2));
	}
}

class TreeNode{
	int value;
	TreeNode lchild;
	TreeNode rchild;
	TreeNode parent;
	int hashValue;
	
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