package Lab6;

import java.util.Scanner;

public class urlIEXData 
{
	public static String getIEXBatchData(String stockBatchStr)
	{
		String result = "";
		String URLIEXString1 = "https://cloud.iexapis.com/stable/stock/market/batch?symbols=";
		String URLIEXString2 = "&types=quote&token=pk_f9dc118fc47f4496a7a2e9e67b354e32";
		
		try
	    {
		    // add symbol to the end of the CNBC URL
	        java.net.URL djURL = new java.net.URL(URLIEXString1 + stockBatchStr + URLIEXString2);
	        Scanner inputURL   = new Scanner(djURL.openStream());
                
	        while (inputURL.hasNext())
	        {
	           result = inputURL.nextLine();
	        }
	        
	        inputURL.close();   
	    }
		catch (java.net.MalformedURLException ex)
		{
		  	ex.printStackTrace();
		}
		catch (java.io.IOException ex)
		{
		  	ex.printStackTrace();
		}
	
		return result;
	}
	
	
	
	public static String createDefaultDataLine(String sym)
	{
	    // CSV - return something like this back to the caller - XXXXX,Apple Inc.,145.55,+.55,14500123,+0.75%
	    return sym + "," + "SYMBOL NOT FOUND" + "," + "0.0" + "," + "0.0" + "," + "0" + "," + "0.0" + "%";
	}

	
	
	public static String getIEXRawData(String sym)
	{
		String URLIEXString1 = "https://cloud.iexapis.com/stable/stock/";
		String URLIEXString2 = "/quote?token=pk_f9dc118fc47f4496a7a2e9e67b354e32";
	    String line = null;

	    try
        {
	       // add symbol to the end of the CNBC URL
	       java.net.URL djURL = new java.net.URL(URLIEXString1 + sym + URLIEXString2);
	       Scanner inputURL = new Scanner(djURL.openStream());
                   
	       while (inputURL.hasNext())
	       {
	          line = inputURL.nextLine();
	          break;
	       }
	       
	       inputURL.close();
        }
	    
	    catch (java.net.MalformedURLException ex)
	    {
	    	ex.printStackTrace();
	    }

	    catch (java.io.IOException ex)
	    {
	    	ex.printStackTrace();
	    }
	       
	    return line;
	}
	
	
	
