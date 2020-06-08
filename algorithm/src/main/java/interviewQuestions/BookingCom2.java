package interviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by pourush.sinha on 04/03/20.
 */
public class BookingCom2 {

    public static List<Integer> awardTopKHotels(String positiveKeywords, String negativeKeywords, List<Integer> hotelIds,
                                                List<String> reviews, int k) {
        List<String> listPositiveKeyWords = new ArrayList<>();
        List<String> listNegativeKeyWords = new ArrayList<>();
        for(String str :  positiveKeywords.split("\\s+")){
            listPositiveKeyWords.add(str.toLowerCase());
        }

        for(String str :  negativeKeywords.split("\\s+")){
            listNegativeKeyWords.add(str.toLowerCase());
        }
        List<RatingOFHotel> ratingOFHotels =new ArrayList<>();
        List<Integer> awards =new ArrayList<>();
        int index=0;
        for (Integer hotelId: hotelIds) {
            String review =reviews.get(index);
            String[] reviewarr = review.split("\\s+");
            int score =0;
            for(int i=0;i<reviewarr.length;i++){
                if(listPositiveKeyWords.contains(reviewarr[i].toLowerCase())){
                    score =score +3;
                }

                if(listNegativeKeyWords.contains(reviewarr[i].toLowerCase())){
                    score =score -1;
                }

            }
            RatingOFHotel r = new RatingOFHotel(hotelId,score);
            if(ratingOFHotels.contains(r)){
                ratingOFHotels.get(ratingOFHotels.indexOf(r)).score += score;
            } else
            ratingOFHotels.add(r);


        }
        Collections.sort(ratingOFHotels);
        k = (k> ratingOFHotels.size())?  ratingOFHotels.size() :k ;

        for(int i=0; i<k ;i++){
            awards.add(ratingOFHotels.get(i).hotelId);
        }

        return awards;



    }

    static class RatingOFHotel implements Comparable<RatingOFHotel>{
        int hotelId;
        int score;

        public RatingOFHotel(int hotelId, int score){
            this.hotelId =hotelId;
            this.score = score;
        }

        @Override
        public int compareTo(RatingOFHotel o) {

            if(this.score >o.score) {
                return -1;
            }else if(this.score <o.score){
                return 1;
            }else{
                if(this.hotelId > o.hotelId){
                    return -1;
                }else if(this.hotelId < o.hotelId){
                    return 1;
                }else{
                    return 0;
                }
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            RatingOFHotel that = (RatingOFHotel) o;

            return hotelId == that.hotelId;
        }

        @Override
        public int hashCode() {
            return hotelId;
        }
    }


    public static void main(String[] args) {

        String positiveKeyWords="breakfast beach citycenter location metro view staff price";
        String negativeKeyWords="not";
        List<Integer> hotelIds = new ArrayList<>();
        hotelIds.add(1);
        hotelIds.add(2);
        hotelIds.add(1);
        hotelIds.add(1);
        hotelIds.add(2);

        List<String> reviews= new ArrayList<>();
        reviews.add("This hotel has a nice view of the citycenter. The location is perfect.");
        reviews.add("The breakfast is ok. Regarding location, it is quite far from citycenter but price is cheap so it is worth.");

        reviews.add("Location is excellent, 5 minutes from citycenter. There is also a metro station very close to the hotel.");
        reviews.add("They said I couldn't take my dog and there were other guests with dogs! That is not fair.");
        reviews.add("Very friendly staff and good cost-benefit ratio. Its location is a bit far from citycenter.");

        List<Integer>  intaea  = awardTopKHotels(positiveKeyWords,negativeKeyWords, hotelIds,
                reviews,2) ;
    }



}
