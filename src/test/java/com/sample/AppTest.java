package com.sample;

import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;

import com.opencsv.CSVReader;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
  
	private static DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z");
	
	@Test
	public void testNestedArray() {
		
		Object[] nestArrayVal = new Object[] {1,2,3,4,new Object[] {5,6},7};
		System.out.println(Arrays.toString(CalUtils.flattenNestedArrays(nestArrayVal)));
	}
	
	/**
	 * replace with file absolute path
	 */

	@Test
	public void testgenerateStatistics() {
		CSVReader reader = null;
    	try {
    		FileReader reader1 = new FileReader(new File("replace with file path..."));
    		reader = new CSVReader(reader1);
    		String[] line;
    		int count =0;
    		DateTime startTime = null;
	    	DateTime endTime = null;
	    	DateTime lastCalulatedTime = null;
	    	int bucketNumber =0;
	    	Map<Integer,StatisticsPerBucket> values = new HashMap<>();
	    	StatisticsPerBucket bucket = null;
    		while((line = reader.readNext()) != null) {
    			if(count ==0) {
    			count++;
    			continue;
    			}
    		
    			DateTime recordTime = formatter.parseDateTime(line[1]);
    	    	if(recordTime.getMinuteOfHour()%5 ==0) {
    	    		if(lastCalulatedTime != null && (lastCalulatedTime.getMillis()!= recordTime.getMillis())) {
    	    			bucket= null;
    	    			bucketNumber++;
    	    			lastCalulatedTime = recordTime;
    	    			endTime = recordTime;
    	    			startTime = recordTime.minusMinutes(5);
    	    			bucket = new StatisticsPerBucket();
    	    			values.put(new Integer(bucketNumber), bucket);
    	    		}else if(lastCalulatedTime == null){
    	    			bucket = null;
    	    			bucketNumber++;
    	    			lastCalulatedTime = recordTime;
    	    			endTime = recordTime;
    	    			startTime = recordTime.minusMinutes(5);
    	    			bucket = new StatisticsPerBucket();
    	    			values.put(new Integer(bucketNumber), bucket);
    	    		}
    	    	} 
    	    	
    	    	if((recordTime.getMillis() >= startTime.getMillis()) ||(recordTime.getMillis() <= endTime.getMillis())  ) {
    	    		addValues(line,bucket);
    	    	}
    	    	
    		}
    		for(Integer e : values.keySet()) {
    			System.out.println("bucket " + e +"statis = " +values.get(e).printStats());
    		}
    	} catch(Exception ex) {
    		ex.printStackTrace();
    	}
    	
    
    	
    }
    
    
    private  void addValues(String[] line,StatisticsPerBucket bucket) {
		if(line[0].equals("cpu")) {
			bucket.addCpuVal(line[2]);
		} else if(line[0].equals("memory")) {
			bucket.addMemVal(line[2]);
		}else if(line[0].equals("disk")) {
			bucket.addDiskVal(line[2]);
		}
	}
}
