package com.company;


import java.util.Scanner;
import java.lang.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.lang.String;


public class Main {
    //Zpráva o jakékoliv chybě
    static final String errorMessage = "Zadali jste \u0161patn\u00E9 rodn\u00E9 \u010D\u00EDslo";
    public static void main(String[] args) {

        System.out.println("Zadejte prosím Vaše rodné číslo: ");
        Scanner sc = new Scanner(System.in);
        String BirthNumber=sc.next();
        //OvereniRodneCislo(BirthNumber);
        if(InputVerification(BirthNumber)) DateBirthVerification(BirthNumber);
        else{
            System.out.println("Zadali jste špatné rodné číslo");
        }

    }

    //kontrola, jestli má vstup formát rodného čísla
    public static boolean InputVerification(String BirthNumber){
        String Pattern1 ="[0-9]{6}/?[0-9]{3,4}";
        Pattern pt = Pattern.compile(Pattern1);
        Matcher mt = pt.matcher(BirthNumber);
        return mt.matches();
    }

    //Kontrola, zda má vstup všechny potřebné požadavky
    public static String DateBirthVerification(String BirthNumber){
        char[] dateBirth = BirthNumber.toCharArray();
        BirthNumber = BirthNumber.replaceAll("[^\\d]", "");
        int x = Integer.parseInt(BirthNumber);
        if((x %11 ==0) || (dateBirth[4]==1 && dateBirth[5]<3)||(dateBirth[4]==0 && dateBirth[5]>0)){
            System.out.println("true");
            DateBirthConvert();
            return Character.toString(dateBirth[2]);
        }
        else return errorMessage;
    }

    //Konverze vstupu do formát data narození
    public static String DateBirthConvert(){

        return "0";
    }
}
