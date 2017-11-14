package com.dheeraj.learning.perfframework;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class reads specified parameters for csv file and then appends them into xml file at the end.
 */
public class JMHXMLGeneration {
    public static String csvFilePath="perf-framework\\src\\main\\resources\\output_Run_1_Performance_1_initial.csv";
    public static String xmlFilePath="perf-framework\\src\\main\\resources\\output_wbbperf3w7_JMHPERFCLIP_HEAD_coreAssemblyCached_HEAD_1443gr_Run_1_Performance_1_initial2.xml";
    public static String xmlStringToAppend="";
    public static List<String> paramsList = new ArrayList<String>();

    public static void main(String[] args) {
        defineParams();
        readParamsFromCSV();
        writeParamsToXML();
    }

    /**
     * Defines the parameters that are copied from csv to xml
     *
     * #Add here if new parameters needs to be added in future.
     */
    private static void defineParams() {
        paramsList.add("PYWALLSECONDS");
        paramsList.add("PYERRORCOUNT");
        paramsList.add("PYSTDEV");
    }

    /**
     * Writes {@link #xmlStringToAppend} content to xml file.
     */
    private static void writeParamsToXML(){
        deleteLastLineInXML();
        insertParamsToXML();
    }

    /**
     * Writes {@link #xmlStringToAppend} content to xml file.
     */
    private static void insertParamsToXML() {
        BufferedWriter bw = null;
        FileWriter fw = null;

        try {
            // true = append file
            fw = new FileWriter(xmlFilePath, true);
            bw = new BufferedWriter(fw);
            bw.write(xmlStringToAppend);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null)
                    bw.close();
                if (fw != null)
                    fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * Deletes last line in the xml.
     */
    private static void deleteLastLineInXML(){
        RandomAccessFile f = null;
        byte b;
        try {
            f = new RandomAccessFile(xmlFilePath, "rw");

            long length = f.length() - 1;
            do {
                length -= 1;
                f.seek(length);
                b = f.readByte();
            } while(b != 10);
            f.setLength(length+1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (f != null) {
                try {
                    f.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Reads specified parameters from csv file and stores them in {@link #xmlStringToAppend}
     */
    private static void readParamsFromCSV() {
        BufferedReader br = null;
        FileReader fr;
        String line;
        File file = new File(csvFilePath);

        System.out.println(file.getAbsolutePath());
        try {
            fr = new FileReader(file);

            br = new BufferedReader(fr);

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] params = line.split(",");

                if(paramsList.contains(params[0].toUpperCase())) {
                    xmlStringToAppend += "<"+params[0]+">"+params[1]+"</"+params[0]+">\n";
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        xmlStringToAppend += "</performancedata>\n";
        System.out.println(xmlStringToAppend);
    }
}
