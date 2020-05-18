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
                                calculateLCM();
                            }
                    });
                return inf;
            }

        public void calculateLCM()
            {
                String unformattedInput=input.getText().toString();
                LinkedList<Integer> numberList= Utils.generateNumberListFromInput(unformattedInput);

                //actual calculation
                int lcm=multiplyLcmNumbers(numberList)/Utils.gcdOfMultiple(numberList);
                displayLCM(lcm);
            }

        public int multiplyLcmNumbers(LinkedList<Integer> numberList)
            {
                int multiple=1;
                for (int i =0; i<numberList.size();i++)
                    {
                        multiple*=numberList.get(i);
                    }
                return multiple;
            }

        public void displayLCM(int num)
            {
                String resultStr=String.valueOf(num);
                output.setText("LCM is: "+resultStr);
            }

      //  public void

    }
