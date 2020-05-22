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

public class LCM extends Fragment
    {
        Button calculateLCM;
        EditText input;
        TextView output;

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
            {
                View inf=inflater.inflate(R.layout.lcm,container,false);
                input=(EditText)inf.findViewById(R.id.lcm_input);
                output=(TextView) inf.findViewById(R.id.lcm_result);
                calculateLCM=(Button) inf.findViewById(R.id.lcm_button);

                calculateLCM.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v)
                            {
                                tryOnLcmClick();
                            }
                    });
                return inf;
            }

        public void onLcmClick()
            {
                String inputString=input.getText().toString();
                Utils.handleUnformattedInputOfMultiple(inputString);

                int lcm;
                LinkedList<Integer> numberList=Utils.generateNumberListFromInput(inputString);
                lcm=lcmOfMultiple(numberList);
                displayLCM(lcm);
            }
         private int lcm(int num1, int num2)
             {
                 int multiple=num1*num2;
                 int lcm=multiple/Utils.gcd(num1,num2);
                 return lcm;
             }

        public void tryOnLcmClick()
            {
                try {  onLcmClick(); }
                catch(UnformattedInputException e)
                    {   Toast.makeText(getContext(),e.getMessage(),Toast.LENGTH_SHORT).show();  }
            }

        public int lcmOfMultiple(LinkedList<Integer> numberList)
            {
                //if only 1 element
                if (numberList.size()==1)
                    return numberList.get(0);

                //set beginning value to first element
                int lcm=numberList.get(0);

                for (int i =1; i <numberList.size(); i++)
                    {
                        lcm=lcm(lcm,numberList.get(i));
                    }
                return lcm;
            }

        public void displayLCM(int num)
            {
                String resultStr=String.valueOf(num);
                output.setText("LCM is: "+resultStr);
            }
    }
