package randomproblemsolving.basic;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sun.tools.javac.util.ArrayUtils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Created by pourush.sinha on 23/12/18.
 */
public class PairOfSocks {

    static int sockMerchant(int n, int[] ar) {
        Map<Integer,Integer> map = Maps.newHashMap();
        int numberOfPairs =0;

        for(int socks :ar){
            if (map.containsKey(socks)){
                numberOfPairs +=1 ;
                map.remove(socks);
            }else{
                map.put(socks,1);
            }

        }

        return numberOfPairs;


    }

    public static void main(String[] args) {
        int[] arr = {10,20,20,10,10,30,50,10,20};
        //System.out.println(sockMerchant(9,arr));
        BigInteger f = new BigInteger("1");
        System.out.println(BigInteger.valueOf(54));


        int l =5;
        int r = 12;
        List<Integer> arr1 = Lists.newArrayList();
        List<Integer> arrival = Lists.newArrayList();
        arrival.add(1);
        arrival.add(3);
        arrival.add(5);

        List<Integer> duration = Lists.newArrayList();
        duration.add(2);
        duration.add(2);
        duration.add(2);
        int n=1;
        List<String> words =Lists.newArrayList();
        words.add("add");
        words.add("boook");
        words.add("break");
        System.out.print(Arrays.toString(minimalOperations(words).toArray()));

        Properties gfg = System.getProperties();
        Set<Object> keySet = gfg.keySet();
        for(Object key : keySet)
        {
            System.out.println(key+" = "+gfg.get(key));
        }

    }

    public static int maxEvents(List<Integer> arrival, List<Integer> duration) {
        // Write your code here
        List<CompanyStayTime> companyStayTimes = new ArrayList<CompanyStayTime>();
        for(int i = 0 ;i< arrival.size();i++){
            companyStayTimes.add(new CompanyStayTime(arrival.get(i),duration.get(i)));

        }
        Collections.sort(companyStayTimes, (o1, o2) -> o1.start - o2.start);

        int val =1;
        for(int i =1 ;i < companyStayTimes.size() ;i++){

            if(companyStayTimes.get(i - 1).end > companyStayTimes.get(i).start){
              System.out.print("hi");
            }else{
                val++;
            }
        }

        return val;

    }

    static  List<Integer> minimalOperations(List<String> words){
        List<Integer> arr = new ArrayList<>();
        for (String word :words) {
            int count =0;
            for(int i =1 ;i<word.length();i++){
                if(word.charAt(i -1)== word.charAt(i)){
                    count++;
                    if( i+1 <word.length()){
                        i++;
                    }

                }
            }
            arr.add(count);


        }
        return arr;
    }



}

class CompanyStayTime{
    int start;
    int end;

    public CompanyStayTime(int start ,int end){
        this.start = start;
        this.end = start + end;
    }
}