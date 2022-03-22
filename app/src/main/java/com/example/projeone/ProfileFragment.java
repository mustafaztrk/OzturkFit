package com.example.projeone;

import static com.example.projeone.MainActivity.sporLevel;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.projeone.Business.Concretes.UserManager;
import com.example.projeone.DataAccess.Concretes.SQLite.DataBaseConnection;
import com.example.projeone.DataAccess.Concretes.SQLite.SQLiteUserDao;
import com.example.projeone.Entities.Concretes.User;

import java.util.ArrayList;


public class ProfileFragment extends Fragment {
    private TextView TxtUserName,txtTopD,txtTopT;
    private Button btnUpdate;
    private EditText EdtTxtNameLastName,EdtTxtGender,EdtTxtTime,EdtTxtWeight,EdtTxtAge,EdtTxtHeight,EdtTxtLevelId;
    private DataBaseConnection vt;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.e("Profil","djkadhadadhahdhjahdhjasdhjahdghas");


        View v=inflater.inflate(R.layout.fragment_profile,container,false);

        EdtTxtNameLastName=v.findViewById(R.id.EdtTxtNameLastName);
        EdtTxtGender=v.findViewById(R.id.EdtTxtGender);
        EdtTxtTime=v.findViewById(R.id.EdtTxtTime);
        EdtTxtWeight=v.findViewById(R.id.EdtTxtWeight);
        EdtTxtAge=v.findViewById(R.id.EdtTxtAge);
        EdtTxtHeight=v.findViewById(R.id.EdtTxtHeight);
        EdtTxtLevelId=v.findViewById(R.id.EdtTxtLevelId);
        txtTopD=v.findViewById(R.id.txtTopD);
        txtTopT=v.findViewById(R.id.txtTopT);
        btnUpdate=v.findViewById(R.id.btnUpdate);


        vt=new DataBaseConnection(v.getContext());

        UserManager userManager=new UserManager(new SQLiteUserDao(vt));

        //userManager.Add(user);
        Log.e("baba laaa",String.valueOf(userManager.GetAll().size()));

        if (userManager.GetAll().size()>0) {
            ArrayList<User> userArrayList = new ArrayList<>();
            userArrayList = userManager.GetAll();
            int i = 0;
            for (User u : userArrayList) {

                if (i == 0) {


                    EdtTxtNameLastName.setText(u.getName()+" "+u.getLastName());
                    EdtTxtGender.setText(u.getCinsiyet());
                  //  EdtTxtTime.setText(u.getTime());
                    EdtTxtWeight.setText(String.valueOf(u.getWeight()));
                    EdtTxtAge.setText(String.valueOf(u.getAge()));
                   EdtTxtHeight.setText(String.valueOf(u.getHeight())+" Cm");

                   if (u.getLevelId()==1){
                       EdtTxtLevelId.setText("Başlangıç");
                   }
                   else if(u.getLevelId()==2){
                       EdtTxtLevelId.setText("Orta Düzey");
                   }
                   else if(u.getLevelId()==0){
                       EdtTxtLevelId.setText("Uzman");
                   }


                    txtTopD.setText(String.valueOf(u.getTime()));
                    txtTopT.setText(String.valueOf(u.getTime()*60));
                }
                i++;
            }
        }




        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user=new User();
                user.setName(String.valueOf(EdtTxtNameLastName.getText()));

                if (String.valueOf(EdtTxtGender.getText())=="Erkek"){user.setCinsiyet("Man");}
                else if(String.valueOf(EdtTxtGender.getText())=="Kadın"){user.setCinsiyet("Woman");}
                else{user.setCinsiyet("Null");}

                if (String.valueOf(EdtTxtLevelId.getText())=="Başlangıç"){user.setLevelId(1);}
                else if(String.valueOf(EdtTxtLevelId.getText())=="Orta Düzey"){user.setLevelId(2);}
                else{user.setLevelId(3);}

                user.setTime(Integer.parseInt(String.valueOf(EdtTxtTime.getText())));

                user.setWeight(Integer.parseInt(String.valueOf(EdtTxtWeight.getText())));
                user.setHeight(Integer.parseInt(String.valueOf(EdtTxtWeight.getText())));
                user.setAge(Integer.parseInt(String.valueOf(EdtTxtAge.getText())));


                userManager.Update(user);
            }
        });




        return v;
    }
}