package com.example.descretemathscompanion;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
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


                 divisorsButton.setOnClickListener(
                         new View.OnClickListener()
                     {
                         @Override
                         public void onClick(View v)
                             {
                                 tryOnDivisorClick();
                             }
                     });
                return inf;
            }

        public void onDivisorClick() throws UnformattedInputException
            {
                /*
                create a linked list
                fill it using getDivisors
                create an output string
                format is using formatOutput
                 */
                String inputString = input.getText().toString();
                Utils.handleUnformattedInputOfSingle(inputString);
                LinkedList<Integer> divisors= new LinkedList<Integer>();

                divisors=getDivisors();
                String output=Utils.formatOutput(divisors);
                displayResult(output);
            }


        public void tryOnDivisorClick()
            {
                try { onDivisorClick(); }
                 catch (UnformattedInputException e)
                     {
                         String message=e.getMessage();
                         Toast.makeText(getContext(),message,Toast.LENGTH_SHORT).show();
                     }
            }

        public LinkedList<Integer> getDivisors()
            {
                String inputString = input.getText().toString();
                int num= Integer.parseInt(inputString);
              LinkedList<Integer> divisors=new LinkedList<Integer>();
                //check if the number is prime.
              if (Utils.isPrime(num))
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

        public void displayResult(String resultString)
            {
                result.setMovementMethod(new ScrollingMovementMethod());
                result.setText(resultString);
            }




    }
