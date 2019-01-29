/*
    Jose Hernandez
    1/28/2019
*/

package dna_program;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DNA_Program {

    public static void main(String[] args) {
        
        //needed to get user input
        Scanner userInput = new Scanner(System.in);
        String input;
        
        //A map that stores the appropriate DNA code with its respective character
        Map<String, String> alphabetMap = new HashMap<String, String>();
        alphabetMap.put("A", "TAAT");
        alphabetMap.put("B", "TAAG");
        alphabetMap.put("C", "TAAC");
        alphabetMap.put("D", "TATA");
        alphabetMap.put("E", "TATT");
        alphabetMap.put("F", "TATG");
        alphabetMap.put("G", "TATC");
        alphabetMap.put("H", "TAGA");
        alphabetMap.put("I", "TAGT");
        alphabetMap.put("J", "TAGG");
        alphabetMap.put("K", "TAGC");
        alphabetMap.put("L", "TACA");
        alphabetMap.put("M", "TACT");
        alphabetMap.put("N", "TACG");
        alphabetMap.put("O", "TACC");
        alphabetMap.put("P", "TTAA");
        alphabetMap.put("Q", "TTAT");
        alphabetMap.put("R", "TTAG");
        alphabetMap.put("S", "TTAC");
        alphabetMap.put("T", "TTTA");
        alphabetMap.put("U", "TTTT");
        alphabetMap.put("V", "TTTG");
        alphabetMap.put("W", "TTTC");
        alphabetMap.put("X", "TTGA");
        alphabetMap.put("Y", "TTGT");
        alphabetMap.put("Z", "TTGG");
        alphabetMap.put("a", "TGAT");
        alphabetMap.put("b", "TGAG");
        alphabetMap.put("c", "TGAC");
        alphabetMap.put("d", "TGTA");
        alphabetMap.put("e", "TGTT");
        alphabetMap.put("f", "TGTG");
        alphabetMap.put("g", "TGTC");
        alphabetMap.put("h", "TGGA");
        alphabetMap.put("i", "TGGT");
        alphabetMap.put("j", "TGGG");
        alphabetMap.put("k", "TGGC");
        alphabetMap.put("l", "TGCA");
        alphabetMap.put("m", "TGCT");
        alphabetMap.put("n", "TGCG");
        alphabetMap.put("o", "TGCC");
        alphabetMap.put("p", "TCAA");
        alphabetMap.put("q", "TCAT");
        alphabetMap.put("r", "TCAG");
        alphabetMap.put("s", "TCAC");
        alphabetMap.put("t", "TCTA");
        alphabetMap.put("u", "TCTT");
        alphabetMap.put("v", "TCTG");
        alphabetMap.put("w", "TCTC");
        alphabetMap.put("x", "TCGA");
        alphabetMap.put("y", "TCGT");
        alphabetMap.put("z", "TCGG");
        
        System.out.println("Enter a string of characters only to convert to DNA code");
        input = userInput.next();
        
        for (char ch: input.toCharArray()) {
            //need to convert the char to a string 
            String temp = "" + ch;
            
            //passed the temp value to retrieve that char's value
            System.out.println(alphabetMap.get(temp));
        }
        
    }
    
}
