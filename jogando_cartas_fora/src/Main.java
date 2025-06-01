import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Queue<Integer> cartas = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        while (q !=0) {
            for(int i=1; i<q+1; i++){
                cartas.offer(i);
            }
            Queue<Integer> descartadas = new LinkedList<>();
            for(int i=0; i<q; i++){
                if(cartas.size()==1){
                    break;
                }
                descartadas.offer(cartas.peek());
                cartas.poll();
                cartas.offer(cartas.peek());
                cartas.poll();
            }
            System.out.print("Discarded cards: ");
            for(int i=0; i<q; i++){
                if(descartadas.size()==1){
                    System.out.print(descartadas.peek());
                    descartadas.poll();
                    break;
                }
                System.out.print(descartadas.peek()+", ");
                descartadas.poll();
            }
            System.out.println();
            System.out.println("Remaining card: " + cartas.peek());
            q = sc.nextInt();
            cartas.clear();
            descartadas.clear();
        }
        sc.close();
    }
}
