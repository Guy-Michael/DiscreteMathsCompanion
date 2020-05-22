package com.example.descretemathscompanion;

import android.widget.Toast;

public class UnformattedInputException extends RuntimeException
    {
        public UnformattedInputException()
            {
                super();
            }

        public UnformattedInputException(String message)
            {
                super(message);
            }
    }
