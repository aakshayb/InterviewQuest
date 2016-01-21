import java.util.LinkedList;

class Q8_4{
	public static LinkedList<String> recursionPermu(String str){
		LinkedList<String> result=new LinkedList<String>();
		if(str.equals("")){
			result.add("");
			return result;
		}
		String c=str.substring(0,1);
		LinkedList<String> res=recursionPermu(str.substring(1));
		for(int i=0;i<res.size();++i){
			String t=res.get(i);
			for(int j=0;j<=t.length();++j){
				String u=t;
				u=insertStr(u,j,c);
				result.add(u);
			}
		}
		return result;
	}
	//在指定位置插入一个字符
	public static String insertStr(String target,int index,String str){
		String targetStr="";
		if(index==0) targetStr=str+target;
		else if(index==target.length()) targetStr=target+str;
		else  targetStr=target.substring(0,index)+str+target.substring(index);
		return targetStr;
	}

	public static LinkedList<String> recursionPermu1(String str){
		LinkedList<String> result=new LinkedList<String>();
		if(str.equals("")){
			result.add("");
			return result;
		}
		for(int i=0;i<str.length();++i){
			String c=str.charAt(i)+"";
			String t=str;
			LinkedList<String> res=recursionPermu1(eraseStr(t,i));
			for(int j=0;j<res.size();++j){
				result.add(c+res.get(j));
			}
		}
		return result;
	}
	//删除指定位置的字符
	public static String eraseStr(String str,int index){
		if(str.equals("")) return "";
		if(index==0) return str.substring(1);
		if(index==str.length()-1) return str.substring(0,str.length()-1);
		else return str.substring(0,index)+str.substring(index+1);
	}

	public static void main(String[] args){
		String s="abc";
		LinkedList<String> res=recursionPermu(s);
		for(int i=0;i<res.size();i++){
			System.out.println(res.get(i));
		}
		System.out.println("");

		LinkedList<String> res1=recursionPermu1(s);
		for(int i=0;i<res1.size();i++){
			System.out.println(res1.get(i));
		}
	}
}