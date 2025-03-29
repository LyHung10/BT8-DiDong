package vn.iotstart.myapplication.ActivityBT1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vn.iotstart.myapplication.R;
import vn.iotstart.myapplication.databinding.FragmentNewOrderBinding;

public class NewOrderFragment extends Fragment {
    FragmentNewOrderBinding binding;

    public NewOrderFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentNewOrderBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}