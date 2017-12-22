package calculator.calculatortest.calculatortest.fragment;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import calculator.calculatortest.calculatortest.R;

public class Fragment1 extends Fragment{
    public Fragment1(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment1, container, false);
        return rootView;
    }
}