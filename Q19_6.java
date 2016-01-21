import java.lang.StringBuilder;

class Q19_6{
	public static void main(String[] args){
		System.out.println(integerEnglish(94750));
	}

	public static String integerEnglish(int num){
		StringBuilder sb=new StringBuilder();
		int len=1;
		while(Math.pow((double)10,(double)len)<num){
			len++;
		}
		String[] numstr1={"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
		String[] numstr11={"","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
		String[] numstr10={"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
		String[] numstr100={"","Hundred","Thousand"};
		int tmp;
		if(num==0){
			sb.append("Zero");
		}else{
			if(len>3&&len%2==0){
				len++;
			}
			do{
				//number greater than 999
				if(len>3){
					tmp=(num/(int)Math.pow((double)10,(double)len-2));
					// If tmp is 2 digit number and not a multiple of 10
					if(tmp/10==1&&tmp%10!=0){
						sb.append(numstr11[tmp%10]);
					}else{
						sb.append(numstr10[tmp/10]);
						sb.append(numstr1[tmp%10]);
					}
					if(tmp>0){
						sb.append(numstr100[len/2]);
					}
					num=num%(int)(Math.pow((double)10,(double)len-2));
					len=len-2;
				}else{  // Number is less than 1000
					tmp=num/100;
					if(tmp!=0){
						sb.append(numstr1[tmp]);
						sb.append(numstr100[len/2]);
					}
					tmp=num%100;
					if(tmp/10==1&&tmp%10!=0){
						sb.append(numstr11[tmp%10]);
					}else{
						sb.append(numstr10[tmp/10]);
						sb.append(numstr1[tmp%10]);
					}
					len=0;
				}
			}while(len>0);
		}
		return sb.toString();
	}

}