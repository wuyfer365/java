//有效数字
// 有效数字（按顺序）可以分成以下几个部分：

// 一个 小数 或者 整数
// （可选）一个 'e' 或 'E' ，后面跟着一个 整数
// 小数（按顺序）可以分成以下几个部分：

// （可选）一个符号字符（'+' 或 '-'）
// 下述格式之一：
// 至少一位数字，后面跟着一个点 '.'
// 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
// 一个点 '.' ，后面跟着至少一位数字
// 整数（按顺序）可以分成以下几个部分：

// （可选）一个符号字符（'+' 或 '-'）
// 至少一位数字
// 部分有效数字列举如下：["2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"]

// 部分无效数字列举如下：["abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"]

// 给你一个字符串 s ，如果 s 是一个 有效数字 ，请返回 true 。

// 示例 1：

// 输入：s = "0"
// 输出：true
// 示例 2：

// 输入：s = "e"
// 输出：false
// 示例 3：

// 输入：s = "."
// 输出：false

// 提示：

// 1 <= s.length <= 20
// s 仅含英文字母（大写和小写），数字（0-9），加号 '+' ，减号 '-' ，或者点 '.' 。

public class Test65 {
    public boolean isNumber(String s) {
        int idx=-1;//符号位置
        for(int i=0;i<s.length();i++){//查找字符'e'的位置 如果有多个e 则返回false
            if(s.charAt(i)=='e'||s.charAt(i)=='E'){
                if(idx!=-1) return false;
                idx=i;
            }
        }
        if(idx==-1){//没有e
            return check(s,0,s.length()-1,false);
        }
        else{//有e
            if(idx==0) return false;//e前面没有数字 如e1e2e3 返回false
            if(idx==s.length()-1) return false;//e后面没有数字 如 e1e2e3 返回false
            return check(s,0,idx-1,false)&&check(s,idx+1,s.length()-1, true);
        }

    }
    public boolean check(String s,int start,int end,boolean mustInt){// mustInt表示是否必须是整数
        if(s.charAt(start)=='+'||s.charAt(start)=='-') start++;// 如果是正负号，则跳过
        boolean point=false;
        boolean digit=false;
        for(int i=start;i<=end;i++){
            if(s.charAt(i)=='.'){// 如果是点，则必须是整数，且不能出现两个点
                if(point||mustInt) return false;
                point=true;
            }else if(s.charAt(i)>='0'&&s.charAt(i)<='9'){// 如果是数字，则数字标志位置为true
                digit=true;
            }else{// 如果是其他字符，则返回false
                return false;
            }
        }
        return digit;// 如果数字标志位为true，则返回true，否则返回false
    }
    public static void main(String[] args) {
        Test65 test65=new Test65();
        System.out.println(test65.isNumber("0"));
        System.out.println(test65.isNumber("e"));
        System.out.println(test65.isNumber("."));
        System.out.println(test65.isNumber("2"));
        System.out.println(test65.isNumber("0089"));
        System.out.println(test65.isNumber("-0.1"));
        System.out.println(test65.isNumber("+3.14"));
        System.out.println(test65.isNumber("4."));
        System.out.println(test65.isNumber("-.9"));
        System.out.println(test65.isNumber("2e10"));
        System.out.println(test65.isNumber("-90E3"));
        System.out.println(test65.isNumber("3e+7"));
        System.out.println(test65.isNumber("+6e-1"));
        System.out.println(test65.isNumber("53.5e93"));
        System.out.println(test65.isNumber("-123.456e789"));
        System.out.println(test65.isNumber("abc"));
        System.out.println(test65.isNumber("1a"));
        System.out.println(test65.isNumber("1e"));
        System.out.println(test65.isNumber("e3"));
        System.out.println(test65.isNumber("99e2.5"));
        System.out.println(test65.isNumber("--6"));
        System.out.println(test65.isNumber("-+3"));
        System.out.println(test65.isNumber("95a54e53"));
    }
}
