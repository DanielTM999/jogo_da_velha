package dominio;
import java.util.Scanner;

public class TuiUtils {

    public static Integer getInteger(String msg) throws Exception{
        Scanner input = new Scanner(System.in);
        int escolha = 0;
        try {
            System.out.println(msg);
            escolha = input.nextInt();
            return escolha;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("escolha invalida");
        }

    }
}
