package com.vytrack.utilities;

public class StaticWait {

    public static void waitLine (int seconds){

        try{
            Thread.sleep(seconds*1000);
        } catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Thread beklemesinde exception verdi bi bak hele hele");
        }


    }
}