	public static String getIEXData(String sym)
	{
		String URLIEXString1 = "https://cloud.iexapis.com/stable/stock/";
		String URLIEXString2 = "/quote?token=pk_f9dc118fc47f4496a7a2e9e67b354e32";
		String name   = "";
		String last   = "";
		String change = "";
		String volume = "";	
		String percent = "";
	    int state=0, indx;
	    char  ch;
	    String line = null;

	    try
        {
	       // add symbol to the end of the CNBC URL
	       java.net.URL djURL = new java.net.URL(URLIEXString1 + sym + URLIEXString2);
	       Scanner inputURL = new Scanner(djURL.openStream());
                   
	       while (inputURL.hasNext())
	       {
	          line = inputURL.nextLine();
	          
	          switch (state)
	          {
	             case 0:
	                if (line.contains("quote") || line.contains("companyName")) 
	                   {
	                	  if ((indx = line.indexOf("\"companyName\"")) != -1)
	                      {
	                         indx += 15;

	                         while ((ch = line.charAt(indx)) != '"')
	                         {
	                        	if (ch == ',')
	                        	{
	                        		ch = ' ';
	                        	}
	                        	
	                            name = name + ch;
	                            indx++;
	                         }
	                      }
	                	
	                	  if ((indx = line.indexOf("\"iexRealtimePrice\"")) != -1)
		                  {
		                     indx += 19;

		                     while ((ch = line.charAt(indx)) != ',')
		                     {
		                        last = last + ch;
		                        indx++;
		                     }
		                     
		                     // correct last trade price if needed
		                     if (last.contains(".") == false)
		                     {
		                    	 last = last + ".00";
		                     }
		                     else
		                     {
		                    	 String tokens[] = last.split("\\.");
		                    	 if (tokens.length == 2)
		                         {
		                        	 if (tokens[1].length() == 1)
                                        last = last + "0";
		                         }	 
		                     }
		                  }
	                	  
	                	  if (last.contains("null") || last.equals("0") || last.equals("0.00"))  // if null or 0, then markets are closed, use latestPrice
	                	  {
	                		 last = "";
	                		 
	                	     if ((indx = line.indexOf("\"latestPrice\"")) != -1)
		                     {
		                        indx += 14;

		                        while ((ch = line.charAt(indx)) != ',')
		                        {
		                           last = last + ch;
		                           indx++;
		                        }
		                     
		                        // correct last trade price if needed
		                        if (last.contains(".") == false)
		                        {
		                    	    last = last + ".00";
		                        }
		                        else
		                        {
		                    	   String tokens[] = last.split("\\.");
		                    	   if (tokens.length == 2)
		                           {
		                        	   if (tokens[1].length() == 1)
                                          last = last + "0";
		                           }	 
		                        }
		                     }
	                	  }
	                	  
	                	  if ((indx = line.indexOf("\"change\":")) != -1)
		                  {
		                     indx += 9;

		                     while ((ch = line.charAt(indx)) != ',')
		                     {
		                        change = change + ch;
		                        indx++;
		                     }
		                  }
	                	  
	                	  if ((indx = line.indexOf("\"changePercent\"")) != -1)
		                  {
		                     indx += 16;

		                     while ((ch = line.charAt(indx)) != ',')
		                     {
		                        percent = percent + ch;
		                        indx++;
		                     }
		                  }
	                	  
	                	  if ((indx = line.indexOf("\"latestVolume\"")) != -1)
		                  {
		                     indx += 15;

		                     while ((ch = line.charAt(indx)) != ',')
		                     {
		                        volume = volume + ch;
		                        indx++;
		                     }

		                     state = 1;
		                  }
	                	  
	                	  if (volume.equals("null"))
	                	  {
	                		  if ((indx = line.indexOf("\"latestVolume\"")) != -1)
			                  {
			                     indx += 15;

			                     while ((ch = line.charAt(indx)) != ',')
			                     {
			                        volume = volume + ch;
			                        indx++;
			                     }

			                     state = 1;
			                  }    
	                	  }
	                   }
	                break;
	                
	             case 1:
	            	 
	             break;
	          }
	       }
	       
	       inputURL.close();
        }
	    
	    catch (java.net.MalformedURLException ex)
	    {
	    	ex.printStackTrace();
	    }

	    catch (java.io.IOException ex)
	    {
	    	ex.printStackTrace();
	    }
	    
	    // add a leading plus sign if the change is positive
	    if (!change.contains("-"))
	    	change = "+" + change;
	    
	    // CSV - return something like this back to the caller - AAPL,Apple Inc.,145.55,+.55,14500123,+0.75%
	    return sym + "," + name + "," + last + "," + change + "," + volume + "," + percent + "%";
	}
	
	
	public static String getIEXExportData(String sym)
	{
		String URLIEXString1 = "https://cloud.iexapis.com/stable/stock/";
		String URLIEXString2 = "/quote?token=pk_f9dc118fc47f4496a7a2e9e67b354e32";
		String name   = "";
		String last   = "";
		String change = "";
		String volume = "";	
		String percent = "";
	    int state=0, indx;
	    char  ch;
	    String line = null;

	    try
        {
	       // add symbol to the end of the CNBC URL
	       java.net.URL djURL = new java.net.URL(URLIEXString1 + sym + URLIEXString2);
	       Scanner inputURL = new Scanner(djURL.openStream());
                   
	       while (inputURL.hasNext())
	       {
	          line = inputURL.nextLine();
	          
	          switch (state)
	          {
	             case 0:
	                if (line.contains("quote") || line.contains("companyName")) 
	                {
	                	  if ((indx = line.indexOf("\"companyName\"")) != -1)
	                      {
	                         indx += 15;

	                         while ((ch = line.charAt(indx)) != '"')
	                         {
	                        	if (ch == ',')
	                        	{
	                        		ch = ' ';
	                        	}
	                        	
	                            name = name + ch;
	                            indx++;
	                         }
	                      }
	                	
	                	  if ((indx = line.indexOf("\"iexRealtimePrice\"")) != -1)
		                  {
		                     indx += 19;

		                     while ((ch = line.charAt(indx)) != ',')
		                     {
		                        last = last + ch;
		                        indx++;
		                     }
		                     
		                     // correct last trade price if needed
		                     if (last.contains(".") == false)
		                     {
		                    	 last = last + ".00";
		                     }
		                     else
		                     {
		                    	 String tokens[] = last.split("\\.");
		                    	 if (tokens.length == 2)
		                         {
		                        	 if (tokens[1].length() == 1)
                                        last = last + "0";
		                         }	 
		                     }
		                  }
							
	                	  if (last.contains("null") || last.equals("0") || last.equals("0.00"))  // if null or 0, then markets are closed, use latestPrice
	                	  {
	                		 last = "";
	                		 
	                	     if ((indx = line.indexOf("\"latestPrice\"")) != -1)
		                     {
		                        indx += 14;

		                        while ((ch = line.charAt(indx)) != ',')
		                        {
		                           last = last + ch;
		                           indx++;
		                        }
		                     
		                        // correct last trade price if needed
		                        if (last.contains(".") == false)
		                        {
		                    	    last = last + ".00";
		                        }
		                        else
		                        {
		                    	   String tokens[] = last.split("\\.");
		                    	   if (tokens.length == 2)
		                           {
		                        	   if (tokens[1].length() == 1)
                                          last = last + "0";
		                           }	 
		                        }
		                     }
	                	  }
	                		
	                	  if ((indx = line.indexOf("\"change\":")) != -1)
		                  {
		                     indx += 9;

		                     while ((ch = line.charAt(indx)) != ',')
		                     {
		                        change = change + ch;
		                        indx++;
		                     }
		                  }
	                	  
	                	  if ((indx = line.indexOf("\"changePercent\"")) != -1)
		                  {
		                     indx += 16;

		                     while ((ch = line.charAt(indx)) != ',')
		                     {
		                        percent = percent + ch;
		                        indx++;
		                     }
		                  }
	                	  
	                	  if ((indx = line.indexOf("\"latestVolume\"")) != -1)
		                  {
		                     indx += 15;

		                     while ((ch = line.charAt(indx)) != ',')
		                     {
		                        volume = volume + ch;
		                        indx++;
		                     }

		                     state = 1;
		                  }
	                	  
	                	  if (volume.equals("null"))
	                	  {
	                		  if ((indx = line.indexOf("\"latestVolume\"")) != -1)
			                  {
			                     indx += 15;

			                     while ((ch = line.charAt(indx)) != ',')
			                     {
			                        volume = volume + ch;
			                        indx++;
			                     }

			                     state = 1;
			                  }    
	                	  }
	                   }
	                break;
	                
	             case 1:
	            	 
	             break;
	          }
	       }
	       
	       inputURL.close();
        }
	    
	    catch (java.net.MalformedURLException ex)
	    {
	    	ex.printStackTrace();
	    }

	    catch (java.io.IOException ex)
	    {
	    	ex.printStackTrace();
	    }
	    
	    // add a leading plus sign if the change is positive
	    if (!change.contains("-"))
	    	change = "+" + change;
	    
	    // CSV - return something like this back to the caller - AAPL,Apple Inc.,145.55,+.55,14500123,+0.75%
	    return sym + "," + name + "," + last + "," + change + "," + volume + "," + percent + "%";
	}
	
