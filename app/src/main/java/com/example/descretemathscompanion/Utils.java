package com.example.descretemathscompanion;

import java.util.LinkedList;

public class Utils
    {
        public static LinkedList<Integer> generateNumberListFromInput(String inputText)
            {
                //initializing a temp for readability.
                String temp=inputText;

                LinkedList<Integer>numberList=new LinkedList<Integer>();
                for(int i =0; i<temp.length();i++)
                    {
                        if(temp.charAt(i)==',')
                            {
                                String tempSub=temp.substring(0,i);
                                int tempNum=Integer.parseInt(tempSub);
                                numberList.add(tempNum);
                                temp=temp.substring(i+1);
                            }
                    }
                numberList.add(Integer.parseInt(temp));
                return numberList;
            }

        public static int gcd(int num1, int num2)
            {
                if (num1 == 0)
                    return num2;
                return gcd(num2 % num1, num1);
            }

        public static int gcdOfMultiple(LinkedList<Integer> numberList)
            {
                int gcd= Utils.gcd(numberList.get(0),numberList.get(1));
                for(int i=2;i<numberList.size()-1;i++)
                    {
                        if (numberList.get(i)==1)
                            return 1;
                        else
                            {
                                gcd=Utils.gcd(i,i+1);
                            }
                    }
                return gcd;
            }
    }
