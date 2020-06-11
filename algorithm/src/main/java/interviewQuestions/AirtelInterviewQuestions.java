package interviewQuestions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pourush.sinha on 11/02/20.
 */
public class AirtelInterviewQuestions {

    public static int countIterations(String s){
        Map<String,Boolean> str = new HashMap<>();
        str.put("B",false);
        str.put("A",false);
        str.put("L",false);
        str.put("O",false);
        str.put("N",false);
        Integer count=null;
        char[] arr =s.toCharArray();
        Map<String ,Integer> map = new HashMap<>();

        for(int i = 0;i<arr.length ;i++){
            if(map.containsKey(String.valueOf(arr[i]))){
                map.put(String.valueOf(arr[i]),map.get(String.valueOf(arr[i]))+1);
            }else {
                map.put(String.valueOf(arr[i]),1);
            }
        }

        for (Map.Entry<String,Integer> entry : map.entrySet()){
            if(entry.getKey().equals("B")){
                str.put("B",true);
                if(count==null){
                    count = entry.getValue();
                }else{
                    count=Math.min(count,entry.getValue());
                }

            }else if (entry.getKey().equals("A")){
                str.put("A",true);
                if(count==null){
                    count = entry.getValue();
                }else{
                    count=Math.min(count,entry.getValue());
                }
            }else if (entry.getKey().equals("L")){
                if (entry.getValue()>1){
                    str.put("L",true);
                }
                if(count==null){
                    count = entry.getValue()/2;
                }else{
                    count=Math.min(count,entry.getValue()/2);
                }
            }else if (entry.getKey().equals("O")){
                if (entry.getValue()>1){
                    str.put("O",true);
                }
                if(count==null){
                    count = entry.getValue()/2;
                }else{
                    count=Math.min(count,entry.getValue()/2);
                }
            }else if (entry.getKey().equals("N")){
                str.put("N",true);
                if(count==null){
                    count = entry.getValue();
                }else{
                    count=Math.min(count,entry.getValue());
                }
            }
        }

        for (Boolean b:str.values() ) {
            if (b==false){
                return 0;
            }

        }
        if (count==null){
            return 0;
        }else {
            return count;
        }

    }

    public static void main(String[] args) {
        System.out.println("countiterations="+countIterations("BAOOLLNNOLOLGBAX"));

    }
}
