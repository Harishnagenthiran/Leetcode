class CloseComparators implements Comparator<Integer>{
    int x;
    public CloseComparators(int x){
        this.x=x;
    }
    public int compare(Integer a,Integer b){
        int diff = Math.abs(b-x)-Math.abs(a-x);
        if(diff==0)return b-a;
        else return diff;
    }
}
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq= new PriorityQueue<>(new CloseComparators(x));
        for(int n:arr){
            pq.offer(n);
            if(pq.size()>k){
                pq.poll();
            }
        }
        List<Integer> res = new ArrayList<>(pq);
        Collections.sort(res);
        return res;
    }
}