class Q1_3{
/*//���󷽷�
	public static String removeDuplicateChar(String str){
		if(str==null) return "";
		int len=str.length();
		if(len<2) return str;
		int k=0;
		for(int i=0;i<len;++i){
			if(str.charAt(i)!='$'){         
				str.charAt(k)=str.charAt(i);   //ע��str��һ�����󣬲��ܶ�̬�ı䣡����
				k++;
				for(int j=i+1;j<len;++j){
					if(str.charAt(i)==str.charAt(j))
						str.charAt(j)='$';
				}
			}
		}
		//str.charAt(k)='\0';
		return str;
	}*/
	
	public static void removeDuplicates(char[] str){
		if(str==null) return;
		int len=str.length;
		if(len<2) return;
		
		int t=1;
		
		for(int i=1;i<len;++i){
			int j;
			for(j=0;j<t;++j){
				if(str[i]==str[j]) 
					break;
			}
			if(j==t){
				str[t]=str[i];
				++t;
			}
		}
		str[t]='\0';
	}
	
	public static String remove(char[] str){
		int len=str.length;
		if(len<2) return new String(str);
		int k=0;
		for(int i=0;i<len-1;i++){
			for(int j=i+1;j<len;j++){
				if(str[i]==str[j]){
					//len--;
					//for(int k=j;k<len-1;k++)
					//	str[k]=str[k+1];
					str[j]='-';
				}
			}
		}
		for(int i=0;i<len;i++){
			if(str[i]!='-'){
				str[k]=str[i];
				++k;
			}
		}
		return (new String(str)).substring(0,k);
	}
	

	public static void main(String[] args){
		//����������
		//�����ظ��ַ��ģ���abcd
		//ȫ�������ظ��ַ��ģ���aaaa
		//���ַ���
		//�����ظ��ַ�����aabb
		String str="abcd";
		String str1="aaaa";
		String str2="";
		String str3="aabb";
		
		char ss1[] = {'a','b','c','d'};
		char ss2[] = {'a','a','a','a'};
		char ss3[] = {};
		char ss4[] = {'a','a','b','b'};

		System.out.println(remove(ss1));
		System.out.println(remove(ss2));
		System.out.println(remove(ss3));
		System.out.println(remove(ss4));
	}
}