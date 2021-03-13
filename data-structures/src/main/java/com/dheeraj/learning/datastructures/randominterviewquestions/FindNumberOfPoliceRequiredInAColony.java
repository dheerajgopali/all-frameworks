package com.dheeraj.learning.datastructures.randominterviewquestions;

/**
 * [1:24 PM, 3/5/2021] C Suresh: There are N houses in a society, there are fancy bulbs on some houses and thief can steal those bulbs.
 * We will have to guard these from thief. There are police and 1 police can guard only K continuous houses.
 * Find mininum number policeman required to guard all the houses.
 * [1:24 PM, 3/5/2021] C Suresh: h: -  1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 1 17
 *
 *         K = 2
 *         arr :- 3 5 9
 *         ans :- 3
 *
 *         K = 3
 *         arr :- 3 5 9
 *         ans :- 2
 * [1:29 PM, 3/5/2021] C Suresh: 3 5 9 houses has fancy bulbs
 */
public class FindNumberOfPoliceRequiredInAColony {
    public static void main(String[] args) {
        FindNumberOfPoliceRequiredInAColony obj = new FindNumberOfPoliceRequiredInAColony();

        System.out.println(obj.findNoOfPoliceRequired(17, new int[] {3, 5, 9} , 3));
    }

    int findNoOfPoliceRequired(int noOfHouses, int[] housesWithBulbs, int policeCapacity) {
        int noOfPolice = 0;
        for(int i=1, j=0;i<=noOfHouses && j<housesWithBulbs.length;) {
            if(i == housesWithBulbs[j]) {
                noOfPolice += 1;
                i += policeCapacity;
                j++;
            } else if(i > housesWithBulbs[j]) {
                j++;
            } else {
                i++;
            }
        }
        return noOfPolice;
    }
}
