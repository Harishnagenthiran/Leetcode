class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generate(res,0,0,"",n);
        return res;
    }
    private void generate (List<String>res,int open,int close,String pair,int n){
        if(pair.length()==2*n){
            res.add(pair);
            return;
        }
        if(open<n) generate(res,open+1,close,pair+"(",n);
        if(open>close) generate(res,open,close+1,pair+")",n);
    }
}