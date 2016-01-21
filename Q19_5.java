class Q19_5{
	public static int hits=0;
	public static int perudohits=0;

	public static void main(String[] args){
		guessHit("RGGB","YRGB");
		System.out.println("hits="+hits+",perudohits="+perudohits);
		Result res=guessHit2("RGGB","YRGB");
		System.out.println("hits="+res.hits+",perudohits="+res.perudohits);
	}

	public static void guessHit(String trueStr,String guessStr){
		int[] mark=new int[4];          
		for(int i=0;i<guessStr.length();i++){
			mark[i]=0;
			if(guessStr.charAt(i)==trueStr.charAt(i)){
				hits++;
				mark[i]=1;
			}
			for(int j=0;j<trueStr.length();j++){
				if(guessStr.charAt(i)==trueStr.charAt(j)&&i!=j&&mark[i]!=1)
					perudohits++;
			}
		}
	}
	//method 2  (ctci)
	static class Result{
		public int hits;
		public int perudohits;
	}

	public static Result guessHit2(String guess,String solution){
		Result res=new Result();
		int solution_mask=0;
		for(int i=0;i<4;++i){
			solution_mask|=1<<(1+solution.charAt(i)-'A');
		}
		for(int i=0;i<4;++i){
			if(guess.charAt(i)==solution.charAt(i)){
				++res.hits;
			}else if((solution_mask&(1<<(1+guess.charAt(i)-'A')))>=1){
				++res.perudohits;
			}
		}
		return res;
	}
} 

