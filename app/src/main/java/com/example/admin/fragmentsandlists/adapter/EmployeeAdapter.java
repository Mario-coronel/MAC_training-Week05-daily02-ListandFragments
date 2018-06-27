package com.example.admin.fragmentsandlists.adapter;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.fragmentsandlists.R;
import com.example.admin.fragmentsandlists.model.Employee;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder> {

    List<Employee> employees;

    @Override
    public int getItemViewType(int position) {
        return (employees.get(position).getLocation().toString().equals("nearshore")) ? 1 : 2;

    }

    public EmployeeAdapter(List<Employee> employees) {
        this.employees = employees;
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view;
        switch (viewType) {
            case 1:
                view = layoutInflater.inflate(R.layout.nearshore_row, parent, false);
                break;
            default:
                view = layoutInflater.inflate(R.layout.offshore_row, parent, false);
        }
        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {

        holder.name.setText(employees.get(position).getName());
        holder.position.setText((employees.get(position).getPosition()));
        holder.location.setText(employees.get(position).getLocation());
        holder.gender.setText(employees.get(position).getGender());

    }

    @Override
    public int getItemCount() {
        return employees.size();
    }

    class EmployeeViewHolder extends RecyclerView.ViewHolder {

        TextView name, location, position, gender;

        public EmployeeViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.txt_employee_name);
            position = itemView.findViewById(R.id.txt_employee_position);
            location = itemView.findViewById(R.id.txt_employee_location);
            gender = itemView.findViewById(R.id.txt_employee_gender);
        }
    }

}
