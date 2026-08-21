class Triplet{
    double root;
    int x,y;
    Triplet(double root,int x,int y){
        this.root = root;
        this.x = x;
        this.y = y;
    }
    }
    class TripletComparator implements Comparator<Triplet>{
        public int compare(Triplet a, Triplet b){
            if(a.root > b.root)return 1;
            else if(a.root<b.root)return -1;
            else return 0;
        }
    }

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue <Triplet> q = new PriorityQueue<Triplet>(new TripletComparator());
        for(int i[]:points){
            int x = i[0];
            int y = i[1];
            double dist = x * x + y * y;
            q.offer(new Triplet(dist,x,y));
        }
                int[][] ans = new int[k][2];

        // Take k closest points
        for (int i = 0; i < k; i++) {

            Triplet current = q.poll();

            ans[i][0] = current.x;
            ans[i][1] = current.y;
        }
        return ans;
        
    }
}