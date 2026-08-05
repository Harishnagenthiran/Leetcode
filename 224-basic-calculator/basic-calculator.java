// + or - =sign*num -> res
//dig = num*10+(ch-'0')
//( ->push res and sign
class Solution {
    public int calculate(String s) {
        Stack<Integer> st =new Stack<Integer>();
        int sign =1, res =0,num =0;
        for(char ch:s.toCharArray()){
            if(Character.isDigit(ch)){
                num=num*10+(ch-'0');
            }
            else if(ch =='+'|| ch=='-'){
                res += sign*num;
                num=0;
                sign = (ch=='+')?+1:-1;
            }
            else if(ch =='('){
                st.push(res);
                st.push(sign);
                res=0;
                sign=1;
            }
            else if(ch==')'){
                res+=sign*num;
                num=0;
                res*=st.pop();
                res+=st.pop();
            }
        }
           res += sign * num;
           return res;

        
    }
}