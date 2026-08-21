class WordFreqComaparator implements Comparator<Map.Entry<String, Integer>>{
    public int compare(Map.Entry<String,Integer> a,Map.Entry<String,Integer> b){
        if(a.getValue().equals(b.getValue())){
            return b.getKey().compareTo (a.getKey());
        }
        return a.getValue()-b.getValue();
    }

}
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer>map=new HashMap<>();
        for(String s:words){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        PriorityQueue<Map.Entry<String,Integer>> pq = new PriorityQueue<>(new WordFreqComaparator());
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            pq.offer(entry);
            if(pq.size()>k){
                pq.poll();
            }
        }
        List<String>res = new ArrayList<>();
        while(!pq.isEmpty()){
            res.add(0,pq.poll().getKey());
        }
        return res;

        
    }
}