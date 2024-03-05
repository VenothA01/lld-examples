import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class Pair{

    int key;
    int val;

    public Pair(int key,int val){
        this.key = key;
        this.val = val;
    }

    public String toString(){
        return String.format("%d = %d",key,val);
    }
}

public class Tester {

    public int findLeastNumOfUniqueInts(int[] arr, int k) {

        int result = 0;
        Map<Integer,Integer> map = new HashMap<>();

        for(int i:arr){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        Pair[] pairs = new Pair[map.size()];

        int index = 0;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            pairs[index] = new Pair(entry.getKey(),entry.getValue());
            ++index;
        }

        Arrays.sort(pairs,Comparator.comparingInt(pair->pair.val));

        index = 0;
        while (index<=k && index< pairs.length){

            if(index<=pairs[index].val){
                index += pairs[index].val;
                pairs[index].val = 0;
            }

            if(pairs[index].val==0){
                map.remove(pairs[index].key);
            }

            index++;


        }

        return map.size();
    }





    @Test
    public void findLeastNumOfUniqueIntsTest(){
//        Assert.assertEquals(findLeastNumOfUniqueInts(new int[]{5,5,4},1),1);
//        Assert.assertEquals(findLeastNumOfUniqueInts(new int[]{4,3,1,1,3,3,2},3),2);
        Assert.assertEquals(findLeastNumOfUniqueInts(new int[]{4,3,1,1,3,3,2},5),1);
    }
}


