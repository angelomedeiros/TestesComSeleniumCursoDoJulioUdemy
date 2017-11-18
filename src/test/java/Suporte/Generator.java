package Suporte;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Generator {
//    public static void main(String[] args) {
//            Timestamp ts = new Timestamp(System.currentTimeMillis());
//            System.out.println(ts);
//            SimpleDateFormat hora = new SimpleDateFormat("yyyyMMddhhmmss");
//            System.out.println(hora.format(ts));
//        }
    public static String dataHoraParaArquivo(){
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        return new SimpleDateFormat("yyyyMMddhhmmss").format(ts);
    }
}
