import java.util.Scanner;

public class Excersizes {
    public static void main(String[] args) {
        //ex1
        int[] arr = {2, 5, 7, 8, 9};
        int num = 9;
        boolean hasHigher = hasHigherNumber(arr, num);
        System.out.println(hasHigher);
        //ex2
        int[] arr1 = {1, 2};
        int[] arr2 = {3, 4, 5, 6, 3, 4};
        int[] combinedArray = getCombinedArray(arr1, arr2);
        printArr(combinedArray);
        System.out.println();
        //ex3
        int[] arrWithDuplicates = {9,4,6,7,4,4,9,9,5,6};
        int[] origArr = {2, 3, 3, 3, 8, 9, 8};
        int[] arrWithoutDuplicates = getArrayWithoutDuplications(origArr);
        printArr(arrWithoutDuplicates);
        System.out.println();

        //ex4
        boolean[] evenStatusArr = getEvenStatusOfValues(arr2);
        for (int i = 0; i < evenStatusArr.length; i++) {
            System.out.print(evenStatusArr[i] + ", ");
        }
        System.out.println();
        //ex5
        int[] isIncreaseDecreaseArr = {5, 1, 1, 2, 3, 2, 1, 0};
        System.out.println(IncreaseDecreaseArray(isIncreaseDecreaseArr));

        //ex6
        int countOccurrences = countOccurrences(arr2, 4);
        System.out.println(countOccurrences);
        //ex7
        multiplyEvenIndices(arr2);
        System.out.println();
        //ex8
        int[] arr3 = {2, 4, 0, 8, 2};
        System.out.println(findIndexSumExceeds(arr3, 6));
        //ex9
        //  int[] arr4 = {54, 52, 87, 1, 83, 76, 12, 76, 12, 98, 12, 6};
        printArr(countSmallerEqualGreater(arr3, 50));
        System.out.println();
        //ex10
        boolean areEdgesEqual = areEdgesEqual("i like to eat", "i dont like to eat");
        System.out.println(areEdgesEqual);
        //ex11
        String[] str1 = {"i like", "to play", "football"};
        int countCharInArray = countCharInArray(str1, 'l');
        System.out.println(countCharInArray);
        //ex12
        String[] str2 = {"dappley", "banana", "apple", "orange", "oapplep"};
        int countStringInArray = countStringInArray(str2, "apple");
        System.out.println(countStringInArray);
        //ex13
        String reverseStr = reverseString("hello");
        for (int i = 0; i < reverseStr.length(); i++) {
            System.out.print(reverseStr.charAt(i));
        }
        System.out.println();
        //ex14
        System.out.println(mergeAlternately("abc", "12345"));
        //ex15
//        numbersBiggerThanAvg();
        //ex16
        char firstRepeatedChar = findFirstRepeatedChar("hello");
        System.out.println(firstRepeatedChar);
        //ex17
        String[] str3 = {"aabc", "bbacd", "llasd", "kok"};
        String[] replacedStr = replaceAChar(str3);
        for (int i = 0; i < replacedStr.length; i++) {
            System.out.print(replacedStr[i] + ", ");
        }
        System.out.println();
        //ex18
        int minStringIndex = findMinStringIndex(str2);
        System.out.println(minStringIndex);
        //ex19
        String result18 = getStringWithMoreOccurrences("rrtugf", "klkuurrrrt", 't');
        System.out.println(result18);
        //ex20
        char charWithMinOccurrences = getCharWithMinOccurrences("ssstrtrt");
        System.out.println(charWithMinOccurrences);
        //ex21
        System.out.println(isPasswordIsString("noa1oo!oi"));



    }
    //פונקציית עזר
    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.print(arr[i]);
            } else {
                System.out.print(arr[i] + ", ");
            }
        }
    }
    //ex1 O(n)
    public static boolean hasHigherNumber(int[] arr, int num) {
        boolean isHigherThanNum = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > num) {
                isHigherThanNum = true;
            }
        }
        return isHigherThanNum;
    }
    //ex2 - O(n)
    public static int[] getCombinedArray(int[] arr1, int[] arr2) {
        int newArrLength = arr1.length + arr2.length;
        int[] combinedArray = new int[newArrLength];
        for (int i = 0; i < arr1.length; i++) {
            combinedArray[i] = arr1[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            int index = arr1.length + i;
            combinedArray[index] = arr2[i];
        }
        return combinedArray;
    }
    //ex3 - O(n^2)
    //{2,7,8,7,9,2,9}
    //{2,7,8,9}
    public static int[] getArrayWithoutDuplications(int[] arr){

        int newLengthCount = 0;

        for (int i = 0; i < arr.length; i++) {
            boolean isDuplicate = false;
            for (int j = 0; j<i ; j++) { //שומר את המופע הראשון מוריד את השאר
                if(arr[i] == arr[j]){
                    isDuplicate = true;
                    break; // מונע כפילויות כשמצא את הראשון ששווה יוצא
                }
            }
            if(!isDuplicate){
                newLengthCount++;
            }
        }

         int[] newArr = new int[newLengthCount];
         int newArrIndex = 0;
        for (int i = 0; i <arr.length ; i++) {
            if(newArrIndex == newLengthCount) {
                break;
            }
            boolean isDuplicate = false;
            for (int j = 0; j <i ; j++) {
                if (arr[i]== arr[j]){
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate){
                newArr[newArrIndex] =arr[i];
                newArrIndex++;
            }
        }
        return newArr;
    }

    //ex4 - O(n)
    public static boolean[] getEvenStatusOfValues(int[] arr) {
        boolean[] isEvenArr = new boolean[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                isEvenArr[i] = true;
            } else {
                isEvenArr[i] = false;
            }
        }
        return isEvenArr;
    }
    //ex5 - O(n)
    public static boolean IncreaseDecreaseArray(int[] arr){
        boolean hasIncrease = false;
        boolean hasDecrease = false;
        int maxNum = arr[0];
        int maxIndex = 0;
        if(arr.length<3){
            return false;
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > maxNum){
                maxNum = arr[i];
                maxIndex = i;
            }}
        if(maxIndex == 0 || maxIndex==arr.length-1){
            return false;
        }
        for (int i = 0; i < maxIndex; i++) {
            if (arr[i+1] <= arr[i] ){
                return false;
            }
        }
        for (int i = maxIndex; i < arr.length-1; i++) {
            if(arr[i+1]>=arr[i]){
                return false;
            }
        }
        return true;
    }
    //ex6 - O(n)
    public static int countOccurrences(int[] arr, int number) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == number) {
                count++;
            }
        }
        return count;
    }
    //ex7 - O(n)
    public static void multiplyEvenIndices(int[] arr){
        final int MULTIPLIER = 3;
        for (int i = 0; i <arr.length ; i+=2) {
            arr[i] = arr[i] * MULTIPLIER;
        }
        printArr(arr);
    }
    //ex8 - O(n)
    public static int findIndexSumExceeds(int[] arr, int number){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if(sum > number ){
                return  i;
            }
        }
        return -1;
    }
    //ex9 - O(n)
    public static int[] countSmallerEqualGreater(int[] arr, int number){
        int[] newArr = new int[3];
        int countOfSmaller = 0;
        int countOfEquals = 0;
        int countOfGreater = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < number){
                countOfSmaller++;
            } else if (arr[i] == number) {
                countOfEquals++;
            }else{
                countOfGreater++;
            }
            newArr[0] = countOfSmaller;
            newArr[1] = countOfEquals;
            newArr[2] = countOfGreater;
        }
        return newArr;

    }
    //ex10 - O(1)
    public static boolean areEdgesEqual(String str1, String str2) {
        boolean areEdgesEqual = false;
        if (str1.charAt(0) == str2.charAt(0) &&
                str1.charAt(str1.length() - 1) == str2.charAt(str2.length() - 1)) {
            areEdgesEqual = true;
        }
        return areEdgesEqual;
    }
    //ex11 - O(n^2)
    public static int countCharInArray(String[] strArray, char ch) {
        int count = 0;
        for (int i = 0; i < strArray.length; i++) {
            for (int j = 0; j < strArray[i].length(); j++) {
                if (strArray[i].charAt(j) == ch) {
                    count++;
                }
            }
        }
        return count;
    }
    //ex12 - O(n)
    public static int countStringInArray(String[] arr, String target) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].contains(target)) {
                count++;
            }
        }
        return count;
    }
    //ex13 - O(n)
    public static String reverseString(String str) {
        String reverseStr = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reverseStr += "" + str.charAt(i);
        }
        return reverseStr;
    }
    //ex14 - 0(n)
    public static String mergeAlternately(String str1, String str2) {
        int maxLength = str1.length();
        String mergedStr = "";
        if (str1.length() < str2.length()) {
            maxLength = str2.length();
        }
        for (int i = 0; i < maxLength; i++) {
            if (i < str1.length()) {
                mergedStr += str1.charAt(i);
            }
            if (i < str2.length()) {
                mergedStr += str2.charAt(i);
            }
        }
        return mergedStr;
    }
    //ex15 - O(n)
    public static void numbersBiggerThanAvg(){
        final int NUM_OF_INPUTS = 10;
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[NUM_OF_INPUTS];
        double avg = 0;
        int sum = 0;
        for (int i = 0; i <NUM_OF_INPUTS ; i++) {
            System.out.println("please enter int number");
            int num = scanner.nextInt();
            arr[i] = num;
            sum += num;
        }
        avg = (double) sum/NUM_OF_INPUTS;
        System.out.println("The average of the numbers is: " + avg);
        System.out.println("The numbers that are bigger than the average are:" );
        for (int i = 0; i < NUM_OF_INPUTS; i++) {
            if(arr[i] > avg){
                System.out.print(arr[i] + ", ");
            }
        }
    }
    //ex16 - O(n)
    public static char findFirstRepeatedChar(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                return str.charAt(i);
            }
        }
        return ' ';
    }
    //ex17 - O(n^2)
    public static String[] replaceAChar(String[] strArray) {
        for (int i = 0; i < strArray.length; i++) {
            for (int j = 0; j < strArray[i].length(); j++) {
                strArray[i] = strArray[i].replace('a', 'c');
            }
        }
        return strArray;
    }

    //ex18 - O(n)
    public static int findMinStringIndex(String[] stringsArr) {
        int min = stringsArr[0].length();
        int minIndex = 0;
        for (int i = 0; i < stringsArr.length; i++) {
            if (stringsArr[i].length() < min) {
                min = stringsArr[i].length();
                minIndex = i;
            }
        }
        return minIndex;
    }

    //ex19 - O(n)
    public static int countCharacter(String str, char ch) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                count++;
            }

        }
        return count;
    }
    //O(1)
    public static String getStringWithMoreOccurrences(String str1, String str2, char ch) {
        String stringToReturn = str1 + str2;
        int countStr1 = countCharacter(str1, ch);
        int countStr2 = countCharacter(str2, ch);
        if (countStr1 > countStr2) {
            stringToReturn = str1;
        } else if (countStr1 < countStr2) {
            stringToReturn = str2;
        }
        return stringToReturn;
    }

    //ex20 - O(n^2)
    public static char getCharWithMinOccurrences(String str){
        char minChar= str.charAt(0);
        int minCount = str.length();
        for (int i = 0; i < str.length(); i++) {
            int count = 0;
            for (int j = 0; j < str.length(); j++) {
                if(str.charAt(i) == str.charAt(j)){
                    count++;
                }
            }
            if(count< minCount){
                minCount = count;
                minChar = str.charAt(i);
            }
        }
        return minChar;
    }
    //פונקציות עזר
    //  O(n)
    public static boolean isContainExactOneSpecialChar(String password){
        String specialChars = "$&%!";
        int specialCharsCount = 0;
        for (int i = 0; i < password.length(); i++) {
            if(specialChars.indexOf(password.charAt(i))!= -1){
                specialCharsCount++;
            }
            if(specialCharsCount > 1){
                return false;
            }

        }
        return specialCharsCount==1;
    }
    // O(n)
    public static boolean isContain2Num(String password){
        String numbers = "0123456789";
        int countNumbers = 0;
        for (int i = 0; i < password.length(); i++) {
            if(numbers.indexOf(password.charAt(i)) != -1){
                countNumbers++;
            }
        }
        return countNumbers>=2;
    }
    //ex21 - O(n)
    public static boolean isPasswordIsString(String password){
        if(password.length() >= 9 && isContainExactOneSpecialChar(password) && isContain2Num(password) ){
            return true;
        }
        return false;
    }


}
