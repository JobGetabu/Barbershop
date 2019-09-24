package com.job.barbershop.payment.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.job.barbershop.R;

public class FragmentConfirmation extends Fragment {

    private TextView edit_pay;

    public FragmentConfirmation() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_confirmation, container, false);

        edit_pay = root.findViewById(R.id.edit_pay);

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        edit_pay.setOnClickListener(view -> {

        });
    }
}