import java.util.Arrays;

public class SelfAvoidingWalk {

public static int[] snakelike(int num){
    int[] result = new int[3];
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
            result[2]=deadEndRectangleArea(grid);
            result[0]=0;
        }
        System.out.println(Arrays.toString(result));
        return result;
}
public static int deadEndRectangleArea(boolean[][] grid){
    int[] topL=new int[2];
    int[] botR=new int[2];
    int finalArea = 0;
    for(int x=0;x<grid.length;x++){
        for(int y=0;y<grid[0].length;y++){
            if(grid[x][y]==true){
                topL[0]=x;
                topL[1]=y;
                x=100;
                y=100;
            }
        }
    }
    for(int x=grid.length-1;x>=0;x--){
        for(int y=grid[0].length-1;y>=0;y--){
            if(grid[x][y]==true){
                botR[0]=x;
                botR[1]=y;
                x=-1;
                y=-1;
            }
        }
    }
int h=botR[1]-topL[1];
if(h<1){
    h++;
}
int y=botR[1]-topL[1];
if(y<1){
    y++;
}
finalArea=y*h;
  return finalArea;  
}

public static void printPathLengths(){
    int d = 5;
    int trials = 10;
    int numEscape = 0;
    int numDie = 0;
    int distanceE=0;
    int distanceD=0;
    int areaSum=0;
    for (int t = 0; t < trials; t++) {
        int[] result = snakelike(d);
        if (result[0]==1) {
            distanceE+=result[1];
            numEscape++;
        }else{
            areaSum+=result[2];
            distanceD+=result[1];
            numDie++;
        
    
        }
}
double DieAv=(double) distanceD/numDie;
double AreaAv=(double) areaSum/numDie;
double EscAv=(double) distanceE/numEscape;
    System.out.println("Did " + trials + " trials");
    System.out.println("Escaped " + numEscape + " times");
    System.out.println("Probability of escape is " + (double) numEscape / trials);
    System.out.println("Average Distance on escapes: "+EscAv);
    System.out.println("Died " + numDie + " times");
    System.out.println("Probability of Death is " + (double) numDie / trials);
    System.out.println("Average Distance on Deaths: "+DieAv);
    System.out.println("Average Area of death: "+AreaAv);


}

    public static void main(String[] args) {
    printPathLengths();
}
}
//javac SelfAvoidingWalk.java;java SelfAvoidingWalk