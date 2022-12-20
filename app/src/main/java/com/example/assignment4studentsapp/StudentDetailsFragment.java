package com.example.assignment4studentsapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.assignment4studentsapp.model.StudentList;
import com.example.assignment4studentsapp.model.Student;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class StudentDetailsFragment extends Fragment {
    View view;

    Student student;

    TextView tvName;
    TextView tvId;
    TextView tvPhone;
    TextView tvAddress;
    CheckBox cbChecked;
    FloatingActionButton fabEdit;

    public StudentDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_student_details, container, false);

        int position = StudentDetailsFragmentArgs.fromBundle(getArguments()).getPosition();
        student = StudentList.instance.getStudent(position);

        tvName = view.findViewById(R.id.student_details_name_tv);
        tvId = view.findViewById(R.id.student_details_id_tv);
        tvPhone = view.findViewById(R.id.student_details_phone_tv);
        tvAddress = view.findViewById(R.id.student_details_address_tv);
        cbChecked = view.findViewById(R.id.student_details_checked_cb);

        setStudentDetailsInViews();

        fabEdit = view.findViewById(R.id.student_details_edit_fab);
        fabEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(StudentDetailsFragmentDirections.actionNavStudentDetailsToNavEditStudent(position));
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        setStudentDetailsInViews();
    }

    private void setStudentDetailsInViews() {
        tvName.setText(student.getName());
        tvId.setText(student.getId());
        tvPhone.setText(student.getPhone());
        tvAddress.setText(student.getAddress());
        cbChecked.setChecked(student.isChecked());
    }


}