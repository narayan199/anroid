package com.example.extendsadpater;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class StudentAdapter  extends ArrayAdapter <Student>{
    private Context context;
    private List<Student> list;

    public StudentAdapter(@NonNull Context context, int resource, List<Student> list) {
        super(context, resource,list);
        this.context=context;
        this.list=list;
    }

    @Override
    public int getPosition(@Nullable Student item) {
        return super.getPosition(item);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // convertView which is recyclable view
        View currentItemView = convertView;

        // of the recyclable view is null then inflate the custom layout for the same
        if (currentItemView == null) {
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.showstudent, parent, false);
        }

        // get the position of the view from the ArrayAdapter
        Student student = getItem(position);

        // then according to the position of the view assign the desired image for the same
        TextView textView = currentItemView.findViewById(R.id.textView);

        textView.setText(student.getmName());
        // then according to the position of the view assign the desired TextView 1 for the same
        TextView textView2 = currentItemView.findViewById(R.id.textView2);
        textView2.setText(student.getmAddress());
        ImageView imageView = currentItemView.findViewById(R.id.imageView);
        imageView.setImageResource(student.getmImageDrwable());

        // then according to the position of the view assign the desired TextView 2 for the sam

        // then return the recyclable view
        return currentItemView;
    }
}
