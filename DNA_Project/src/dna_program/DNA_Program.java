/*
    Jose Hernandez
    1/28/2019
    DNA code

    Assuming that the only characters from the ASCII table that we will be using
    are the letters of the U.S. alphabet.

    Assuming that the directions on screen are being followed so no error catching 
    was coded.
*/

package dna_program;

import java.util.Scanner;

public class DNA_Program {
    
    public static void main(String[] args) {
        
        int menuOption = MenuOption();
        
        switch (menuOption) {
            case 3:
                Option3();
                break;
            case 4:
                Option4();
                break;
            default:
                Option1Or2(menuOption);
                break;
        }
    }
    
    private static int MenuOption(){
        Scanner userInput = new Scanner(System.in);
        
        System.out.println("Convert to DNA - 1");
        System.out.println("Convert to RNA - 2");
        System.out.println("Convert from DNA to alphabet letters - 3");
        System.out.println("Compare 2 strands of DNA - 4");
        
        int menuOption = userInput.nextInt();
        
        return menuOption;
    }
    
    private static void Option1Or2(int option){
        Scanner userInput = new Scanner(System.in);
        
        String input;
        
        System.out.println("Enter a string to convert (FROM THE U.S. ALPHABET ONLY)");
        input = userInput.next();

        String completedDNACode = "";
        String completedComplement = "";

        //travese the input string of char
        for(int i =0; i < input.length(); i++){
            //assign one char at a time to tempChar
            char tempChar = input.charAt(i);

            //convert to ascii decimal value
            int asciiValue = (int) tempChar;

            //convert to binary and add a 0 of padding
            String binaryValue = String.format("%8s", Integer.toBinaryString(asciiValue)).replace(' ', '0');

            //used to iterate every 2 char
            int counter =0;
            //holds a temp 2 digit string to compare to DNA letters
            String tempBinary = "";
            //hold the full DNA code
            String dnaCode = "";
            //complementary strand
            String complement = "";

            //Traverse the binary string to assign the DNA code
            for (char ch: binaryValue.toCharArray()){
                counter++;

                //checks to see if it is on second char
                if(counter == 2){
                    counter = 0;
                    //add the current digit to the temp string
                    tempBinary += ch;
                    //System.out.println(tempBinary);

                    //check the value then assign the appropriate DNA letter
                    if("00".equals(tempBinary)){
                        dnaCode += 'A';
                        complement += 'T';
                    }
                    else if ("01".equals(tempBinary)){
                        //check to see if needs to convert to DNA code
                        if(option == 1){
                            dnaCode += 'T';
                            complement += 'A';
                        }
                        //check to see if needs to convert to RNA code
                        else if(option == 2){
                            dnaCode += 'U';
                        }
                    }
                    else if ("10".equals(tempBinary)){
                        dnaCode += 'G';
                        complement += 'C';
                    }
                    else if ("11".equals(tempBinary)){
                        dnaCode += 'C';
                        complement += 'G';
                    }
                }
                else
                    //add the current digit to the temp string
                    tempBinary = "" + ch;
            }

            completedDNACode += dnaCode + "|";
            //prints the complement if option 1 selected
            if(option == 1){
                completedComplement += complement + "|";
            }
            //System.out.println(binaryValue);
        }
        System.out.println("The DNA Code is: \t\t" + completedDNACode);
        System.out.println("The complement strant is: \t" + completedComplement);
    }
    
