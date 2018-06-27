package com.example.admin.fragmentsandlists;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.admin.fragmentsandlists.adapter.EmployeeAdapter;
import com.example.admin.fragmentsandlists.fragments.ListHolderFragment;
import com.example.admin.fragmentsandlists.fragments.employeeFragment;
import com.example.admin.fragmentsandlists.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ListHolderFragment.OnFragmentInteractionListener, employeeFragment.OnFragmentInteractionListener{

    EditText name, position, location, gender;
    List<Employee> employees;
    RecyclerView recyclerView;
    EmployeeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
        addFragments();
        employees = new ArrayList();
    }

    private void addFragments() {
        getSupportFragmentManager().beginTransaction().add(R.id.employeeFragment, employeeFragment.newInstance("", "")).add(R.id.listViewFragment, ListHolderFragment.newInstance("", "")).commit();
    }

    private void bindViews() {
        name = findViewById(R.id.etName);
        position = findViewById(R.id.etPosition);
        location = findViewById(R.id.etLocation);
        gender = findViewById(R.id.etGender);
    }




    @Override
    public void onFragmentInteraction(Uri uri) {

    }


    @Override
    public void onFragmentInteraction() {
        if (((EditText)findViewById(R.id.etName)).getText().toString().trim().equals("")){
            Toast.makeText(this, ((EditText)findViewById(R.id.etName)).getText().toString().trim(), Toast.LENGTH_SHORT).show();
            return;
        }
        if (((EditText)findViewById(R.id.etPosition)).getText().toString().trim().equals("")){
            Toast.makeText(this, "Please insert a position", Toast.LENGTH_SHORT).show();
            return;
        }
        if (((EditText)findViewById(R.id.etLocation)).getText().toString().trim().equals("")){
            Toast.makeText(this, "Please insert a Location", Toast.LENGTH_SHORT).show();
            return;
        }
        if (((EditText)findViewById(R.id.etGender)).getText().toString().trim().equals("")){
            Toast.makeText(this, "Please insert a gender", Toast.LENGTH_SHORT).show();
            return;
        }

        employees.add(new Employee(((EditText)findViewById(R.id.etName)).getText().toString().trim(),((EditText)findViewById(R.id.etPosition)).getText().toString().trim(),((EditText)findViewById(R.id.etLocation)).getText().toString().trim(),((EditText)findViewById(R.id.etGender)).getText().toString().trim()));
        ((EditText)findViewById(R.id.etName)).setText("");
        ((EditText)findViewById(R.id.etPosition)).setText("");
        ((EditText)findViewById(R.id.etLocation)).setText("");
        ((EditText)findViewById(R.id.etGender)).setText("");
        generateEmployeeList(employees);
    }

    private void generateEmployeeList(List<Employee> employees) {

        recyclerView = findViewById(R.id.recycler_view_employee_list);
        adapter = new EmployeeAdapter(employees);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }
}
