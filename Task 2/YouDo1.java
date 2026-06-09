
//1 Number
public class ContestStats {
     int[] scores = {85, 90, 95};
     void printFirstScore() {
         System.out.println("First Scores = "+scores[0]);
     }
     public static void main(String[] args) {
         ContestStats stats = new ContestStats();
         stats.printFirstScore();
     }
}
