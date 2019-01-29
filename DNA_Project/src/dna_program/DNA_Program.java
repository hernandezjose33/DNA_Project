/*
    Jose Hernandez
    1/28/2019
    DNA code
*/

package dna_program;

import java.util.Scanner;

public class DNA_Program {

    public static void main(String[] args) {
        
        //needed to get user input
        Scanner userInput = new Scanner(System.in);
        String input;
        int menuOption;
        String dnaToLetters;
        
        System.out.println("Convert to DNA - 1");
        System.out.println("Convert to RNA - 2");
        System.out.println("Convert from DNA to alphabet letters - 3");
        
        menuOption = userInput.nextInt();
        
        if(menuOption == 3){
            //read in the string of DNA
            System.out.println("Enter the DNA code string (IN ALL CAPS)");
            dnaToLetters = userInput.next();
            
            //check to see if the string is the correct lenght
            if(dnaToLetters.length()%4 != 0){
                System.out.println("Error -1: does not exist");
            }
            
            //temp DNA code
            String tempBinary = "";
            //holds all the letters
            int decimalValue;
            //holds the char of the decimal value
            String letter;
            //counter to check every 4 char
            int counter = 0;
            //stores the temp DNACode 
            String tempDNACode = "";
                
            for(int i = 0; i < dnaToLetters.length(); i++){
                //System.out.println("start of iteration: " + i);
                
                if(counter == 4){
                    for (char ch: tempDNACode.toCharArray()){

                        switch (ch) {
                            case 'A':
                                tempBinary += "00";
                                break;
                            case 'T':
                                tempBinary += "01";
                                break;
                            case 'G':
                                tempBinary += "10";
                                break;
                            case 'C':
                                tempBinary += "11";
                                break;
                            default:
                                break;
                        }
                    }
                    
                    counter = 1;
                    tempDNACode = "";
                    tempDNACode += dnaToLetters.charAt(i);
                    
                    //convert the binary string to deciaml value
                    decimalValue = Integer.parseInt(tempBinary, 2);
                    //System.out.println(decimalValue);

                    //check to see if decimal value is in the US alphabet
                    if((decimalValue >= 65 && decimalValue <= 90) || (decimalValue >= 97 && decimalValue <= 122)){
                        //convert decimal value to alphabet letter
                        letter = Character.toString((char) decimalValue);
                        System.out.println(letter);
                    }
                    else
                        System.out.println("Error -1: does not exist");
                    tempBinary = "";
                }
                else{
                    //System.out.println(counter);
                    counter += 1;
                    tempDNACode += dnaToLetters.charAt(i);
                    //System.out.println(tempDNACode);
                    //System.out.println("end of iteration: " + i);
                }
            }
            for (char ch: tempDNACode.toCharArray()){

                switch (ch) {
                    case 'A':
                        tempBinary += "00";
                        break;
                    case 'T':
                        tempBinary += "01";
                        break;
                    case 'G':
                        tempBinary += "10";
                        break;
                    case 'C':
                        tempBinary += "11";
                        break;
                    default:
                        break;
                }
            }

            counter = 1;
            tempDNACode = "";

            //convert the binary string to deciaml value
            decimalValue = Integer.parseInt(tempBinary, 2);
            //System.out.println(decimalValue);

            //check to see if decimal value is in the US alphabet
            if((decimalValue >= 65 && decimalValue <= 90) || (decimalValue >= 97 && decimalValue <= 122)){
                //convert decimal value to alphabet letter
                letter = Character.toString((char) decimalValue);
                System.out.println(letter);
            }
            else
                System.out.println("Error -1: does not exist");
            tempBinary = "";
        }
        
        else{
            System.out.println("Enter a string to convert (FROM THE US ALPHABET ONLY)");
            input = userInput.next();

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
                        }
                        else if ("01".equals(tempBinary)){
                            //check to see if needs to convert to DNA code
                            if(menuOption == 1){
                                dnaCode += 'T';
                            }
                            //check to see if needs to convert to RNA code
                            else if(menuOption == 2){
                                dnaCode += 'U';
                            }
                        }
                        else if ("10".equals(tempBinary)){
                            dnaCode += 'G';
                        }
                        else if ("11".equals(tempBinary)){
                            dnaCode += 'C';
                        }
                    }
                    else
                        //add the current digit to the temp string
                        tempBinary = "" + ch;
                }

                System.out.println(dnaCode);
                //System.out.println(binaryValue);
            }
        }
    }
}
