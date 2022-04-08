package Lab6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;  

public class lab6 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter a valid stock ticker: ");
        String ticker = br.readLine();

        boolean notFinished = true;

        String result = urlIEXData.getIEXBatchData(ticker);

        int symbolIndex = result.indexOf(ticker);
        int companyNameIndex = result.indexOf("companyName") + 14;
        int primaryExchangeIndex = result.indexOf("primaryExchange") + 18;
        int latestPriceIndex = result.indexOf("latestPrice") + 13;
        int latestVolumeIndex = result.indexOf("latestVolume") + 14;

        String symbol = "";
        String companyName = "";
        String primaryExchange = "";
        String latestPrice = "";
        String latestVolume = "";

        boolean symbolFinished = false;
        boolean nameFinished = false;
        boolean exchangeFinished = false;
        boolean priceFinished = false;
        boolean volumeFinished = false;

        String[] ans = new String[5];
        while(notFinished){
            if(result.charAt(symbolIndex) != '"'){
                symbol += result.charAt(symbolIndex);
                symbolIndex++;
            }
            else{
                symbolFinished = true;
                ans[0] = symbol;
            }

            if(result.charAt(companyNameIndex) != '"'){
                companyName += result.charAt(companyNameIndex);
                companyNameIndex++;
            }
            else{
                nameFinished = true;
                ans[1] = companyName;
            }

            if(result.charAt(primaryExchangeIndex) != '"'){
                primaryExchange += result.charAt(primaryExchangeIndex);
                primaryExchangeIndex++;
            }
            else{
                exchangeFinished = true;
                ans[2] = primaryExchange;
            }

            if(result.charAt(latestPriceIndex) != ','){
                latestPrice += result.charAt(latestPriceIndex);
                latestPriceIndex++;
            }
            else{
                priceFinished = true;
                ans[3] = latestPrice;
            }

            if(result.charAt(latestVolumeIndex) != ','){
                latestVolume += result.charAt(latestVolumeIndex);
                latestVolumeIndex++;
            }
            else{
                volumeFinished = true;
                ans[4] = latestVolume;
            }

            if(volumeFinished && priceFinished && exchangeFinished && nameFinished && symbolFinished){
                notFinished = false;
            }
        }
        for(int i = 0; i < 5; i++){
            System.out.println(ans[i]);
        }
    }
}
