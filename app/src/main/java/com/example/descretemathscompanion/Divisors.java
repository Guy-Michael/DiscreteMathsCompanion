package com.example.descretemathscompanion;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.LinkedList;

public class Divisors extends Fragment
    {
    TextView result;
    EditText input;
    Button  divisorsButton;


        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
            {
                View inf= inflater.inflate(R.layout.divisors,container,false);
                 result= (TextView) inf.findViewById(R.id.divisors_result);
                 divisorsButton= (Button) inf.findViewById(R.id.divisors_button);
                 input= inf.findViewById(R.id.divisors_input);
                 divisorsButton.setOnClickListener(new View.OnClickListener()
                     {
                         @Override
                         public void onClick(View v)
                             {
                                 onDivisorClick();
                             }
                     });
                return inf;
            }

        public void onDivisorClick()
            {
                LinkedList<Integer> divisors= new LinkedList<Integer>();
                int num=readInput();
                divisors=getDivisors(num);
                if (divisors.size()>1)
                    {
                        String resultString=formatResult(divisors);
                        displayResult(resultString);
                    }
                else displayResult(String.valueOf(divisors.get(0)));
            }

        public LinkedList<Integer> getDivisors(int num)
            {
              LinkedList<Integer> divisors=new LinkedList<Integer>();
                //check if the number is prime.
              if (isPrime(num))
                  {
                      divisors.add(1);
                      return divisors;
                  }

                for (int i=2; i<num;i++)
                    {
                        if (num%i==0)
                            {
                                divisors.add(i);
                            }
                    }
                return divisors;
            }

        public int readInput()
            {
                return Integer.parseInt(input.getText().toString());
            }

        public void displayResult(String resultString)
            {
                result.setText("Divisors are:\n"+resultString);
            }

        public boolean isPrime(int num)
            {
                for (int i =2; i<num; i++)
                    {
                        if (num%i==0)
                            return false;
                    }
                return true;
            }

        public String formatResult(LinkedList<Integer> divisors)
            {
                String result="";
                result+=divisors.get(0)+", ";
                for (int i=1;i<divisors.size()-1;i++)
                    {
                        result+=divisors.get(i)+", ";
                    }
                result+=divisors.getLast();
                return result;
            }
    }
