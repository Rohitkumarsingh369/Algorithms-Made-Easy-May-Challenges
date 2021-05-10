class Solution {
    public boolean isPossible(int[] target) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)-> (b-a));
        long total = 0;
        for(int n:target)
        {
            total+=n;
            queue.add(n);
        }
        while(!queue.isEmpty())
        {
            int a = queue.poll();
            total-=a;
            if(a==1 || total==1)
                return true;
            if(a<total || total==0 || a%total==0) return false;
            a%=total;
            total+=a;
            queue.add(a);
        }
        return true;
    }
}