package com.example.descretemathscompanion;

import java.util.LinkedList;

public class Utils
    {
        public static LinkedList<Integer> generateNumberListFromInput(String inputText)
            {
                //initializing a temp for readability.
                LinkedList<Integer>numberList=new LinkedList<Integer>();
                String temp=inputText;
                if (temp.length()==1)
                    {
                        numberList.add(Integer.parseInt(temp));
                        return numberList;
                    }

                while(temp.length()>=1)
                    {
                        if(temp.charAt(0)==',')
                            {
                                temp=charRemoveAt(temp,0);
                                int tempNum= Integer.parseInt(String.valueOf(temp.charAt(0)));
                                numberList.add(tempNum);

                                /*String tempSub=temp.substring(0,i);
                                int tempNum=Integer.parseInt(tempSub);
                                numberList.add(tempNum);
                                temp=temp.substring(i+1);*/
                            }
                        temp=temp.substring(1);
                    }
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
                if (numberList.size()==1)
                    {
                        return numberList.get(0);
                    }
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

        public static String charRemoveAt(String str, int p)
            {
            return str.substring(0, p) + str.substring(p + 1);
             }

        public static boolean isPrime(int num)
            {
                for (int i =2; i<num; i++)
                    {
                        if (num%i==0)
                            return false;
                    }
                return true;
            }

        public static  String formatOutput(LinkedList<Integer> numberList)
            {
                String result="";
                result+=numberList.get(0)+", ";
                for (int i=1;i<numberList.size()-1;i++)
                    {
                        result+=numberList.get(i)+", ";
                    }
                result+=numberList.getLast();
                return result;
            }
      }
