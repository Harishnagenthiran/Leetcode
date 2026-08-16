class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.isEmpty())return res;
        String map[] ={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        solve(res,map,digits,0,"");
        return res;
    }
    private void solve(List<String>res , String[] map, String digits,int idx,String curr){
        if(digits.length()==idx){
            res.add(curr);
            return;
        }
        String let = map[digits.charAt(idx)-'0'];
        for(char ch:let.toCharArray()){
            solve(res,map,digits,idx+1,curr+ch);
        }

    }
}