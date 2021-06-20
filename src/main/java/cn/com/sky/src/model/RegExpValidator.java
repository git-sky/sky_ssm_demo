package cn.com.sky.src.model;
/*
 *         用正则表达式来验证邮箱格式或网址格式是否正确!

 */

import java.util.regex.*;
public final class RegExpValidator {
    /**
     * @param 待验证的字符串
     * @return 如果是符合邮箱格式的字符串,返回<b>true</b>,否则为<b>false</b>
     */
    public static boolean isEmail( String str ) {
        String regex = "[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}" ;
        return match( regex ,str );
    }
    
  
    public static boolean isDigit(String str){
    	String regex="[0-9]*";
    	return str.matches(regex);
    }

    
    
    /** 
     * @param regex 正则表达式字符串
     * @param str   要匹配的字符串
     * @return 如果str 符合 regex的正则表达式格式,返回true, 否则返回 false;
     */
    private static boolean match( String regex ,String str ){
        Pattern pattern = Pattern.compile(regex);
        Matcher  matcher = pattern.matcher( str );
        return matcher.matches();
    }
}
