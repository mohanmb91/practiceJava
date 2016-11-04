package main;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LogSearcher {
  public Collection<String> search(Collection<String> logLines, LocalTime startDate, LocalTime endDate) {
      Collection<String> results = new ArrayList<String>();
      DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
      boolean dateInTimeRange = false;
	  for(String eachLine: logLines){
           if(eachLine.length() > 19){
        	   String dateTime = eachLine.substring(0, 20);
        	   try {
        		   Date date = sdf.parse(dateTime);
        		   dateInTimeRange = false;
        		   LocalTime currentLineTime = LocalTime.parse(dateTime, formatter);
               	 if(((currentLineTime.isAfter(startDate) && currentLineTime.isBefore(endDate)) || currentLineTime.equals(startDate))){
               		results.add(eachLine);
               		dateInTimeRange = true;
               	 }
       		} catch (ParseException e) {
       			if(dateInTimeRange){
       				results.add(eachLine);
       			}
       		}
           }else{
        	   if(dateInTimeRange){
      				results.add(eachLine);
      			}
           }
      }
        return results;
    }
 public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        //final String fileName = System.getenv("OUTPUT_PATH");
        //BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        
        LocalTime startDate = LocalTime.parse(in.nextLine(), formatter);
        LocalTime endDate = LocalTime.parse(in.nextLine(), formatter);
        
        final int numberOfLogLines = Integer.parseInt(in.nextLine());
        Collection<String> logLines = new ArrayList<String>();
        for (int i = 0; i < numberOfLogLines; i++) {
            logLines.add(in.nextLine());
        }
        in.close();
       
        Collection<String> res = new LogSearcher().search(logLines, startDate, endDate);
        for (String logLine : res) {
          System.out.println(logLine);
        }
        
       // bw.close();
    
}
}

/*

select o.customerNumber from orders o group by o.customerNumber having count(o.orderNumber) = (

select max(a.count) from (
select count(*) count,customerNumber from orders group by customerNumber)a);

select a.customerNumber from (select count(*) count,customerNumber from orders group by customerNumber)a  order by a.count DESC limit 1;

2016-02-12T03:21:56Z
2016-02-12T03:22:02Z
12
2016-02-12T03:21:54Z	program x did operation y successfully.
asdfasdfasdgasgsfgadgsagasgd
adsfasdgasg
2016-02-12T03:21:56Z	program x did operation y successfully.
xxxxxxxxxxxxxxxxxxxxxx
xxxxxxxxxxxxxxxx
2016-02-12T03:21:57Z	program x did operation y successfully.
2016-02-12T03:21:58Z	program x did operation y successfully.
2016-02-12T03:21:59Z	program x did operation y successfully.
2016-02-12T03:22:01Z	program x did operation y successfully.
2016-02-12T03:22:02Z	program x did operation y successfully.
2016-02-12T03:22:03Z	program x did operation y successfully.
 */
