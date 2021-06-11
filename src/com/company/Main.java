package com.company;

import java.util.Scanner;
import java.lang.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.lang.String;
import java.lang.Integer;


public class Main {

    //static final String errorMessage = "Zadali jste \u0161patn\u00E9 rodn\u00E9 \u010D\u00EDslo";
    public static void main(String[] args) {

        System.out.println("Zadejte prosím Vaše rodné číslo: ");
        Scanner sc = new Scanner(System.in);
        String birthNumber=sc.next();
        if(InputVerification(birthNumber)) DateBirthVerification(birthNumber);
        else{
            System.out.println("Zadali jste špatné rodné číslo");
        }

    }

    //kontrola, jestli má vstup formát rodného čísla
    public static boolean InputVerification(String birthNumber){
        String Pattern1 ="[0-9]{6}/?[0-9]{3,4}";
        Pattern pt = Pattern.compile(Pattern1);
        Matcher mt = pt.matcher(birthNumber);
        return mt.matches();
    }

    //Kontrola, zda má vstup všechny potřebné požadavky
    public static void DateBirthVerification(String birthNumber){
        String[] arr = birthNumber.split("/");
        String arr1=arr[0] + arr[1];
        char[] dateBirth2 = arr1.toCharArray();
        int[] dateBirth = new int[10];
        for(int i = 0; i < dateBirth2.length; ++i) {
            dateBirth[i] = (dateBirth2)[i] - 48;
        }
        String rokNarozeni= dateBirth[0] +Integer.toString(dateBirth[1]);
        int rokNarozeniInt = Integer.parseInt(rokNarozeni);
        rokNarozeniInt=GetBirthYear(rokNarozeniInt);

        String birthDay = dateBirth[4] +Integer.toString(dateBirth[5]);
        int birthDayInt=Integer.parseInt(birthDay);
        //GetBirthDay(birthDayInt);

        String mesic = (dateBirth[2]) + Integer.toString(dateBirth[3]);
        int mesicInt = Integer.parseInt(mesic);

        //System.out.println(birthDay);
        if((DayIsValid(birthDayInt))&&(MonthIsValid(dateBirth[2]))&&(DivideVer(dateBirth, birthNumber))){
            System.out.println("true");
            DateBirthConvert(birthDayInt, mesicInt, rokNarozeniInt);
        }
    }

    //Konverze vstupu do formát data narození
    public static void DateBirthConvert(int birthDay, int birthMonth, int birthYear){
        System.out.println("Vase datum narození je:"+birthDay+". "+birthMonth+". "+birthYear);
    }

    //Kontrola měsíce
    public static boolean MonthIsValid(int Month){
        return GetGender(Month) < 12;
    }

    /*public static int GetBirthMonth(){

        return 0;
    }*/

    public static int GetGender(int Month){
        if(Month>5){
            int tmp=Month;
            tmp=tmp-5;
            Month=(char)tmp;
            return Month;
        }
        else return Month;

    }



    public static boolean DayIsValid(int BirthDay){
        return BirthDay < 32;
    }


    /*public static int GetBirthDay(int BirthDay){

        return BirthDay;
    }*/


    public static int GetBirthYear(int rokNarozeni){
        if(rokNarozeni<22){
            rokNarozeni+=2000;
        }
        else{
            rokNarozeni+=1900;
        }
        return rokNarozeni;
    }

    //Kontrola delitelnosti
    public static boolean DivideVer(int[] dateBirth, String dateBirth2){
        int lichaCisla = dateBirth[0]+dateBirth[2]+dateBirth[4]+dateBirth[6]+dateBirth[8];
        int sudaCisla = dateBirth[1] + dateBirth[3] + dateBirth[5] + dateBirth[7]+dateBirth[9];
        if(dateBirth2.length()==9){
            return true;
        }
        else if((lichaCisla-sudaCisla)==0||(lichaCisla-sudaCisla)%11==0){
           return true;
        }
        else{
        System.out.println("špatná kontrolní číslice");
            return false;}
    }
}