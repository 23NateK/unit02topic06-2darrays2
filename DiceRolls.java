import java.util.Arrays;

import javax.sql.rowset.spi.SyncResolver;
public class DiceRolls {

    public static double[] twoD6Probabilities(int trials){
        int[] totals= {0,0,0,0,0,0,0,0,0,0,0,0,0};
        for(int t=0;t<trials;t++){
            double d1=Math.random()*6+1;
            double d2=Math.random()*6+1;
            int total=(int) Math.round(d1+d2);
            totals[total-2]++;
        }
        double[] probabilities = new double[13];
        for (int k = 1; k < 12; k++) {
            probabilities[k] = (double) totals[k] / trials;
        }
        return probabilities;

    }


    public static void main(String[] args) {

        int trials=100000 ;
        double[] totals= twoD6Probabilities(trials);
        for(int i=1;i<totals.length;i++){
            System.out.println((i)+":"+totals[i-1]);
        }
        int[] frequencies = new int[13];
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                frequencies[i+j]++;
            }
        }
        double[] probabilities = new double[13];
        for (int k = 1; k <= 12; k++) {
            probabilities[k] = frequencies[k] / 36.0;
        }
            }
    }
