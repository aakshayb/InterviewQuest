class Q19_2{
	public static void main(String[] args){
		char[][] board = {  
                            {'x', 'x', 'o'},  
                            {' ', 'x', 'o'},  
                            {' ', ' ', 'o'}};  
              
        char result = hasWon(board);  
        if(result == ' '){  
            System.out.println("No one won!");  
        }else{  
            System.out.println(result + " has won");  
        }      
	}

	public static char hasWon(char[][] board){
		int type=0;
		int N=board.length;

		int i,j;

		//check each row
		for(i=0;i<N;i++){
			if(board[i][0]!=' '){
				for(j=1;j<N;j++){
					if(board[i][j]!=board[i][j-1]){
						break;
					}
				}
				if(j==N){
					return board[i][0];
				}
			}
		}

		//check each column
		for(j=0;j<N;j++){
			if(board[0][j]!=' '){
				for(i=1;i<N;i++){
					if(board[i][j]!=board[i-1][j]){
						break;
					}
				}
				if(i==N){
					return board[0][j];
				}
			}
		}

		//check diagonal
		if(board[0][0]!=' '){
			for(i=1;i<N;i++){
				if(board[i][i]!=board[i-1][i-1]){
					break;
				}
			}
			if(i==N){
				return board[0][0];
			}
		}

		//check diagonal
		if(board[N-1][0]!=' '){
			for(i=1;i<N;i++){
				if(board[N-i-1][i]!=board[N-i][i-1]){
					break;
				}
			}
			if(i==N){
				return board[N-i][0];
			}
		}
		return ' ';
	}
}

