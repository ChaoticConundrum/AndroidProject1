package com.example.cawate14.androidproject1;

import java.security.spec.ECField;

// Convert integer strings between bases, with plenty of input sanitizing
public class BaseConverter {

    private String input;
    private int ibase;
    private int obase;

    public BaseConverter(String input, int ibase, int obase){
        this.input = input;
        this.ibase = ibase;
        this.obase = obase;
    }

    public boolean setIBase(String str){
        try {
            // Check that input base string is an integer
            ibase = Integer.parseInt(str);
            // Check that input base is supported
            return (ibase >= Character.MIN_RADIX && obase <= Character.MAX_RADIX);
        } catch (Exception e){
            return false;
        }
    }

    public boolean setOBase(String str){
        try {
            // Check that output base string is an integer
            obase = Integer.parseInt(str);
            // Check that output base is supported
            return (obase >= Character.MIN_RADIX && obase <= Character.MAX_RADIX);
        } catch (Exception e){
            return false;
        }
    }

    public boolean setInput(String str){
        try {
            // Check that input string is valid with given input base
            Long.parseLong(str, ibase);
            input = str;
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public String getOutput(){
        try {
            // Parse input with given input base
            long num = Long.parseLong(input, ibase);
            // Format output with given output base
            return Long.toString(num, obase);
        } catch (Exception e){
            return "!!!";
        }

    }

}
