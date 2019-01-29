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
        
        System.out.println("Convert to DNA - 1");
        System.out.println("Convert to RNA - 2");
        menuOption = userInput.nextInt();
        
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
                counter += 1;
                
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
