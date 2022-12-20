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

public class EditStudentFragment extends Fragment {

    EditText etName;
    EditText etId;
    EditText etPhone;
    EditText etAddress;
    CheckBox cbChecked;
    Button btnCancel;
    Button btnDelete;
    Button btnSave;

    public EditStudentFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_student, container, false);

        int position = EditStudentFragmentArgs.fromBundle(getArguments()).getPosition();
        Student student = StudentList.instance.getStudent(position);

        etName = view.findViewById(R.id.edit_student_name_et);
        etId = view.findViewById(R.id.edit_student_id_et);
        etPhone = view.findViewById(R.id.edit_student_phone_et);
        etAddress = view.findViewById(R.id.edit_student_address_et);
        cbChecked = view.findViewById(R.id.edit_student_checked_cb);

        etName.setText(student.getName());
        etId.setText(student.getId());
        etPhone.setText(student.getPhone());
        etAddress.setText(student.getAddress());
        cbChecked.setChecked(student.isChecked());

        btnCancel = view.findViewById(R.id.edit_student_cancel_btn);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigateUp();
            }
        });

        btnDelete = view.findViewById(R.id.edit_student_delete_btn);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StudentList.instance.removeStudent(position);
                Navigation.findNavController(view).popBackStack(R.id.nav_students_list, false);
            }
        });

        btnSave = view.findViewById(R.id.edit_student_save_btn);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                student.setName(etName.getText().toString());
                student.setId(etId.getText().toString());
                student.setPhone(etPhone.getText().toString());
                student.setAddress(etAddress.getText().toString());
                student.setChecked(cbChecked.isChecked());
                Navigation.findNavController(view).navigateUp();
            }
        });

        return view;
    }
}