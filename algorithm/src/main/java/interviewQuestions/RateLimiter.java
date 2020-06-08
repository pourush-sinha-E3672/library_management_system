package interviewQuestions;

import com.google.common.collect.Maps;
import com.sun.org.apache.regexp.internal.RE;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created by pourush.sinha on 11/06/19.
 */
public class RateLimiter {

    public int REQUEST_LIMIT =100;
    public long TIME_LIMIT =1000l;
    public Map<String,HitCounter> maps = Maps.newHashMap();

    public class HitCounter{
        Queue<Long> queue;
        public HitCounter(){
            queue = new LinkedList<>();
        }

        Boolean hit(Long timestamp){

            while( !queue.isEmpty() && timestamp - queue.peek() >=TIME_LIMIT ) queue.poll();

            if(queue.size() < REQUEST_LIMIT){
                queue.add(timestamp);
                return true;
            }else{
                return true;
            }
        }
    }


    public Boolean isAllowed(String clientId){
        long currTime = System.currentTimeMillis();
        if(maps.containsKey(clientId)){
            HitCounter hitCounter =maps.get(clientId);
            return hitCounter.hit(currTime);
        }else{
            HitCounter hitCounter = new HitCounter();
            maps.put(clientId,hitCounter);
            return  true;
        }


    }


}
