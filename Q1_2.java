class Q1_2{
	//�ַ�����ת����һ��
	private static void reserse(char[] arr){
		/*for(int start=0,end=arr.length-1;start<end;start++,end--){  //��  for(int i=0;i<arr.length/2;i++)
			swap(arr,start,end);
		}*/
		//��  
		int length=arr.length;
		for(int i=0;i<length/2;i++){
			swap(arr,i,length-1-i);
		}
	}
	public static String reserseString(String str){
		//���ַ���ת��Ϊ�ַ�����
		char[] arr=str.toCharArray();
		//���ַ����鷴ת
		reserse(arr);
		//���ַ�����ת��Ϊ�ַ���
		return new String(arr);
	}
	private static void swap(char[] arr,int x,int y){
		char temp=arr[x];
		arr[x]=arr[y];
		arr[y]=temp;
	}
	//��������ֱ�����ַ�����ת
	public static String reserseString2(String str){
		String tempStr="";
		for(int i=str.length()-1;i>=0;i--){
			tempStr+=str.charAt(i);
		}
		return tempStr;
	}
	
	public static void main(String[] args){
		String str="1234567890";
		System.out.println(reserseString(str));
		System.out.println(reserseString2(str));
	}
}