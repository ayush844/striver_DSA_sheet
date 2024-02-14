import java.util.*;

public class hashingQuestion {

    public static void main(String[] args) {
        int[] myArr = {1, 4, 2, 6, 3};
        int[] result = countFrequency(5, 7, myArr);

        for (int i = 0; i < result.length; i++){
            System.out.println(result[i]);
        }

    }

//    public static int[] countFrequency(int n, int x, int[] nums){
//        int[] arr = new int[x];
//
//        for (int i = 0; i < nums.length; i++){
//            arr[nums[i]-1]+=1;
//        }
//
//        return arr;
//
//    }

    public static int[] countFrequency(int n, int x, int[] nums){

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++){
            int key = nums[i];
            int freq = 0;
            if (map.containsKey(key)) freq = map.get(key);
            freq++;
            map.put(key, freq);
        }

        int[] arr = new int[n];

        for(int i=1;i<=n;i++){
            if(map.containsKey(i)) {
                arr[i-1]=map.get(i);
            }
        }
        return arr;
    }


    public static int[] getFrequencies(int []v) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < v.length; i++){
            int key = v[i];
            int freq = 0;
            if (map.containsKey(key)) freq = map.get(key);
            freq++;
            map.put(key, freq);
        }

        int[] arr = new int[2];

        int lowestFreq = map.get(v[0]);
        int lowestKey = v[0];
        int highestFreq = map.get(v[0]);
        int highestKey = v[0];

        for (int i = 0; i < v.length; i++){
            if (map.get(v[i]) <= lowestFreq){
                if (map.get(v[i]) == lowestFreq){
                    if (v[i] < lowestKey){
                        lowestKey = v[i];
                        lowestFreq = map.get(v[i]);
                    }
                }else{
                    lowestKey = v[i];
                    lowestFreq = map.get(v[i]);
                }
            }

            if (map.get(v[i]) >= highestFreq){
                if (map.get(v[i]) == highestFreq){
                    if (v[i] < highestKey){
                        highestKey = v[i];
                        highestFreq = map.get(v[i]);
                    }
                }else{
                    highestKey = v[i];
                    highestFreq = map.get(v[i]);
                }
            }
        }

        arr[0] = highestKey;
        arr[1] = lowestKey;

        return arr;

    }



}
