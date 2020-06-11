package com.pourush.utility;

/**
 * Created by pourush.sinha on 12/05/19.
 */
public class RandomString {

    static String getAlphaNumericString(int n)
    {

        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);


        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            double random =  Math.random();
            int length = AlphaNumericString.length();
            int index = (int)(length * random);

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }


    public void givenUsingApache_whenGeneratingRandomStringBounded_thenCorrect() {

        int length = 10;
        boolean useLetters = true;
        boolean useNumbers = false;
        String generatedString = =.random(length, useLetters, useNumbers);

        System.out.println(generatedString);
    }

    public static void main(String[] args)
    {

        // Get the size n
        int n = 20;

        // Get and display the alphanumeric string
        System.out.println(RandomString
                .getAlphaNumericString(n));
    }
}