    private static void Option3(){
        Scanner userInput = new Scanner(System.in);
        
        //used to store user input
        String dnaToLetters;
        //used to store the final string of letters
        String finalAnswer = "";
        
        //read in the string of DNA
        System.out.println("Enter the DNA code string (IN ALL CAPS)");
        dnaToLetters = userInput.next();

        //check to see if the string is the correct lenght
        if(dnaToLetters.length()%4 != 0){
            System.out.println("Error -1: does not exist - not divisible by 4");
        }
        
        //used to count intervals of 4
        int counter = 0;
        //stores temp section until 4 letters are reached
        String tempDNASection = "";
        //stores the DNA code in binary
        String dnaInBinary = "";
        
        //traverse user input
        for(char charStrand1: dnaToLetters.toCharArray()){
            //add the letter to the temp string
            tempDNASection += charStrand1;
            
            //if not on the 4th interval add to counter
            if(counter < 3){
                counter++;
            }
            //now on the 4th interval
            else{
                //reset the counter
                counter = 0;
                //traverse the section of the string and assign values
                for(char charSectionStrand1: tempDNASection.toCharArray() ){
                    switch(charSectionStrand1){
                        case 'A':
                            dnaInBinary += "00";
                            break;
                        case 'T':
                            dnaInBinary += "01";
                            break;
                        case 'G':
                            dnaInBinary += "10";
                            break;
                        case 'C':
                            dnaInBinary += "11";
                            break;
                    }
                }
                //convert the binary string to deciaml value
                int decimalValue = Integer.parseInt(dnaInBinary, 2);
                
                //check to see if decimal value is in the US alphabet
                if((decimalValue >= 65 && decimalValue <= 90) || (decimalValue >= 97 && decimalValue <= 122)){
                    //convert decimal value to alphabet letter
                    String letter = Character.toString((char) decimalValue);
                    //add to the master string
                    finalAnswer += letter;
                }
                //print error if not in the alphabet
                else
                    System.out.println("Error -1: does not exist - not in the alphabet");
                
                //clear out any stored values
                tempDNASection = "";
                dnaInBinary = "";
            }
        }
        //prints out the letters as one string
        System.out.println(finalAnswer);
    }
    
    private static void Option4(){
        Scanner userInput = new Scanner(System.in);
        
        String strand1;
        String strand2;
        
        System.out.println("Enter the first DNA strand");
        strand1 = userInput.next();
        
        System.out.println("Enter the second DNA strand");
        strand2 = userInput.next();
        
        System.out.println(EveryFour(strand1, strand2));
    }
    
    private static String SectionOffEveryFour(String dnaString){
        
        
        //used to store the final string of letters
        String finalAnswer = "";
        
        //used to count intervals of 4
        int counter = 0;
        //stores temp section until 4 letters are reached
        String tempDNASection = "";
        
        
        //traverse user input
        for(char charStrand1: dnaString.toCharArray()){
            //add the letter to the temp string
            tempDNASection += charStrand1;
            
            //if not on the 4th interval add to counter
            if(counter < 3){
                counter++;
            }
            //now on the 4th interval
            else{
                //reset the counter
                counter = 0;
                //traverse the section of the string and assign values
                for(char charSectionStrand1: tempDNASection.toCharArray() ){
                    
                    switch(charSectionStrand1){
                        case 'A':
                            finalAnswer += "A";
                            counter++;
                            break;
                        case 'T':
                            finalAnswer += "T";
                            counter++;
                            break;
                        case 'G':
                            finalAnswer += "G";
                            counter++;
                            break;
                        case 'C':
                            finalAnswer += "C";
                            counter++;
                            break;
                    }
                }
                counter = 0;
                finalAnswer += "|";
                //clear out any stored values
                tempDNASection = "";
            }
        }
        //prints out the letters as one string
        return finalAnswer;
    }
    
    private static String EveryFour(String string1, String string2){
        String newString1 = SectionOffEveryFour(string1);
        String newString2= SectionOffEveryFour(string2);
        
        return Subsequences(newString1, newString2);
    }
    
    private static String Subsequences(String string1, String string2){
        String newString1;
        String newString2;
        int counter1 = string1.length();
        int counter2 = string2.length();
        
        //System.out.println("Before if: " + counter1);
        
        //check to see if one of the strings ended
        if(counter1 == 0 || counter2 == 0){
            //System.out.println("Inside IF: " + counter1);
            return "";
        }
        
        //travers the string from left to right and check to see if there is a match
        else if(string1.charAt(counter1 - 1) == string2.charAt(counter2 - 1)){
            //System.out.println("Inside ELSE IF");
            return Subsequences(string1.substring(0, counter1 - 1), string2.substring(0, counter2 - 1)) + string1.charAt(counter1 - 1);
        }
        else{
            //System.out.println("Inside ELSE");
            newString1 = Subsequences(string1, string2.substring(0, counter2 - 1));
            newString2 = Subsequences(string1.substring(0, counter1 - 1), string2);
        }
        //System.out.println("Inside RETURN");
        return (newString1.length() > newString2.length() ? newString1 : newString2);
    }
} 
