import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Scanner;

public class stockTest {
    public static void main(String args[]) throws MalformedURLException{
        String URLString = "https://cloud.iexapis.com/stable/stock/AAPL/quote?token=pk_f9dc118fc474496a7a2e9e67b354e32";

        try {
            java.net.URL url = new java.net.URL(URLString);
            Scanner input = new Scanner(url.openStream());

            while(input.hasNext()){
                String data  = input.nextLine();
                data = data.replaceAll(",", "\r \n");
                System.out.println(data);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        

    }
}
