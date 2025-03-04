import java.util.Random;
public class Main
{
    public static void main(String[] args) {
        long t0 = System.currentTimeMillis();
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        int[][] matrix = new  int[n][n];
        int m=0;
        int maxV=0, minV=11;
        int currentV;
        int degreeSum=0;
        Random rand = new Random();
        for(int i=0;i<k;i++)
            for(int j=i+1;j<k;j++){
                matrix[i][j]=matrix[j][i]=1;
            }
        for(int i=0;i<n;i++)
            for(int j=i+1;j<n;j++){
                if(j>=k && i>=k)
                    matrix[i][j] = matrix[j][i] = rand.nextInt(2);
            }
        for(int i = 0; i < n; i++) {
            currentV=0;
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 1) {
                    //System.out.print("✓");
                    m+=1;
                    currentV++;
                }
                //else
                    //System.out.print("■");
            }
            if(currentV>maxV) {
                maxV=currentV;
            }
            else if(currentV<minV) {
                minV=currentV;
            }
            degreeSum+=currentV;
            //System.out.println();
        }
        m=m/2;
        System.out.println("Numarul de muchii este "+m);
        System.out.println("Δ(G)="+maxV);
        System.out.println("δ(G)="+minV);
        System.out.println(degreeSum);
        if(degreeSum==2*m) {
            System.out.println("Suma gradelor este egala cu dublul nr muchiilor.");
        }
        else {
            System.out.println("Suma gradelor NU este egala cu dublul nr muchiilor.");
        }
        long t1 = System.currentTimeMillis();
        System.out.println("Time taken: "+(t1-t0)+"ms");
    }
}
//java ipHomework1 n k