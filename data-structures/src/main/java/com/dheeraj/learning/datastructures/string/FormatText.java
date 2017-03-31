package com.dheeraj.learning.datastructures.string;

import com.dheeraj.learning.utilities.ArrayUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dgopali on 10/21/2015.
 */
public class FormatText {
    public static void main(String[] args) {
        FormatText ft = new FormatText();
        ArrayList<String> list = ft.fullJustify(ArrayUtil.buildArray("am,fasgoprn,lvqsrjylg,rzuslwan,xlaui,tnzegzuzn,kuiwdc,fofjkkkm,ssqjig,tcmejefj,uixgzm,lyuxeaxsg,iqiyip,msv,uurcazjc,earsrvrq,qlq,lxrtzkjpg,jkxymjus,mvornwza,zty,q,nsecqphjy"),14);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }

    public ArrayList<String> fullJustify(ArrayList<String> a, int b) {
        ArrayList<String> list = new ArrayList<String>();
        if(a.size()==0)
            return list;

        boolean isRowIncomplete = false;
        int startIndex =0;
        int lenSum = 0;
        int i=0;
        int len = 0;
        for(; i< a.size() ; i++){
            len = a.get(i).length();
            lenSum = lenSum + len;
            if(lenSum > b){
                String str = createStringWithSpaces(a,startIndex,i-1,b,lenSum-len-1,true);
                list.add(str);
                startIndex = i;
                lenSum = len;
                isRowIncomplete = false;
            }else{
                isRowIncomplete = true;
            }
            lenSum++;
        }
        String str = createStringWithSpaces(a,startIndex,i-1,b,lenSum-1,false);
        list.add(str);
        return list;
    }

    public String createStringWithSpaces(ArrayList<String> array, int startIndex, int endIndex, int lineLength, int currentStringLength,boolean isNotLastRow){
        List<String> list = array.subList(startIndex,endIndex+1);
        int noOfStrings = endIndex - startIndex + 1;
        if(noOfStrings == 1) {
            int temp = lineLength - currentStringLength;
            StringBuilder stringBuilder = new StringBuilder(list.get(list.size()-1));
            while (temp > 0) {
                stringBuilder.append(" ");
                temp--;
            }
            list.set(list.size()-1, stringBuilder.toString());
        }else {
            if (!isNotLastRow) {
                int temp = lineLength - currentStringLength;
                StringBuilder stringBuilder = new StringBuilder(list.get(list.size() - 1));
                while (temp > 0) {
                    stringBuilder.append(" ");
                    temp--;
                }
                list.set(list.size() - 1, stringBuilder.toString());
            } else if (lineLength - currentStringLength > 0) {
                int temp = lineLength - currentStringLength;
                int i = 0;
                while (temp > 0) {
                    String abc = list.get(i % (noOfStrings - 1)) + " ";
                    list.set(i % (noOfStrings - 1), abc);
                    i++;
                    temp--;
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<noOfStrings;i++){
            builder.append(list.get(i));
            if(i+1!=noOfStrings)
                builder.append(" ");
        }
        return builder.toString();
    }
}
