class Q5_2{
	public static void print_binary(String numstr){
		String intStr="",decimalStr="";
		String[] vals=numstr.split("\\.");
		int intPart=Integer.parseInt(vals[0]);
		float decimalPart=Float.parseFloat("."+vals[1]);
		while(intPart>0){
			if((intPart&1)==1){
				intStr="1"+intStr;
			}else{
				intStr="0"+intStr;
			}
			intPart>>=1;
		}
		while(decimalPart>0){
			if(decimalStr.length()>32){
				System.out.println("ERROR");
			}
			decimalPart*=2;
			if(decimalPart>=1){
				decimalStr="1"+decimalStr;
				decimalPart-=1;
			}else{
				decimalStr="0"+decimalStr;
			}
		}
		System.out.println(intStr+"."+decimalStr);
	}
	public static void main(String[] args){
		print_binary("32.125");
	}
}