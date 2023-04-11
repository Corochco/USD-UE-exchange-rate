import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.*;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {
    public static void main(String[] args){
        bank_otkritie();
        raiffeisen();
        sber();
        vtb();
        alfa();
        sovkom();
    }
    public static void bank_otkritie(){
        help("https://moskva.bankiros.ru/bank/otkritie/currency");
        System.out.println();
    }
    public static void raiffeisen(){
        help("https://moskva.bankiros.ru/bank/raiffeisen/currency");
        System.out.println();
    }
    public static void sber(){
        help("https://moskva.bankiros.ru/bank/sberbank/currency");
        System.out.println();
    }
    public static void vtb(){
        help("https://moskva.bankiros.ru/bank/vtb/currency");
        System.out.println();
    }
    public static void alfa(){
        help("https://moskva.bankiros.ru/bank/alfabank/currency");
        System.out.println();
    }
    public static void sovkom(){
        help("https://moskva.bankiros.ru/bank/sovcombank/currency");
        System.out.println();
    }
    public static void help(String https){
        Document document = null;
        try {
            document = Jsoup.connect(https).get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(document.title());
        Elements da = document.getElementsByClass("xxx-fs-18 ");
        ArrayList<String> s = new ArrayList<>();
        int stop = 0;
        for (Element paragraph : da) {
            if (stop == 4) break;
            s.add(String.valueOf(paragraph));
            stop++;
        }
        System.out.print("USD покупка: ");
        boolean b = false;
        for (int i = 1; i < s.get(0).length(); i++) {
            if (s.get(0).charAt(i) == '>')b = true;
            else if (s.get(0).charAt(i) == '<'){
                b = false;
                break;
            }
            else if (b && s.get(0).charAt(i) != ' ') System.out.print(s.get(0).charAt(i));
        }
        System.out.println();
        System.out.print("USD продажа: ");
        for (int i = 1; i < s.get(1).length(); i++) {
            if (s.get(1).charAt(i) == '>')b = true;
            else if (s.get(1).charAt(i) == '<'){
                b = false;
                break;
            }
            else if (b && s.get(1).charAt(i) != ' ') System.out.print(s.get(1).charAt(i));
        }
        System.out.println();
        System.out.print("EUR покупка: ");
        for (int i = 1; i < s.get(2).length(); i++) {
            if (s.get(2).charAt(i) == '>')b = true;
            else if (s.get(2).charAt(i) == '<'){
                b = false;
                break;
            }
            else if (b && s.get(2).charAt(i) != ' ') System.out.print(s.get(2).charAt(i));
        }
        System.out.println();
        System.out.print("EUR продажа: ");
        for (int i = 1; i < s.get(3).length(); i++) {
            if (s.get(3).charAt(i) == '>')b = true;
            else if (s.get(3).charAt(i) == '<'){
                b = false;
                break;
            }
            else if (b && s.get(3).charAt(i) != ' ') System.out.print(s.get(3).charAt(i));
        }
    }
}

