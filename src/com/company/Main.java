package com.company;

import com.sun.jdi.Value;

import java.util.Scanner;
import java.lang.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.lang.String;
import java.lang.Boolean;


public class Main {
    //Zpráva o jakékoliv chybě
    static final String errorMessage = "Zadali jste \u0161patn\u00E9 rodn\u00E9 \u010D\u00EDslo";
    public static void main(String[] args) {

        System.out.println("Zadejte prosím Vaše rodné číslo: ");
        Scanner sc = new Scanner(System.in);
        String BirthNumber=sc.next();
        //OvereniRodneCislo(BirthNumber);
        if(InputVerification(BirthNumber)) DatebirthVerification(BirthNumber);
        else{
            System.out.println("Zadali jste špatné rodné číslo");
        }

    }

    //kontrola, jestli má vstup formát rodného čísla
    public static boolean InputVerification(String BirthNumber){
        String Pattern1 ="[0-9]{6}/?[0-9]{3,4}";
        Pattern pt = Pattern.compile(Pattern1);
        Matcher mt = pt.matcher(BirthNumber);
        boolean result = mt.matches();
        System.out.println(result);
        return result;
    }

    //Kontrola, zda má vstup všechny potřebné požadavky
    public static String DatebirthVerification(String BirthNumber){
        char[] dateBirth = BirthNumber.toCharArray();
        System.out.println(dateBirth[2]);
        if(dateBirth[3]<=1){


            return Character.toString(dateBirth[2]);
        }
        else return errorMessage;
    }
}
