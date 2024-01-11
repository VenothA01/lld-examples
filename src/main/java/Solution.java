import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.util.*;

public class Solution {

    static List<List<Integer>> subSequenceList = new ArrayList<>();

    private static void subsequence(int index,List<Integer>list ,int[] arr,int sum,int target){

        if(index>=arr.length){
            if(sum==target){
                System.out.println(list);
            }
            return;
        }

        list.add(arr[index]);
        sum += arr[index];
        subsequence(index+1,list,arr,sum,target); // pick
        list.remove(list.size()-1);
        sum -= arr[index];
        subsequence(index+1,list,arr,sum,target); // do not pick

    }

    public int findPerfectRicebagSet(int[] ricebags) {
        List<Integer> resultSet = new ArrayList<>();
        int maxSize = 0;

        for (int i = 0; i < ricebags.length - 1; i++) {
            List<Integer> currentSet = new ArrayList<>();
            currentSet.add(ricebags[i]);
            int size = 1;

            for (int j = i + 1; j < ricebags.length; j++) {
                if (ricebags[j] == currentSet.get(currentSet.size() - 1) * currentSet.get(currentSet.size() - 1)) {
                    currentSet.add(ricebags[j]);
                    size++;
                }
            }

            if (size >= 2 && size > maxSize) {
                resultSet = new ArrayList<>(currentSet);
                maxSize = size;
            }
        }

        return maxSize;
    }


    @Test
    public void testSubseuence(){
        subsequence(0,new ArrayList<>(),new int[]{1,1,2},0,2);
    }

    public int maxSize(int[] ricebags) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(ricebags);
        int ans = 0;
        for(int ricebag : ricebags) {
            int prevBag = (int)Math.sqrt(ricebag);
            if(prevBag*prevBag!=ricebag || !map.containsKey(prevBag)) {
                map.put(ricebag, 1);
                continue;
            }
            int prevCnt = map.get(prevBag);
            map.put(ricebag, prevCnt+1);
            ans = Math.max(ans, prevCnt+1);
        }
        return ans;
    }

    @Test
    @Ignore
    public void findPerfectRicebagSetTest(){
        int result = findPerfectRicebagSet(new int[]{2,3,4,5,9,25,625});
        System.out.println(result);
        System.out.println(maxSize(new int[]{2,3,4,5,9,25,625}));
    }
}
