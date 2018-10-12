package com.sample;

import java.util.ArrayList;
import java.util.List;



public class StatisticsPerBucket {
	
	private List<Double> cpuValues = new ArrayList<>();
	
	private List<Double> diskValues = new ArrayList<>();
	
	private List<Double> memoryValues = new ArrayList<>();
	
	

	public void setCpuValues(List<Double> cpuValues) {
		this.cpuValues = cpuValues;
	}

	public void setDiskValues(List<Double> diskValues) {
		this.diskValues = diskValues;
	}

	public void setMemoryValues(List<Double> memoryValues) {
		this.memoryValues = memoryValues;
	}

	public void addCpuVal(String val) {
		cpuValues.add(new Double(val));
	}
	
	public void addDiskVal(String val) {
		diskValues.add(new Double(val));
	}
	
	public void addMemVal(String val) {
		memoryValues.add(new Double(val));
	}
	
	public void cpuValsSize() {
		System.out.println(cpuValues.size());
	}
	
	public void diskValsSize() {
		System.out.println(diskValues.size());
	}

	
	public void memValsSize() {
		System.out.println(memoryValues.size());
	}

	/**
	 * @return Minimum CPU usage
	 */
	public double getMinimumcpuVal() {
		double[] data = getCpuValues().stream().mapToDouble(Double :: doubleValue).toArray();
		return CalUtils.min(data);
	}

	
	/**
	 * @return Maximum CPU usage
	 */
	public double getMaximumcpuVal() {
		double[] data = getCpuValues().stream().mapToDouble(Double :: doubleValue).toArray();
		return  CalUtils.max(data, data.length);
	}

	/**
	 * @return Mean CPU usage
	 */
	public double getMeancpuVal() {
		double[] data = getCpuValues().stream().mapToDouble(Double :: doubleValue).toArray();
		return CalUtils.mean(data,data.length);
	}

	/**
	 * @return StandardDeviation of CPU usage
	 */
	public double getStandardcpuDevVal() {
		double[] data = getCpuValues().stream().mapToDouble(Double :: doubleValue).toArray();
		return CalUtils.standardDeviation(data, data.length);
	}

	/**
	 * @return Minimum Disk usage
	 */
	public double getMinimumDiskVal() {
		double[] data = getDiskValues().stream().mapToDouble(Double :: doubleValue).toArray();
		return CalUtils.min(data);
	}


	/**
	 * @return Maximum Disk usage
	 */
	public double getMaximumDiskVal() {
		double[] data = getDiskValues().stream().mapToDouble(Double :: doubleValue).toArray();
		return CalUtils.max(data, data.length);
	}

	/**
	 * @return Mean Disk usage
	 */
	public double getMeanDiskVal() {
		double[] data = getDiskValues().stream().mapToDouble(Double :: doubleValue).toArray();
		return CalUtils.mean(data, data.length);
	}

	
	/**
	 * @return Standard Disk usage
	 */
	public double getStandardDiskVal() {
		double[] data = getDiskValues().stream().mapToDouble(Double :: doubleValue).toArray();
		return CalUtils.standardDeviation(data, data.length);
	}

	
	/**
	 * @return Minimum Memory usage
	 */
	public double getMinimumMemoryVal() {
		double[] data = getMemoryValues().stream().mapToDouble(Double :: doubleValue).toArray();
		return CalUtils.min(data);
	}

	
	/**
	 * @return Maximum Memory usage
	 */
	public double getMaximumMemoryVal() {
		double[] data = getMemoryValues().stream().mapToDouble(Double :: doubleValue).toArray();
		return CalUtils.max(data,data.length);
	}

	
	/**
	 * @return Mean Memory usage
	 */
	public double getMeanMemoryVal() {
		double[] data = getMemoryValues().stream().mapToDouble(Double :: doubleValue).toArray();
		return CalUtils.mean(data,data.length);
	}

	/**
	 * @return Standard Memory usage
	 */
	public double getStandardMemoryVal() {
		double[] data = getMemoryValues().stream().mapToDouble(Double :: doubleValue).toArray();
		return CalUtils.standardDeviation(data,data.length);
	}

	
	/**
	 * 
	 * @return CPU Metrics in bucket
	 */
	private List<Double> getCpuValues() {
		return cpuValues;
	}
	
	/**
	 * 
	 * @return Disk metrics in bucket
	 */
	private List<Double> getDiskValues() {
		return diskValues;
	}
	
	/**
	 * 
	 * @return Memory metrics in bucket
	 */
	private List<Double> getMemoryValues() {
		return memoryValues;
	}
	
	
	public String printStats() {
		return String.format("Minimum CPU usage %s, Maximum CPU usage %s, Mean CPU usage %s, Standard CPU Usage %s,"
				+ "Minimum Disk usage %s, Maximum Disk usage %s, Mean Disk usage %s, Standard Disk Usage %s,Minimum Memomry usage %s, "
				+ "Maximum Memomry usage %s, Mean Memomry usage %s, Standard Memomry Usage %s ", getMinimumcpuVal(),getMaximumcpuVal(),getMeancpuVal(),getStandardcpuDevVal(),getMinimumDiskVal(),getMaximumDiskVal(),getMeanDiskVal(),getStandardDiskVal(),getMinimumMemoryVal(),getMaximumMemoryVal(),getMeanMemoryVal(),getStandardMemoryVal());
	}
}
