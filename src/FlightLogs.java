
import java.util.*;
import java.time.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class FlightLogs {

	static int getAvgGroundTime(ArrayList<String> flightArray) {
		HashMap<String, HashMap<String, String>> hMap = new HashMap<String, HashMap<String, String>>();
		

		
		for(int i=0; i < flightArray.size(); i++) {
			String data = flightArray.get(i); // Flight #123 arrived at 11:23 AM
			String[] parts = data.split(" ");
			
			String id = parts[1];
			String status = parts[2]; // arrived or departed
			String time = parts[4] + " " + parts[5];

			System.out.println(time);
			
			try {
			  SimpleDateFormat date24Format = new SimpleDateFormat("hh:mm aa");
			  Date date = date24Format.parse(time);
			  long ts = date.getTime();
			  
			  System.out.println(date24Format.format(date));
			  
			  HashMap<String, String> flight = hMap.get(id);
			  HashMap<String, String> hMap_buff = new HashMap<String, String>();
			  
			  if(flight == null) {
				  hMap_buff.put(status, Long.toString(ts));
				  hMap.put(id, hMap_buff);
				  
			  } else {
				  flight.put(status, Long.toString(ts));
			  }
			} catch (ParseException e) {
				System.err.println("Cannot parse this time string !");
				
			}
			
			Iterator<Map.Entry<String, HashMap<String, String>>> it = hMap.entrySet().iterator();
			while(it.hasNext()) {
				// loop through keys and calculate avergae
		        Map.Entry<String, HashMap<String, String>> pair = it.next();
		        System.out.println(pair.getKey() + " = " + pair.getValue());
		        //it.remove(); // avoids a ConcurrentModificationException				
			}
			
			
		}
		
		
		return 0;
	}
	
	
	public static void main(String args[]) {
		
	  ArrayList<String> al = new ArrayList<String>();
	  al.add("Flight #123 arrived at 11:23 AM");
	  int res = getAvgGroundTime(al);
	  
	  
	  
	}
	
	

}
