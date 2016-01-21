class Q4_1{
	public static int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}

	public static int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.min(minDepth(root.left), minDepth(root.right));
	}

	public static boolean isBalanced(TreeNode root){
		return (maxDepth(root) - minDepth(root) <= 1);
	}

	public static void main(String[] args){
		TreeNode tree=new TreeNode();
		tree.createBinaryTree(new int[]{5,3,2,4,1,6});
		String treestr=tree.printTree(tree);
		
		System.out.println(treestr);
		System.out.println(isBalanced(tree));
	}
}

class TreeNode {
	int value;
	TreeNode left;
	TreeNode right;
	TreeNode parent;
	int hashValue;
	
	public void insert(TreeNode node ,int x,TreeNode p){
		if(node==null){
			node = new TreeNode();
			node.value = x;
			node.left = null;
			node.right = null;
			if(p.value>x)
				p.left=node;
			else
				p.right=node;
			node.parent = p;
			return;
		}
		
		
		if(x<node.value){
			insert(node.left,x,node);
		}else{
			insert(node.right,x,node);
		}
	}
	
	public TreeNode createBinaryTree(int[] values){
		TreeNode root = new TreeNode();
		root.value = values[0];
		for(int i=1;i<values.length;i++){
			insert(root,values[i],root);
		}
		return root;
	}
	public String printTree(TreeNode root){
		if(root==null){
			return "#";
		}else{
			return root.value+"("+printTree(root.left)+","+printTree(root.right)+")";
		}
	}
	
}
