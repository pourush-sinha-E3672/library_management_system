package randomproblemsolving.medium;

import com.google.common.collect.Lists;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by pourush.sinha on 26/12/18.
 */
public class ShootingBogeyProblem {

    public static int protectionTime(List<Integer> startingPos, List<Integer> speed) {

        List<Integer> timeTaken = Lists.newArrayList();

        for(int i =0 ;i < startingPos.size();i++){
            timeTaken.add(i,(startingPos.get(i) + 1)/speed.get(i));
        }

        int timeToSave =0;
        Collections.sort(timeTaken);

        while (!timeTaken.isEmpty()){
            if (timeTaken.get(0) <1){
                return timeToSave;
            }
            timeToSave = timeToSave + 1;
            timeTaken.remove(0);
            for(int i=0; i< timeTaken.size() ;i++){

                timeTaken.set(i,timeTaken.get(i) - 1);
            }
        }
        return timeToSave;



    }

    public static void main(String[] args) {

        List<Integer> startingPos =  Lists.newArrayList();
        List<Integer> speed = Lists.newArrayList();
        /*startingPos.add(0,4);
        startingPos.add(1,3);
        startingPos.add(2,1);

        speed.add(0,3);
        speed.add(1,2);
        speed.add(2,1);*/

        startingPos.add(0,4);
        startingPos.add(1,3);

        speed.add(0,2);
        speed.add(1,2);

        System.out.println("protection time = "+protectionTime(startingPos,speed));

    }
}
