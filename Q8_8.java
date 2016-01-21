class Q8_8{
	public static int columForRow[]=new int[8];
	public static int count=0;
	public static boolean check(int row){
		for(int i=0;i<row;i++){
			int diff=Math.abs(columForRow[i]-columForRow[row]);
			if(diff==0||diff==row-i) return false;
		}
		return true;
	}
	public static void placeQueen(int row){
		if(row==8){
			print();
			count++;
			return;
		}
		for(int i=0;i<8;i++){
			columForRow[row]=i;
			if(check(row)){
				placeQueen(row+1);
			}
		}
	}
	public static void print(){
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				if(j==columForRow[i]) System.out.print("1 ");
				else System.out.print("0 ");
			}
			System.out.println();
		}
		System.out.println();
	}
	public static void main(String[] args){
		placeQueen(0);
		System.out.println(count);

	}
}