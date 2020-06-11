package randomproblemsolving.basic;

/*
*
* Ishaan has N dollars in his bank account. He wants to withdraw all
* of it. But the bank has a policy that the amount withdrawn must be
* a divisor of the current amount (except the amount itself).
Ishaan wants his money as soon as possible, so he withdraws the maximum
 amount from his bank each day. Determine the number of days he will need
 to withdraw all of his money.
Note : If the remaining amount is 1, he can withdraw it.

Input :
First line of input contains a single integer T denoting the number of test cases.
The only line of each test case contains an integer N.

Output :
For each test case, print the required answer in a new line.

Constraints :
1 <= T <= 200
1 <= N <= 10^12

Example :
Input :
3
12
21
9
Output :
5
7
5

Explanation :
Case 1 :
N = 12
Withdraws 6
Remaining = 6
Withdraws 3
Remaining = 3
Withdraws 1
Remaining = 2
Withdraws 1
Remaining = 1
Withdraws 1
Remaining = 0

Case 2 :
N = 21
Withdraws 7
Remaining = 14
Withdraws 7
Remaining = 7
Withdraws 1
Remaining = 6
Withdraws 3
Remaining = 3
Withdraws 1
Remaining = 2
Withdraws 1
Remaining = 1
Withdraws 1
Remaining = 0

Case 3 :
N = 9
Withdraws 3
Remaining = 6
Withdraws 3
Remaining = 3
Withdraws 1
Remaining = 2
Withdraws 1
Remaining = 1
Withdraws 1
Remaining = 0

*/

/**
 * Created by pourush.sinha on 15/12/18.
 */
public class WithdrawingMoney {

    public static int getGreatestDivisor(int number){

        for(int i = number / 2 ; i >=1 ; i--){

            if ((number % i) ==0 ){
                return i;
            }
        }
        return 1;


    }

    public static int numberOfTimesMoneyWithdrawl(int amount){
        int count = 0;

        while(amount >= 0){
            System.out.println("Amount withdrawn "+getGreatestDivisor(amount));
            amount = amount - getGreatestDivisor(amount);
            System.out.println("Remaning amount "+amount);
            count++;
        }

        return count;

    }

    public static void main(String[] args) {
        System.out.println("number of times witdrawl "+numberOfTimesMoneyWithdrawl(21));
        /*int number =19;
        System.out.println("Greatest divisor of "+number+ "  is "+getGcd(number));*/
    }

    public static int getGcd(int number){
        int f =1;
        for(int i=1;i<number;i++)
        {
            if(number%i==0)
                f=i;

        }
        return f;
    }

}
