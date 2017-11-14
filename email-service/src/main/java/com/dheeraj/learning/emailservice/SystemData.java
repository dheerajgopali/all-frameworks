package com.dheeraj.learning.emailservice;

/**
 * Created by gopad on 28-09-2017.
 */
public class SystemData {
    private String systemName;
    private String frequencyStringFormat;
    private long frequency;
    private String diskSpaceToCheck;
    private int minDiskSpace;//This is meant in GB.
    private long totalSpace;
    private long freeSpace;

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getFrequencyStringFormat() {
        return frequencyStringFormat;
    }

    public void setFrequencyStringFormat(String frequencyStringFormat) {
        this.frequencyStringFormat = frequencyStringFormat;
    }

    public long getFrequency() {
        return frequency;
    }

    public void setFrequency(long frequency) {
        this.frequency = frequency;
    }

    public String getDiskSpaceToCheck() {
        return diskSpaceToCheck;
    }

    public void setDiskSpaceToCheck(String diskSpaceToCheck) {
        this.diskSpaceToCheck = diskSpaceToCheck;
    }

    public int getMinDiskSpace() {
        return minDiskSpace;
    }

    public void setMinDiskSpace(int minDiskSpace) {
        this.minDiskSpace = minDiskSpace;
    }

    public long getTotalSpace() {
        return totalSpace;
    }

    public void setTotalSpace(long totalSpace) {
        this.totalSpace = totalSpace;
    }

    public long getFreeSpace() {
        return freeSpace;
    }

    public void setFreeSpace(long freeSpace) {
        this.freeSpace = freeSpace;
    }

    @Override
    public String toString() {
        return "SystemData{" +
                "systemName='" + systemName + '\'' +
                ", frequencyStringFormat='" + frequencyStringFormat + '\'' +
                ", frequency=" + frequency +
                ", diskSpaceToCheck='" + diskSpaceToCheck + '\'' +
                ", minDiskSpace=" + minDiskSpace +
                ", totalSpace=" + totalSpace +
                ", freeSpace=" + freeSpace +
                '}';
    }
}
