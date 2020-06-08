package interviewQuestions;

/**
 * Created by pourush.sinha on 11/06/19.
 */
public class PrintMessage {
    // given an input message of arbitrary length
// split it in N text messages:
// - don’t split words in the middle
// - end every text message with a part indicator: first message ends with (1/N), last with (N/N)
// - every text message (including its part indicator) must fit within 140 characters
    static public void  splitTheWord(String str){
        int strLength=str.length();
        int numberOfbuckets =0;
        final int MAX_CHAR =140;

        if(strLength < MAX_CHAR){
            System.out.println(str+"1/1");
            return;
        }

        if(strLength % MAX_CHAR ==0){
            numberOfbuckets=strLength/MAX_CHAR;
        }else{
            numberOfbuckets =strLength/MAX_CHAR +1;
        }
        int startIndex =0;
        int endIndex=MAX_CHAR;
        for(int i=0;i <numberOfbuckets ;i++){
            int j=endIndex;
            if(! (str.charAt(j-1) ==' ')){
                while(str.charAt(j-1)!=' '){
                    j--;
                }
            }
            endIndex=j;

            System.out.println(str.substring(startIndex,endIndex) + (i+1)+"/"+numberOfbuckets);

            startIndex =endIndex;
            endIndex = Math.min((endIndex+MAX_CHAR),str.length());

        }



    }
    public static void main(String args[] ) throws Exception {

        String str1 = "Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast " +
                "of the Semantics, a large language ocean. A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted " +
                "parts of sentences fly into your mouth. Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic life. One day however a small line of blind text " +
                "by the name of Lorem Ipsum decided to leave for the far World of Grammar. The Big Oxmox advised her not to do so, because there were thousands of bad Commas, wild Question Marks and devious Semikoli, " +
                "but the Little Blind Text didn’t listen. She packed her seven versalia, put her initial into the belt and made herself on the way. When she reached the first hills of " +
                "the Italic Mountains, she had a last view back on the skyline of her hometown Bookmarksgrove, the headline of Alphabet Village and the subline of her own road, the Line Lane.";

        String str ="abcdefghij";
        splitTheWord(str1);


    }
}
