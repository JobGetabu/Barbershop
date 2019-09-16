package com.job.barbershop.payment.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.job.barbershop.R;

public class FragmentConfirmation extends Fragment {

    public FragmentConfirmation() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_confirmation, container, false);

        return root;
    }
}