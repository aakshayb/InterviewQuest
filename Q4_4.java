import java.util.*;

class Q4_4{

	public static LinkedList<LinkedList<TreeNode>> buildLevelList(TreeNode head){
		LinkedList<LinkedList<TreeNode>> result=new LinkedList<LinkedList<TreeNode>>();
		LinkedList<TreeNode> ls=new LinkedList<TreeNode>();
		ls.add(head);
		result.add(ls);
		int level=0;
		while(result.get(level).size()>0){
			LinkedList<TreeNode> l=result.get(level);
			Iterator<TreeNode> iterator=l.iterator();
			LinkedList<TreeNode> ll=new LinkedList<TreeNode>();
			while(iterator.hasNext()){
				TreeNode tnode=iterator.next();
				if(tnode.lchild!=null){
					ll.add(tnode.lchild);
				}
				if(tnode.rchild!=null){
					ll.add(tnode.rchild);
				}
			}
			result.add(ll);
			level++;
		}
		return result;
	}
	public static void main(String[] args){
		int[] arr = new int[]{6,7,1,2,5,8,9,3,4};
		TreeNode root = TreeNode.createBinaryTree(arr);
		LinkedList<LinkedList<TreeNode>>  t = buildLevelList(root);
		for(LinkedList<TreeNode> outEntry:t){
			for(TreeNode tnode:outEntry){
				System.out.print(tnode.value+" ");
			}
			System.out.println();
		}
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