import java.util.Scanner;

public class main {
    public static void Main(String[] args) {
        Pilhax pilhax = new Pilhax(3, 2);
        Scanner input = new Scanner(System.in);

        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();

        System.out.println(pilhax.capacidade);

        pilhax.push(a);
        pilhax.push(b);
        pilhax.push(c);

        pilhax.isFull();
        //return true
        pilhax.pop();
        pilhax.isFull();
        //return false
        pilhax.push(c);
        pilhax.push(a);

        System.out.println(pilhax.capacidade);
        pilhax.size();
    }
}
