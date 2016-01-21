import java.util.HashSet;
import java.util.Iterator;

class Q8_5{
	public static void printPare(int num){
		HashSet<String> parestr=findPareStr(num);
		Iterator<String> it=parestr.iterator();
		while(it.hasNext()){
			String substr=it.next();
			System.out.println(substr);
		}
	}
	public static HashSet<String> findPareStr(int num){
		HashSet<String> pare=new HashSet<String>();
		if(num==1){
			pare.add("()");
			return pare;
		} 
		HashSet<String> subpare=findPareStr(num-1);
		Iterator<String> it=subpare.iterator();
		while(it.hasNext()){
			String substr=it.next();
			for(int i=0;i<=substr.length();i++){
				String tempstr=insertStr(substr,i,"()");
				pare.add(tempstr);
			}
		}
		return pare;
	}
	//在指定位置插入一个字符
	public static String insertStr(String target,int index,String str){
		String targetStr="";
		if(index==0) targetStr=str+target;
		else if(index==target.length()) targetStr=target+str;
		else  targetStr=target.substring(0,index)+str+target.substring(index);
		return targetStr;
	}
	//方法二：比较巧妙，当退出一层递归后，代码继续向下运行，就又进入到一层递归中，此时也就可以满足另外一种情况。
	public static void printPare1(int openStock, int closeStock, String s) {
        if (openStock == 0 && closeStock == 0) {
            System.out.println(s);
        }
        if (openStock > 0) {
            printPare1(openStock-1, closeStock+1, s + "(");
        }
        if (closeStock > 0) {
            printPare1(openStock, closeStock-1, s + ")");
        }
    }
	
	public static void main(String[] args){
		printPare(3);
		System.out.println("");
		printPare1(3,0,"");
	}
}