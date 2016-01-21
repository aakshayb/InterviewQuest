class Q9_6{
	//右上角
	public static String searchMatrix(int[][] matrix,int m,int n,int num){
		int r=0;
		int c=n-1;
		while(r<m&&c>=0){
			if(matrix[r][c]==num) return "("+r+","+c+")";
			else if(matrix[r][c]<num) r++;
			else c--;
		}
		return "error";
	}
	//左下角   error???
	public static String searchMatrix1(int[][] matrix,int m,int n,int num){
		int r=m-1;
		int c=0;
		while(r>=0&&c<n){
			if(matrix[r][c]==num) return "("+r+","+c+")";
			else if(matrix[r][c]<num) c++;
			else r--;
		}
		return "error";
	}
	public static void main(String[] args){
		int[][] matrix={{1,5,9,13},{2,6,10,14},{3,7,11,13},{4,8,12,16}};
		System.out.println(searchMatrix(matrix,4,4,12));
		System.out.println(searchMatrix1(matrix,4,4,14));
	}
}