package com.example.assignment4studentsapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.assignment4studentsapp.model.StudentList;
import com.example.assignment4studentsapp.model.Student;

public class NewStudentFragment extends Fragment {

    EditText etName;
    EditText etId;
    EditText etPhone;
    EditText etAddress;
    CheckBox cbChecked;
    Button btnCancel;
    Button btnSave;

    public NewStudentFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_new_student, container, false);

        etName = view.findViewById(R.id.new_student_name_et);
        etId = view.findViewById(R.id.new_student_id_et);
        etPhone = view.findViewById(R.id.new_student_phone_et);
        etAddress = view.findViewById(R.id.new_student_address_et);
        cbChecked = view.findViewById(R.id.new_student_checked_cb);

        btnCancel = view.findViewById(R.id.new_student_cancel_btn);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigateUp();
            }
        });

        btnSave = view.findViewById(R.id.new_student_save_btn);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StudentList.instance.addStudent(new Student(
                        etName.getText().toString(),
                        etId.getText().toString(),
                        etPhone.getText().toString(),
                        etAddress.getText().toString(),
                        cbChecked.isChecked()
                ));
                Navigation.findNavController(view).navigateUp();
            }
        });

        return view;
    }
}