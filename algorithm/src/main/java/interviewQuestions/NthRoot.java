package interviewQuestions;

/**
 * Created by pourush.sinha on 08/06/19.
 */
public class NthRoot {

    static double nthRoot(int A, int N) {

        // intially guessing a random number between
        // 0 and 9
        double xPre = Math.random() % 10;

        // smaller eps, denotes more accuracy
        double eps = 0.001;

        // initializing difference between two
        // roots by INT_MAX
        double delX = 2147483647;

        // xK denotes current value of x
        double xK = 0.0;

        // loop untill we reach desired accuracy
        int count =0;
        while (delX > eps) {
            count++;
            // calculating current value from previous
            // value by newton's method
            xK = ((N - 1.0) * xPre +
                    (double) A / Math.pow(xPre, N - 1)) / (double) N;
            delX = Math.abs(xK - xPre);
            xPre = xK;
        }

        System.out.println("count = "+count);

        return xK;
    }


    public static void main (String[] args)
    {
        int N = 5;
        int A = 59049;

        double nthRootValue = nthRoot(343, 3);
        System.out.println(findNthRoot(A,N));
        System.out.println("Nth root is "
                + Math.round(nthRootValue*1000.0)/1000.0);

        /*
            double Acalc = pow(nthRootValue, N);
            cout << "Error in difference of powers "
                << abs(A - Acalc) << endl;
        */
    }

    static int findNthRoot(int A ,int N){

        int start= 1;
        int end = A/2;
        int mid = (start + end)/2;
        while(start<=end){

            Double midRootVal =Math.pow(mid,N);

            if(midRootVal==A){
                return mid;
            }else if(A < midRootVal){
                mid =mid -1;
            }else{
                mid =mid+1;
            }
        }

        return -1;
    }
}
