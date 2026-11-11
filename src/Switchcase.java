import java.util.Scanner;

public class Switchcase {
    public static void main(String[] args){

    Scanner scanner=new Scanner(System.in);
    System.out.print("Sayı giriniz: " );
    int sayi = scanner.nextInt();



    switch (sayi) {

        case 1:
            System.out.println("Pazartesi");
            break;
        case 2:
            System.out.println("Salı");
            break;
        case 3:
            System.out.println("Çarşamba");
            break;

        case 4:
            System.out.println("Perşembe");
            break; // BURADA BREAK OLMASAYDI PERŞEMBE VE CUMA YAZACAKTI YANİ BREAK GÖRENE KADAR EKRANA YAZDIRMAYA DEVAM EDER.
        case 5:
            System.out.println("Cuma");
            break;
        case 6:
            System.out.println("Pazartesi");
            break;
        case 7:
            System.out.println("Pazartesi");
            break;

        default:
            System.out.println("Lütfen 1 ile 7 arasında bir değer giriniz");
            //EGER BU SAYILARDAN BASKA BİR SAYI TUŞLARSA ÇIKANA CEVABI DEFAULT VERİR.



    }




    }
}