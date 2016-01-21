class Q8_6{
	public static int[][] picture=new int[9][9];
	public static int[] borderLeftUpCorner=new int[]{1,2};
	public static int[] borderRightDownCorner=new int[]{6,6};
	
	public static void paint(int x,int y){
		if(x<0||x>picture.length||y<0||y>picture.length)
			return;
		if(x>=borderLeftUpCorner[0]&&x<=borderRightDownCorner[0]
			&&y>=borderLeftUpCorner[1]&&y<=borderRightDownCorner[1]){
			if(picture[x][y]==0){
				picture[x][y]=1;
				paint(x+1,y);
				paint(x-1,y);
				paint(x,y+1);
				paint(x,y-1);
			}
		}
	}
	
	public static void main(String[] arg){
		int x=3,y=4;
		paint(x,y);	
		for(int i=0;i<picture.length;i++){
			for(int j=0;j<picture[0].length;j++){
				System.out.print(picture[i][j]);
			}
			System.out.println();
		}
	}
}