class Q4_3{
	public static void buildMinHeightBTree(TreeNode parent,int[] arr,int start,int end){
		if(start<=end){
			int mid=(start+end)>>1;
			TreeNode tn=new TreeNode();
			tn.value=arr[mid];
			tn.parent=parent;
			if(parent.value>tn.value){
				parent.lchild=tn;
			}else{
				parent.rchild=tn;
			}
			buildMinHeightBTree(tn,arr,start,mid-1);
			buildMinHeightBTree(tn,arr,mid+1,end);
		}
	}
	
	public static void main(String[] args){	
		int[] arr = new int[]{1,3,4,5,6,7,8};
		TreeNode root = new TreeNode();
		root.value = 5;
		buildMinHeightBTree(root,arr,0,2);
		buildMinHeightBTree(root,arr,4,6);
		System.out.println(TreeNode.printTree(root));
	}
}

class TreeNode{
	int value;
	TreeNode lchild;
	TreeNode rchild;
	TreeNode parent;
	
	public static String printTree(TreeNode root){
		if(root==null){
			return "#";
		}else{
			return root.value+"("+printTree(root.lchild)+","+printTree(root.rchild)+")";
		}
	}
}