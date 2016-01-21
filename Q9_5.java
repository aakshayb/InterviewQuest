class Q9_5{
	public static int searchStr(String[] str,int low,int high,String targetStr){
		if(targetStr.equals("")) return -1;            //不考虑查找为空字符的情况
		while(low<=high){
			int mid=(low+high)>>2;
			int temp=mid;
			if(str[mid].equals("")&&temp<=high)
				temp++;
			if(temp>high) high=mid-1;
			else{
				if(str[temp].equals(targetStr)) return temp;
				else if(str[temp].compareTo(targetStr)>0) high=temp-1;
				else low=temp+1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args){
		String[] str= {
        	"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""
    	};
    	System.out.println(searchStr(str,0,12,"ball"));
    	System.out.println(searchStr(str,0,12,"ballcar"));
	}
}