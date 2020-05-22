package com.example.descretemathscompanion;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.LinkedList;

public class PrimeFactors extends Fragment
    {
        EditText input;
        TextView output;
        Button initiate;
        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
            {
                View inf=inflater.inflate(R.layout.prime_factors,container,false);
                input=(EditText) inf.findViewById(R.id.prime_factors_input);
                output=(TextView) inf.findViewById(R.id.prime_factors_output);
                initiate=(Button) inf.findViewById(R.id.prime_factors_button);

                initiate.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v)
                            {
                                tryOnPrimeFactorsClick();
                            }
                    });


                return inf;
            }

        public void onPrimeFactorsClick()
            {
                String inputStr= input.getText().toString();
                LinkedList<Integer> primeFactors=findPrimeFactors(inputStr);
                inputStr=Utils.formatOutput(primeFactors);
                displayOutput(inputStr);
            }

        public void tryOnPrimeFactorsClick()
            {
                String inputString = input.getText().toString();
                Utils.handleUnformattedInputOfSingle(inputString);

                onPrimeFactorsClick();
            }

        public LinkedList<Integer> findPrimeFactors(String input)
            {
                LinkedList<Integer> primeFactors= new LinkedList<Integer>();
                int i=2;
                int num= Integer.parseInt(input);
                while(num!=1)
                    {
                       if (num%i==0)
                           {
                               primeFactors.add(i);
                               num/=i;
                           }
                        else i++;
                    }
                return primeFactors;
            }

        public void displayOutput(String result)
            {
                output.setText("Prime factors are:\n" +result);
            }

    }
