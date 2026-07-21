class Pair{
    String s;
    int fre;
    public Pair(String s,int fre){
        this.s=s;
        this.fre=fre;
    }
}
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer>map=new HashMap<>();
        for(int i=0;i<words.length;i++){
            if(map.containsKey(words[i])){
                map.put(words[i],map.get(words[i])+1);
            }
            else{
                map.put(words[i],1);
            }
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->{
            if(a.fre!=b.fre){
                return Integer.compare(b.fre,a.fre);
            }
            return (a.s).compareTo(b.s);
        });
        for(String str:map.keySet()){
            pq.add(new Pair(str,map.get(str)));
        }
        List<String> ans=new ArrayList<>();
        for(int i=0;i<k;i++){
            ans.add(pq.poll().s);
        }
        return ans;
    }
}