package Interviews;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
/** Write a solution for a store to give change back in the most efficient way.
Assuming you have $10, $5, $2, and $1 coins and that the most optimal way to give change back is by always
giving THE LEAST amount of coins possible, how would you calculate which coins to give me back?
Input (can be hardcoded) will be the amount of coins available for each denomination (for eg. 5 coins of each)
and the amount of money you have to give me back
Output, how many coins of each denomination you will give me back (for eg. 1 of $10, 3 of $5...)*/

// 20 [1,10 - 3,5 - 1,1]

// 1 , 10
// 2, 5
public class LeastDenomination {
    public enum DollarCoin{
         TEN(10),
         FIVE(5),
         TWO(2),
         ONE(1);
         public final int value;
         private DollarCoin(int value) {
             this.value = value;
         }
    }

    /** this version is the one i have submitted that
         assumes that i have infinite number of coins for each denomination */
    public static HashMap<DollarCoin, Integer> getLeastDenomV1(int value){
        if ( value <=0 )
            return null;

        HashMap<DollarCoin, Integer>  result = new LinkedHashMap<DollarCoin, Integer>();
        while(value > 0 ){
            if( value >= 10 ){
                int tens = value / 10;
                result.put(DollarCoin.TEN, tens);
                value = value % 10;
            }
            else if( value >= 5 ){
                int fives = value / 5;
                result.put(DollarCoin.FIVE, fives);
                value = value % 5;
            }
            else if( value >= 2 ){
                int twos = value / 2;
                result.put(DollarCoin.TWO, twos);
                value = value % 2;
            }
            else{
                int ones = value / 1;
                result.put(DollarCoin.ONE, ones);
                value = value % 1;
            }
        }
        return result;
    }

    /** this version matches the Problem Statement that i have specific number of coins for each denomination
        and passed as arguments instead of hashmap as we have specific set of denomination 10,5,2,1
        as the Problem Statement states that the Input can be HardCoded
    */
    public static HashMap<DollarCoin, Integer> getLeastDenomV2(int value, int availableTenCoins, int availableFiveCoins, int availableTwoCoins, int availableOneCoins){
        HashMap<DollarCoin, Integer> result = new LinkedHashMap<>();
        if (value <= 0)
            return null;

        while (value > 0) {
            if( value >= 10 && availableTenCoins > 0){
                int minTens =  getMinCoins(value,10, availableTenCoins);
                result.put(DollarCoin.TEN, minTens);
                availableTenCoins -= minTens;
                value -= minTens * 10;
            }
            else if( value >= 5 && availableFiveCoins > 0 ){
                int minFives =  getMinCoins(value,5, availableFiveCoins);
                result.put(DollarCoin.FIVE, minFives);
                availableFiveCoins -= minFives;
                value -= minFives * 5;
            }
            else if( value>=2 && availableTwoCoins > 0){
                int minTwos =  getMinCoins(value,2, availableTwoCoins);
                result.put(DollarCoin.TWO, minTwos);
                availableTwoCoins -= minTwos;
                value -= minTwos * 2;
            }
            else if( availableOneCoins >0 ) {
                int minOnes =  getMinCoins(value,1, availableOneCoins);
                result.put(DollarCoin.ONE, minOnes);
                availableOneCoins -= minOnes;
                value -= minOnes * 1;
            }
            else {
                return null;
            }
        }
        return result;
    }

    public static int getMinCoins(int value, int denom , int availableDenomCoin){
        int requiredDenomCoins = value/denom;
        return availableDenomCoin >= requiredDenomCoins ? requiredDenomCoins: availableDenomCoin;
    }

    public static void printResult (HashMap<DollarCoin, Integer> result){
        if(result != null){
            for(Map.Entry<DollarCoin,Integer> entry : result.entrySet()){
                System.out.print(entry.getValue() +" of $" + entry.getKey().value+", ");
            }
        }
        else{
            System.out.println("there is no enough coins available");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int value = 27;
        HashMap<DollarCoin, Integer> resultV1 = getLeastDenomV1(value);
        System.out.println("Assume that you have Infinite Number of Coins for Each denomination");
        printResult(resultV1);

        HashMap<DollarCoin, Integer> resultV2 = getLeastDenomV2(value,1,1,1,100);
        System.out.println("Assume that you have Specific Number of Coins for Each denomination");
        printResult(resultV2);
    }
}
