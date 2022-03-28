package com.deitel.myapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

import androidx.appcompat.widget.AppCompatButton;

public class ButtonWithParameter {
    private Button button;
    private int parameter;

    public ButtonWithParameter(Button button, int parameter) {
        this.button = button;
        this.parameter = parameter;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    public int getParameter() {
        return parameter;
    }

    public void setParameter(int parameter) {
        this.parameter = parameter;
    }
}
