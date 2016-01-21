class Q1_7{
	public static void setZero(int[][] matrix){
		//�洢Ԫ��Ϊ0��λ�õ����к�
		int[] row=new int[matrix.length];
		int[] column=new int[matrix[0].length];
		int k=0,l=0;
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				if(matrix[i][j]==0){
					row[k++]=i;
					column[l++]=j;
				}
			}
		}
		for(int i=0;i<row.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				matrix[row[i]][j]=0;
			}
		}
		for(int i=0;i<column.length;i++){
			for(int j=0;j<matrix.length;j++){
				matrix[j][column[i]]=0;
			}
		}
	}
	
	//��һ��д��
	public static void setZeros(int[][] matrix){
		int[] row=new int[matrix.length];
		int[] column=new int[matrix[0].length];
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				if(matrix[i][j]==0){
					row[i]=1;
					column[j]=1;
				}
			}
		}
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				if(row[i]==1||column[j]==1){
					matrix[i][j]=0;
				}
			}
		}
	}
	public static void main(String[] args){
		int[][] a={
			{1,2,0,4},
			{0,3,9,5},
			{4,6,8,3}
		};
		//setZero(a);
		setZeros(a);
		for(int i=0;i<3;i++){
			int j;
			for(j=0;j<3;j++)
				System.out.printf(a[i][j]+",");
			System.out.println(a[i][j]);
		}
	}
}