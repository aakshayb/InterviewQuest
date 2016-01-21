class Q1_6{
	public static void rotateMatrix(int[][] a,int n){
		for(int i=0;i<n;i++){
			for(int j=i+1;j<n;j++)
				swap(a[i][j],a[j][i]);
		}
		for(int i=0;i<n/2;i++){
			for(int j=0;j<n;j++)
				swap(a[i][j],a[n-1-i][j]);
		}
	}
	public static void swap(int x,int y){
		int t=x;
		x=y;
		y=t;
	}
	//·½·¨¶þ
	public static void rotate(int[][] matrix,int n){
		for(int layer=0;layer<n/2;++layer){
			int first=layer;
			int last=n-1-layer;
			for(int i=first;i<last;++i){
				int offset=i-first;
				int top=matrix[first][i];  //save top
				//left->top
				matrix[first][i]=matrix[last-offset][first];
				
				//bottom->left
				matrix[last-offset][first]=matrix[last][last-offset];
				
				//right->bottom
				matrix[last][last-offset]=matrix[i][last];
				
				//top->right
				matrix[i][last]=top;  //right<-saved top
			}
		}
	}
	public static void main(String[] args){
		int a[][]={
			{1,2,3,4},
			{5,6,7,8},
			{9,10,11,12},
			{13,14,15,16}
		};
		rotate(a,4);
		for(int i=0;i<4;i++){
			int j;
			for(j=0;j<3;j++)
				System.out.printf(a[i][j]+",");
			System.out.println(a[i][j]);
		}
	}
}