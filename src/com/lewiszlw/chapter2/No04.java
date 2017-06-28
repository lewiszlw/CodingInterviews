package com.lewiszlw.chapter2;

import org.junit.Test;

/**
 * 面试题四：替换空格
 * @author lewiszlw
 *
 */
public class No04 {
	public String replaceBlank1(String str){
		if(str==""||str==null){
			return str;
		}
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<str.length();i++){
			char str_char=str.charAt(i);
			if(str_char==' '){
				sb.append("%20");
			}else {
				sb.append(str_char);
			}
		}
		return sb.toString();
	}
	
	public String replaceBlank2(String str){
		if(str==""||str==null){
			return str;
		}
		char[] charArray=str.toCharArray();
		int len=charArray.length;
		int countBlank=0;
		for(int i=0;i<len;i++){
			if(charArray[i]==' '){
				countBlank++;
			}
		}
		if(countBlank==0){
			return charArray.toString();
		}
		int newLen=len+2*countBlank;
		char[] newCharArray=new char[newLen];
		//定义两个指针
		int i=0, j=0;
		while(i<len&&j<newLen){
			if(charArray[i]==' '){
				newCharArray[j++]='%';
				newCharArray[j++]='2';
				newCharArray[j++]='0';
				i++;
			}else {
				newCharArray[j++]=charArray[i++];
			}
		}
		return new String(newCharArray);
	}
	
	
	@Test
	public void test(){
		String string=" Hello World ";
		System.out.println(replaceBlank1(string));
		System.out.println(replaceBlank2(string));
	}
}
