/// todo: manage -v -s -o w/o something after
public class Main {
     public static void main(String[] args) {
///        for (String s : args) {
//            System.out.print(s + " ");
//        }
         int tokenS = 0, tokenV = 0, tokenO = 0;
         String symbol = "";
         int[] values = new int[args.length];
         String orientation = "";
         boolean isError = false;
         int j = 0;
         boolean test = true;
         if (detectArgument(args, "-v")[0] != 1) { /// complexity could be improved
             System.out.println("Error: Missing -v argument parameter");
         } else {
             for (int i = 0; i < args.length; i++) {
                 if (args[i].equals("-s") && tokenS == 0) {
                     i++;
                     symbol = args[i];
                     tokenS++;
                 }
                 if (args[i].equals("-v") && tokenV == 0) {
                     i++;
                     while (isInt(args[i]) && test) {
                         if (i == args.length - 1) {
                             test = false;
                         }
                         values[j] = Integer.parseInt(args[i]); /// todo: reuse getIntegerValues
                         if (test) {
                             i++;
                             j++;
                         }

                     }
                     tokenV++;
                     i--;
                 }
                 if (args[i].equals("-o") && tokenO == 0) {
                     i++;
                     orientation = args[i];
                     tokenO++;
                 }
                 if ((args[i].equals("-o") && tokenO == 1) | (args[i].equals("-v") && tokenV == 1) | (args[i].equals("-s") && tokenS == 1)){
                     System.out.println("Error: argument given twice");
                     isError = true;
                 }
             }
             values = trim(values);

             if (!isError) {
                 if (orientation.equals("v")) {
                     printVerticalHistogram(values, symbol);
                 }
                 else if(orientation.equals("h")) printHorizontalHistogram(values, symbol);
                 else System.out.println("Error: invalid argument after -o!");
             }
         }

     }

     public static int[] getIntegerValues(String[] args) {
         int[] argsInt = new int[args.length];
         for (int i = 0; i < args.length; i++) {
             argsInt[i] = Integer.parseInt(args[i]);
         }
         return argsInt;
     }

     public static int[] getOccurrences(int[] values) {
         int max = max(values);
         int[] OccurrenceArray = new int[max + 1];
         for (int value : values) {
             OccurrenceArray[value]++;
         }
         return OccurrenceArray;
     }

     public static int min(int[] valuesOccurrence) {
         for (int i=0; i<valuesOccurrence.length; i++) {
             if (valuesOccurrence[i] != 0){
                 return i;
             }
         }
         return 0;
     }

     public static int max(int[] values) {
         int max = values[0];
         for (int v : values) {
             if (v > max) {
                 max = v;
             }
         }
         return max;
     }

     public static void printHorizontalHistogram(int[] values, String symbol) {
         int[] numberOfOccurrences = getOccurrences(values);
         int verifyMin = 0;
         for (int i = 0; i < numberOfOccurrences.length; i++) {
             if (numberOfOccurrences[i] != 0 && verifyMin == 0) {
                 verifyMin = 1;
             }
             if (verifyMin == 1) {
                 System.out.print(i + " ");
                 for (int j = 0; j < numberOfOccurrences[i]; j++) {
                     System.out.print(symbol);
                 }
                 System.out.println();
             }
         }
     }

     public static int[] detectArgument(String[] args, String argument) {
         int[] verify = new int[2]; /// this array contains if the argument is in the string (1) or not (0) and its index
         for (int i = 0; i < args.length; i++) {
             if (args[i].equals(argument)) {
                 verify[0] = 1;
                 verify[1] = i;
                 break;
             }
         }
         return verify;
     }

     public static boolean isInt(String s) {
         boolean verify = true;
         try {
             Integer.parseInt(s);
         } catch (NumberFormatException error) {
             verify = false;
         }
         return verify;
     }

     public static int[] trim(int[] values) {
         int counter = 0;
         for (int value : values) {
             if (value == 0) {
                 counter++;
             }
         }
         int[] newTable = new int[values.length - counter];
         for (int i = 0; i < values.length - counter; i++) {
             newTable[i] = values[i];
         }
         return newTable;
     }

     public static void printVerticalHistogram(int[] values, String symbol) {
         int[] numberOfOccurrences = getOccurrences(values);
         int maxOccurrence = max(numberOfOccurrences);
         int verifyMin = 0;
         int getIValue = 0;
         int min = min(numberOfOccurrences);
         for (int counter = maxOccurrence; counter >= 0; counter--) {
             for (int i = min; i < numberOfOccurrences.length; i++) {
//                 if (numberOfOccurrences[i] != 0 && verifyMin == 0) {
//                     verifyMin = 1;
//                 }
//                 if (verifyMin == 1) {
                 if (counter != 0) {
                     if (numberOfOccurrences[i] >= counter) {
                         for (int j = 0; j < (int) Math.log10(i); j++) {
                             System.out.print(" ");
                         }
                         System.out.print(symbol + " ");

                     } else {
                         for (int j = 0; j < (int) Math.log10(i); j++) {
                             System.out.print(" ");
                         }
                         System.out.print("  ");
                     }
                 } else {
                     System.out.print(i + " ");
                 }
//                 }
             }
             System.out.println();
         }
     }
 }


