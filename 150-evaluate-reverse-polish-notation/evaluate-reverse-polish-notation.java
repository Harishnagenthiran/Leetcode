class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<Integer>();
        int num1,num2;
        for(String i:tokens){
            switch(i){
                case("+") ->st.add(st.pop()+st.pop());
                case("-")->{
                    num1=st.pop();
                    num2=st.pop();
                    st.add(num2-num1);
                }
                case("*")->st.add(st.pop()*st.pop());
                case("/")->{
                    num1 = st.pop();
                    num2 = st.pop();
                    st.add(num2/num1);
                }
                default->st.add(Integer.parseInt(i));

            }
        }
        return st.pop();
        
    }
}