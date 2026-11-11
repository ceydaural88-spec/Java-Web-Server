import java.util.Scanner;

public class Ornek1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Adınız: ");
        String isim = scanner.nextLine();

        System.out.print("Soyadınz: ");
        String soyisim = scanner.nextLine();

        System.out.print("DERS ADI: ");
        String ders = scanner.nextLine();

        System.out.print("VİZE1: ");
        double vize1 = scanner.nextDouble();

        System.out.print("VİZE2: ");
        double vize2 = scanner.nextDouble();

        System.out.print("Final: ");
        double finalNot = scanner.nextDouble();

        double sonuc = vize1 * 0.3 + vize2 * 0.3 + finalNot * 0.4;


        if (sonuc >= 60) {
            System.out.print(isim + " " + soyisim + " adlı öğrenci " + ders + " dersinden gecmistir.");

        } else {
            System.out.println("DERSTEN KALDINIZ");
        }
    }
}