package bronze.photoShootJan2020;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

//dont solve permutations of a
//Time Complexity : O(n^2)
public class PhotoShoot {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("/Users/qixia/IdeaProjects/USACO/src/main/java/bronze/photoShootJan2020/10.in"));
        //BufferedWriter bw;
        //bw = new BufferedWriter(new FileWriter("src/main/java/bronze/photoShoot2020/myPhotoShoot.out"));

        int numA = sc.nextInt();
        int[] b = new int[numA];
        int index = 0;
        while (sc.hasNext()) {
            b[index] = sc.nextInt();
            index++;
        }

        /*my strategy:
        for a, we use a set.
        for the very first digit, we itertate from 1 to numA
        for the next digit, we traverse b and calculate b[j]-nextNum
        then check if nextNum is already in the set
        */

        Set setA = new LinkedHashSet<Integer>();

        for (int i = 1; i <= numA; i++) {
            boolean isGood = true;
            int nextNum = i;
            setA.add(i);
            for (int j = 0; j < numA-1; j++) {
                nextNum = b[j] - nextNum;
                System.out.println(setA);
                if (setA.contains(nextNum) || nextNum <= 0) {
                    isGood = false;
                    setA.clear();
                    break;
                } else {
                    setA.add(nextNum);
                }
            }
            if (isGood) {
                System.out.println(setA);
                break;
            }
        }
    }
}


