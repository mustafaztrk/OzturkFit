package com.example.projeone;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.projeone.Business.Concretes.UserManager;
import com.example.projeone.DataAccess.Concretes.SQLite.DataBaseConnection;
import com.example.projeone.DataAccess.Concretes.SQLite.SQLiteUserDao;
import com.example.projeone.Entities.Concretes.User;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    private DataBaseConnection vt;
    private TextView txtAvailable,txtNecessary,txtMotivationSen;
    private Double   height,weight;
    private double  bmi;


    private DumbellFragment dumbellFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_home, container, false);
        View v=inflater.inflate(R.layout.fragment_home,container,false);


        vt=new DataBaseConnection(v.getContext());

        UserManager userManager=new UserManager(new SQLiteUserDao(vt));


        txtAvailable=v.findViewById(R.id.txtAvailable);
        txtNecessary=v.findViewById(R.id.txtNecessary);
        txtMotivationSen=v.findViewById(R.id.txtMotivationSen);

        txtMotivationSen.setText("Bugün sana İMKANSIZ gelen hareketler bir gün ISINMA hareketlerin olacak.");

        if (userManager.GetAll().size()>0) {
            ArrayList<User> userArrayList = new ArrayList<>();
            userArrayList = userManager.GetAll();
            int i = 0;
            for (User u : userArrayList) {

                if (i == 0) {

                    height=new Double(u.getHeight());
                    weight=new Double(u.getWeight());
                    Log.e(" sad",String.valueOf(height/100));
                    Log.e(" sad",String.valueOf(u.getWeight()));
                    height=height/100;
                    bmi=weight/height;
                    txtAvailable.setText(String.valueOf(bmi));
                }
                i++;
            }
        }
        if(bmi <18)
        {
            txtNecessary.setText("ZAYIF");

        }
        else if(bmi >= 18 && bmi <25)
        {
            txtNecessary.setText("NORMAL");
        }
        else if(bmi >= 25 && bmi <30)
        {
            txtNecessary.setText("KİLOLU");
        }
        else if(bmi >= 30 && bmi <35)
        {
            txtNecessary.setText("OBEZ");
        }
        else
        {
            txtNecessary.setText("CİDDİ OBEZ");
        }




        return v;

    }


}