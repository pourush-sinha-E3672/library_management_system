package com.pourush;

import java.time.Clock;
import java.util.concurrent.TimeUnit;

/**
 * Created by pourush.sinha on 06/05/19.
 */
public class Ratelimiter {

    private long capacity;
    private long windowTimeInSeconds;

    long lastRefillTimeStamp;

    long refillCountPerSecond;

    long availableTokens;

    public Ratelimiter(long capacity, long windowTimeInSeconds){
        this.capacity = capacity;
        this.windowTimeInSeconds = windowTimeInSeconds;
        lastRefillTimeStamp = System.currentTimeMillis();
        refillCountPerSecond = capacity / windowTimeInSeconds;
        availableTokens = 0;
    }
    public long getAvailableTokens(){
        return this.availableTokens;
    }
    public boolean tryConsume() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(500);
        refill();

        if(availableTokens > 0)
        {
            --availableTokens;
            return true;
        }
        else
        {
            return false;
        }
    }
    private void refill(){
        long now = System.currentTimeMillis();
        System.out.println(" now > lastRefillTimeStamp=="+(now -lastRefillTimeStamp));
        if(now > lastRefillTimeStamp)
        {
            long elapsedTime = now - lastRefillTimeStamp;
            //refill tokens for this durationlong tokensToBeAdded = (elapsedTime/1000) * refillCountPerSecond;
            long tokensToBeAdded = (elapsedTime/1000) * refillCountPerSecond;
            System.out.println("elapsedTime = "+elapsedTime+"tokensToBeAdded ="+tokensToBeAdded+" refillCountPerSecond = "+ refillCountPerSecond);
            if(tokensToBeAdded > 0) {
                availableTokens = Math.min(capacity, availableTokens + tokensToBeAdded);
                lastRefillTimeStamp = now;

            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Ratelimiter ratelimiter = new Ratelimiter(10000,2);
        System.out.println("ratelimiter>>>"+ratelimiter.getAvailableTokens());
        for(int i=0 ;i<10 ;i++)
        System.out.println("try consume="+ ratelimiter.tryConsume());


    }

}
