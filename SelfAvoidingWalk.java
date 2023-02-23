public class SelfAvoidingWalk {

public static int[] snakelike(int num){
    int[] result = new int[2];
    result[1]++;
    boolean[][] grid = new boolean[num][num];
    int x=num/2;
    int y=num/2;
    while(x>=0&&x<num&&y>=0&&y<num&&grid[y][x]==false){
        grid[y][x]=true;
        double r = Math.random();
        if (r < 0.25) {
            result[1]++;
            y = y - 1;
        } else if (r < .5) {
            result[1]++;
            y = y + 1;
        } else if (r < .75) {
            result[1]++;
            x = x - 1;
        } else {
            result[1]++;
            x = x + 1;
        }
    }

    if (x < 0 || x >= num ||
            y < 0 || y >= num) {
            result[0]=1;
        } else {
            result[0]=0;
        }
        return result;
}

public static void printPathLengths(){
    int d = 10;
    int trials = 10000;
    int numEscape = 0;
    int numDie = 0;
    int[] distanceE=new int[0];
    int[] distanceD=new int[0];

    for (int t = 0; t < trials; t++) {
        int[] result = snakelike(d);
        if (result[0]==1) {
            int[] copyList = new int[distanceE.length+1];
            for(int x = 0; x< distanceE.length; x++){
              copyList[x] = distanceE[x];
            }
            copyList[copyList.length-1] = result[1];
            distanceE = copyList;
            numEscape++;
        }else{
            int[] copyList = new int[distanceD.length+1];
            for(int x = 0; x< distanceD.length; x++){
              copyList[x] = distanceD[x];
            }
            copyList[copyList.length-1] = result[1];
            distanceD = copyList;
            numDie++;
        
    
        }
}
int sum=0;
double DieAv=0;
for(int e=0;e<distanceD.length;e++){
    sum+=distanceD[e];
    DieAv=(double) sum/distanceD.length;
}
int sum2=0;
double EscAv=0;
for(int q=0;q<distanceE.length;q++){
    sum2+=distanceE[q];
    EscAv=(double) sum2/distanceE.length;
}
    System.out.println("Did " + trials + " trials");
    System.out.println("Escaped " + numEscape + " times");
    System.out.println("Probability of escape is " + (double) numEscape / trials);
    System.out.println("Average Distance on escapes: "+EscAv);
    System.out.println("Died " + numDie + " times");
    System.out.println("Probability of Death is " + (double) numDie / trials);
    System.out.println("Average Distance on Deaths: "+DieAv);


}
    public static void main(String[] args) {
    printPathLengths();
}
}
//javac SelfAvoidingWalk.java;java SelfAvoidingWalk