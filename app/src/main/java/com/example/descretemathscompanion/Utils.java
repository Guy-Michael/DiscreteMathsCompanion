package com.example.descretemathscompanion;

import org.apache.commons.lang3.StringUtils;

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
                    /*
                    as long as there is a comma inside the string:
                    iterate the string with i until finding a comma
                    parse the substring from 0 to i
                    add the parsed substring to the linked list

                     */
              int i=0;
              while(temp.contains(","))
                  {
                      if (temp.charAt(i)==',')
                          {
                              int tempNum= Integer.parseInt(temp.substring(0,i));
                              numberList.add(tempNum);
                              temp=temp.substring(i+1);
                              i=0;
                          }
                      i++;
                  }
                int tempNum=Integer.parseInt(temp);
              numberList.add(tempNum);
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
                     /*
                calculate gcd of elements 0 and 1.
                calculate gcd of "gcd" and i.
                return calculation.
                 */
                if (numberList.size()==1)
                    {
                        return numberList.get(0);
                    }
                int gcd=numberList.get(0);
                for(int i =1; i<numberList.size();i++)
                    {
                        if (numberList.get(i)==1)
                            {
                                return 1;
                            }
                        else
                        gcd=Utils.gcd(gcd,numberList.get(i));
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

        public static String formatOutput(LinkedList<Integer> numberList)
            {
                String formatted="";
                if (numberList.size()==1)
                    formatted+=numberList.get(0);
                else
                    {
                        formatted += numberList.get(0);
                        for (int i = 1; i < numberList.size(); i++)
                            {
                                formatted += ", " + numberList.get(i);
                            }
                    }
                return formatted;
            }

        public static void handleUnformattedInputOfMultiple(String inputString) throws UnformattedInputException
            {
                //not seperated by commas
                if(inputString.contains(" "))
                    { throw new UnformattedInputException("Please seperate number with a comma"); }

                //no text at all
                if(inputString.length()==0)
                    { throw new UnformattedInputException("Number field is empty!"); }

                //numbers are not whole
                if (inputString.contains(".") || inputString.contains("/"))
                    { throw new UnformattedInputException("Please enter whole numbers only."); }

                //text ends with a comma
                if (StringUtils.isAlpha(inputString))
                    { throw new UnformattedInputException("Please enter whole numbers only."); };
            }

        public static void handleUnformattedInputOfSingle(String inputString) throws UnformattedInputException
            {
                //more than one number
                if (inputString.contains(" ") || inputString.contains(","))
                    { throw new UnformattedInputException("Please enter a single number only."); }

                //number is a fraction
                if (inputString.contains("."))
                    { throw new UnformattedInputException("Please enter a whole number only."); }

                //no text at all
                if (inputString.length()==0)
                    { throw new UnformattedInputException("number field is empty!"); }
            }
        }
