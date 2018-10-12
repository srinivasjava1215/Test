package com.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalUtils {
	
	/**
	 * 
	 * @param data
	 * @param n
	 * @return
	 */
	public static double mean(double[] data, int n) {
		
		double sum =0;
		
		for(int i=0; i<n;i++) {
			sum += data[i];
		}
		
		double mean = (double)sum/(double)n;
		
		return mean;
	}
	
	/**
	 * 
	 * @param data
	 * @param n
	 * @return
	 */
	public static double standardDeviation(double[] data, int n) {
		
		double sumofobservationdiff = 0;
		
		double standardDeviation =0;
		double mean = mean(data,n);
		
		for(int i=0;i<n;i++) {
			
			sumofobservationdiff += (data[i]-mean)*(data[i]-mean);
		}
		
		double variance = (double)sumofobservationdiff/(double)n;
		
		standardDeviation = Math.sqrt(variance);
		
		return standardDeviation;
	}
	
	/**
	 * 
	 * @param data
	 * @return
	 */
	public static double min(double[] data) {
		Arrays.sort(data);
		return data[0];
	}
	
	/**
	 * 
	 * @param data
	 * @param n
	 * @return
	 */
	public static double max(double[] data, int n) {
		Arrays.sort(data);
		return data[n-1];
	}
	
	/**
	 * 
	 * @param data
	 * @return
	 */
	public static int[] flattenNestedArrays(Object[] data) {
	      List<Integer> values = new ArrayList<Integer>();
	      for(Object e: data) {
	    	  if(e instanceof Integer) {
	    		  values.add((Integer) e);
	    	  }else if(e instanceof Object[]) {
	    		  Object[] nestedAray = (Object[])e;
	    		  for(int i=0;i<nestedAray.length;i++) {
	    			  values.add((Integer)nestedAray[i]);
	    		  }
	    	  }
	      }
	     int[] retval =  values.stream().mapToInt(Integer :: intValue).toArray();
	     return retval;
	}
}
