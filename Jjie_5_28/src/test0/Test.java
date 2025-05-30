package test0;

import java.util.*;

public class Test {
    class func implements Comparator<Map.Entry<String,Integer>>{
        @Override
        public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
            if(o1.getValue().compareTo(o2.getValue())!=0){
                return o2.getValue()-o1.getValue();
            }else{
                return o1.getKey().compareTo(o2.getKey());
            }
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> m=new HashMap<>();
        int length=words.length;
        for(int i=0;i<length;i++){
            if(m.get(words[i])==null){
                m.put(words[i],1);
            }else{
                m.put(words[i],m.get(words[i])+1);
            }
        }
        //走到这里已经把每个字符串对应的出现次数统计好了
        Set<Map.Entry<String,Integer>> s=m.entrySet();

        PriorityQueue<Map.Entry<String,Integer>> heap=new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(!o1.getValue().equals(o2.getValue())){
                    return o2.getValue()-o1.getValue();
                }else{
                    return o1.getKey().compareTo(o2.getKey());
                }
            }
        });
        heap.addAll(s);
        List<String> list=new ArrayList<>();

        for(int i=0;i<k;i++){
            list.add(heap.poll().getKey());
        }
        return list;
    }
}