	public static String parseIEXDataLine(String line)
	{
	   String symbol  = "";
	   String name    = "";
	   String last    = "";
	   String change  = "";
	   String volume  = "";		
	   String percent = "";
	   int state=0, indx;
	   char  ch;
     
       switch (state)
       {
	          case 0:
	             if (line.contains("quote") || line.contains("companyName")) 
	             {
	            	 if ((indx = line.indexOf("\"symbol\"")) != -1)
	                 {
	                      indx += 10;
	                      
	                      while ((ch = line.charAt(indx)) != '"')
	                      {
	                         symbol = symbol + ch;
	                         indx++;
	                      }
	                  }
	            	 
	              	  if ((indx = line.indexOf("\"companyName\"")) != -1)
	                  {
	                      indx += 15;
	                      
	                      while ((ch = line.charAt(indx)) != '"')
	                      {
	                    	 if (ch == ',')
	                         {
	                        		ch = ' ';
	                         }
	                    	 
	                         name = name + ch;
	                         indx++;
	                      }
	                   }
	               	
	             	  if ((indx = line.indexOf("\"iexRealtimePrice\"")) != -1)
		              {
		                  indx += 19;
                          while ((ch = line.charAt(indx)) != ',')
		                  {
		                     last = last + ch;
		                     indx++;
		                  }
		                     
		                  // correct last trade price if needed, if real time price is "0" then get close price
		                  if (last.contains(".") == false)
		                  {
		                	  last = "";
		                	  
		                	  if ((indx = line.indexOf("\"close\":")) != -1)
				              {
		                		  indx += 8;
		                		  while ((ch = line.charAt(indx)) != ',')
				                  {
				                     last = last + ch;
				                     indx++;
				                  }
				              }
		                	  else
		                	  {
		                 	     last = last + "0.00";
		                	  }
		                  }
		                  else
		                  {
		                 	 String tokens[] = last.split("\\.");
		                 	 if (tokens.length == 2)
		                     {
		                     	 if (tokens[1].length() == 1)
                                     last = last + "0";
		                     }	 
		                  }
		               }
	                	  
	                   if (last.contains("null"))  // if null, then markets are closed, use latestPrice
	                   {
	                      last = "";
	                	 
	                	  if ((indx = line.indexOf("\"latestPrice\"")) != -1)
		                  {
		                     indx += 14;
		                     
		                     while ((ch = line.charAt(indx)) != ',')
		                     {
		                         last = last + ch;
		                         indx++;
		                     }
		                     
		                     // correct last trade price if needed
		                     if (last.contains(".") == false)
		                     {
		                        last = last + ".00";
		                     }
		                     else
		                     {
		                       String tokens[] = last.split("\\.");
		                       if (tokens.length == 2)
		                       {
		                       	   if (tokens[1].length() == 1)
                                         last = last + "0";
		                       }	 
		                     }
		                  }
	              	  }
	                	  
	              	  if ((indx = line.indexOf("\"change\":")) != -1)
		              {
		                 indx += 9;
	                     while ((ch = line.charAt(indx)) != ',')
	                     {
	                        change = change + ch;
	                        indx++;
	                     }
	                  }
                	  
                	  if ((indx = line.indexOf("\"changePercent\"")) != -1)
	                  {
	                     indx += 16;
	                     while ((ch = line.charAt(indx)) != ',')
	                     {
	                        percent = percent + ch;
	                        indx++;
	                     }
	                  }
                	  
                	  if ((indx = line.indexOf("\"latestVolume\"")) != -1)
	                  {
	                     indx += 15;
	                     while ((ch = line.charAt(indx)) != ',')
	                     {
	                        volume = volume + ch;
	                        indx++;
	                     }
	                     
	                     state = 1;
		              }
                	  
                	  if (volume.equals("null"))
                	  {
                		  volume = "";
                		  
                		  if ((indx = line.indexOf("\"latestVolume\"")) != -1)
		                  {
		                     indx += 15;

		                     while ((ch = line.charAt(indx)) != ',')
		                     {
		                        volume = volume + ch;
		                        indx++;
		                     }

		                     state = 1;
		                  }    
                	  }
	             }
	             break;
	                
	             case 1:
	            	 
	             break; 
        } // end switch
	    
	    // add a leading plus sign if the change is positive
	    if (!change.contains("-"))
	    	change = "+" + change;
	    
	    if (change.contains(".") == false)
	    	change = change + ".00";
		
		// CSV - return something like this back to the caller - AAPL,Apple Inc.,145.55,+.55,14500123,+0.75%
	    return symbol + "," + name + "," + last + "," + change + "," + volume + "," + percent + "%";
	}
	
	
	public static String getIEXSymbolName(String sym)
	{
		String URLIEXString1 = "https://cloud.iexapis.com/stable/stock/";
		String URLIEXString2 = "/quote?token=pk_f9dc118fc47f4496a7a2e9e67b354e32";
		String name   = "";
		String last   = "";
		String change = "";
		String volume = "";		
		String percent = "";
	    int state=0, indx;
	    char  ch;
	    String line = null;

	    try
        {
	       // add symbol to the end of the IEX URL
	       java.net.URL djURL = new java.net.URL(URLIEXString1 + sym + URLIEXString2);
	       Scanner inputURL = new Scanner(djURL.openStream());

	       line = "";
	       while (inputURL.hasNext())
	       {
	          line = inputURL.nextLine();
	          
	          switch (state)
	          {
	             case 0:
	                if (line.contains("quote")|| line.contains("companyName"))
	                   {
	                	  if ((indx = line.indexOf("\"companyName\"")) != -1)
	                      {
	                         indx += 15;

	                         while ((ch = line.charAt(indx)) != '"')
	                         {
	                        	if (ch == ',')
		                        {
		                        		ch = ' ';
		                        }
	                        	
	                            name = name + ch;
	                            indx++;
	                         }
	                      }
	                	
	                	  if ((indx = line.indexOf("\"iexRealtimePrice\"")) != -1)
		                  {
		                     indx += 19;

		                     while ((ch = line.charAt(indx)) != ',')
		                     {
		                        last = last + ch;
		                        indx++;
		                     }
		                  }
	                	  
	                	  if ((indx = line.indexOf("\"change\":")) != -1)
		                  {
		                     indx += 9;

		                     while ((ch = line.charAt(indx)) != ',')
		                     {
		                        change = change + ch;
		                        indx++;
		                     }
		                  }
	                	  
	                	  if ((indx = line.indexOf("\"changePercent\"")) != -1)
		                  {
		                     indx += 16;

		                     while ((ch = line.charAt(indx)) != ',')
		                     {
		                        percent = percent + ch;
		                        indx++;
		                     }
		                  }
	                	  
	                	  if ((indx = line.indexOf("\"latestVolume\"")) != -1)
		                  {
		                     indx += 15;

		                     while ((ch = line.charAt(indx)) != ',')
		                     {
		                        volume = volume + ch;
		                        indx++;
		                     }

		                     state = 1;
		                  }
	                   }
	                break;
	                
	             case 1:
	            	 
	             break;
	          }
	       }
	       
	       inputURL.close();
        }
	    
	    catch (java.net.MalformedURLException ex)
	    {
	    	ex.printStackTrace();
	    	name = "SYMBOL NOT FOUND";
	   	}

	    catch (java.io.IOException ex)
	    {
	    	ex.printStackTrace();
	    	name = "SYMBOL NOT FOUND";	
	    }
				
	    // return something like this back to the caller - Apple Inc.
	    return name;
	}
}
