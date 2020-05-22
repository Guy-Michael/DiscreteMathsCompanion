package com.example.descretemathscompanion;

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

public class GCD extends Fragment
    {
        TextView result;
        EditText input;
        Button calculateGCD;


        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
            {
                View inf =inflater.inflate(R.layout.gcd,container,false);
                result=inf.findViewById(R.id.gcd_result);
                input=inf.findViewById(R.id.gcd_input);
                calculateGCD=inf.findViewById(R.id.gcd_button_calculate);

                calculateGCD.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v)
                            {
                                tryOnGcdClick();
                            }
                    });
                return inf;
            };
        public void onGcdClick() throws UnformattedInputException
            {
                //generate the number list using generateNumberListFromInput
                //Calculate total GCD using gcdOfMultiple.
                //print result to screen using displayResult.
                String inputString = input.getText().toString();
                Utils.handleUnformattedInputOfMultiple(inputString);

                int gcd;
                LinkedList<Integer> numberList=Utils.generateNumberListFromInput(inputString);
                gcd=Utils.gcdOfMultiple(numberList);
                displayResult(gcd);
            }

        public void tryOnGcdClick()
            {
                try {   onGcdClick(); }
                catch(UnformattedInputException e)
                    {
                        String toasty=e.getMessage();
                        Toast.makeText(getContext(), toasty, Toast.LENGTH_SHORT).show();
                    }
            }

        public void displayResult(int num)
            {
                result.setText(String.valueOf(num));
            }
    }


