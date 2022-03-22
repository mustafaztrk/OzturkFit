package com.example.projeone.Business.Concretes;

import android.util.Log;


import com.example.projeone.Business.Abstracts.IAkısService;
import com.example.projeone.DataAccess.Abstracts.IAkısDao;
import com.example.projeone.DataAccess.Abstracts.IPosesDao;
import com.example.projeone.Entities.Concretes.Akıs;
import com.example.projeone.Entities.Concretes.Poses;

import java.util.ArrayList;
import java.util.Random;

public class AkısManager implements IAkısService {
    IAkısDao _akısDao;
    IPosesDao _poses;

    private int temp=1;

    private int TopB;
    private int TopI;
    private int TopA;

    private double MaxB=0;
    private double MaxI=0;
    private double MaxA=0;


    public AkısManager(IAkısDao _akısDao, IPosesDao _poses) {
        this._akısDao = _akısDao;
        this._poses = _poses;
    }

    @Override
    public ArrayList<Akıs> GetAll() {
        return _akısDao.GetAll();
    }

    @Override
    public void Add(Akıs akıs) {

        _akısDao.Add(akıs);
    }

    @Override
    public void Delete(Akıs akıs) {
        _akısDao.Delete(akıs);
    }


    @Override
    public void Update(Akıs akıs) {

    }

    public ArrayList<Poses> GetPose(int userLevel, int Time){
        MaxCalculate(userLevel,Time);

        ArrayList<Poses> Akis=new ArrayList<>();
        ArrayList<Poses> pozlar=new ArrayList<>();
        pozlar=_poses.GetAll();


        ArrayList<Poses> Beginner= new ArrayList<>();
        ArrayList<Poses> İntermediate= new ArrayList<>();
        ArrayList<Poses> Advanced= new ArrayList<>();

        for (Poses p: pozlar){
            if (p.getLevelId()==1){Beginner.add(p);}
            if (p.getLevelId()==2){İntermediate.add(p);}
            if (p.getLevelId()==3){Advanced.add(p);}
        }

        int i=0;
        int l=userLevel;
        for (i = 0; i < Time; i++){

            if (i==0){
                Akis.add(Get_Pose(Beginner));
                temp=1;
            }
            else if(i>0&&i<Time-1){
               l=RndLevel(l);

               if (l==1){
                   Akis.add(Get_Pose(Beginner));
                   TopB++;
               }
               else if (l==2){
                   Akis.add(Get_Pose(İntermediate));
                    TopI++;
               }
               else {
                   Akis.add(Get_Pose(Advanced));
                   TopA++;
               }
            }
            else {
                Akis.add(Get_Pose(Beginner));
            }
        }

        for (Poses p: Akis){
            Log.e("Hareket adı",p.getNameIng());
        }
        return Akis;

    }

   private Poses Get_Pose(ArrayList<Poses> p){
      Random rnd=new Random();
      Poses pose=new Poses();

      int limit=rnd.nextInt(p.size());

       int i=0;
       for (Poses ps:p){
           if (i==limit){ pose=ps; break;}
           i++;
       }

        return pose;
    }

    private int RndLevel(int l){
        int level=l;
        Random rnd=new Random();
        if (l > 1) {
            if (l<3){
                if (rnd.nextBoolean()){

                    level++;
                    if (temp+1<level){level--;}
                }
                else {
                    level--;
                }
            }
            else {
                level--;
            }
        }
        else {
            level++;
        }


        if(TopB>MaxB){// Ad
            if (level==1){
                if (temp==2){
                    if (rnd.nextBoolean()){
                        level=3;
                    }
                    else {
                        level=2;
                    }
                }
                else if(temp==1){
                    level=2;
                }
                else {
                    if (rnd.nextBoolean()){
                        level=3;
                    }
                    else {
                        level=2;
                    }
                }

            }
        }
        if (TopI>=MaxI){
            if (level==2){

            }
        }

         if(TopA>=MaxA){//B
            if (level==3){
               if (temp==2){
                   if (rnd.nextBoolean()){
                       level=2;
                   }
                   else {
                       level=1;
                   }
               }
               else if(temp==3){
                   level=-1;
               }
               else{
                   if (rnd.nextBoolean()){
                       level=2;
                   }
                   else {
                       level=1;
                   }
               }

            }
        }




        temp=level;
        return level;
    }

    private void MaxCalculate(int levelId,int Time){
        if (levelId==1){
            MaxB=(Time*50)/100;
            MaxI=(Time*40)/100;
            MaxA=(Time*10)/100;
        }
        else if(levelId==2){
            MaxB=(Time*20)/100;
            MaxI=(Time*50)/100;
            MaxA=(Time*30)/100;
        }

        else if(levelId==3){
            MaxB=(Time*10)/100;
            MaxI=(Time*40)/100;
            MaxA=(Time*50)/100;
        }

    }
}
