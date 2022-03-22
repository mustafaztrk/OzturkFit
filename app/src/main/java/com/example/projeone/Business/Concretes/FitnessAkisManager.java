package com.example.projeone.Business.Concretes;

import android.util.Log;

import com.example.projeone.Business.Abstracts.IFitnessAkisService;
import com.example.projeone.DataAccess.Abstracts.IMovementsDao;
import com.example.projeone.Entities.Concretes.Movements;


import java.util.ArrayList;
import java.util.Random;

public class FitnessAkisManager implements IFitnessAkisService {
    IMovementsDao _movementsDao;





    private int temp=1;

    private int TopB;
    private int TopI;
    private int TopA;

    private double MaxB=0;
    private double MaxI=0;
    private double MaxA=0;


    public FitnessAkisManager(IMovementsDao _movementsDao) {
        this._movementsDao = _movementsDao;
    }

    @Override
    public ArrayList<Movements> GetAll() {
        return _movementsDao.GetAll();
    }

    @Override
    public void Add(Movements movements) {
        _movementsDao.Add(movements);
    }



    public ArrayList<Movements> GetPose(int userLevel, int Time){
        MaxCalculate(userLevel,Time);

        ArrayList<Movements> Akis=new ArrayList<>();
        ArrayList<Movements> pozlar=new ArrayList<>();
        pozlar=_movementsDao.GetAll();


        ArrayList<Movements> Beginner= new ArrayList<>();
        ArrayList<Movements> İntermediate= new ArrayList<>();
        ArrayList<Movements> Advanced= new ArrayList<>();

        for (Movements m: pozlar){
            if (m.getLevelId()==1){Beginner.add(m);}
            if (m.getLevelId()==2){İntermediate.add(m);}
            if (m.getLevelId()==3){Advanced.add(m);}
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

        for (Movements p: Akis){
            Log.e("Hareket adı",p.getName());
        }
        return Akis;

    }


    private Movements Get_Pose(ArrayList<Movements> m){
        Random rnd=new Random();
        Movements movements=new Movements();

        int limit=rnd.nextInt(m.size());

        int i=0;
        for (Movements mv:m){
            if (i==limit){ movements=mv; break;}
            i++;
        }

        return movements;
    }

    public ArrayList<Movements> Get_Area(int level,int time,String Area){
        ArrayList<Movements> movementsArrayList=new ArrayList<>();
        movementsArrayList=_movementsDao.GetAll();
        String bölge="";


        ArrayList<Movements> fhsList=new ArrayList<>();
        ArrayList<Movements> movementsLevel=new ArrayList<>();
        ArrayList<Movements> AreaList=new ArrayList<>();

        for (Movements m:movementsArrayList){
            if (m.getLevelId()==level ){
                movementsLevel.add(m);
                Log.e("Art lsşt",m.getName());

            }
        }
        Log.e("Art lsşt",Area);
        Log.e("Movements lsşt",String.valueOf(movementsLevel.size()));
        for (Movements m:movementsLevel){
            if (m.getArea().equals(Area)){
                AreaList.add(m);
                Log.e("Art dasdadadas",m.getArea());
            }
        }

        int j=0;
        Random r=new Random();
        for (Movements m:AreaList){
            fhsList.add(AreaList.get(r.nextInt(time)));
        }

        return fhsList;
    }


    public  ArrayList<Movements> Get_Full(int userLevel, int timee){


        ArrayList<Movements> movementList=new ArrayList<>();
        movementList=_movementsDao.GetAll();

        ArrayList<Movements> AreaLevel=new ArrayList<>();

        ArrayList<Movements>AreaList=new ArrayList<>();

        for (Movements m: movementList){
            if (m.getLevelId()==userLevel ){
               AreaLevel.add(m);

            }
        }

        int i=0;
        int j=0;
        Random r=new Random();
        for (Movements mv:AreaLevel){

            if (i<timee){
                AreaList.add(AreaLevel.get(r.nextInt(timee)));
            }
            i++;
        }
        if (AreaList.size()<timee){
            int s=AreaList.size()-timee;
            int k=0;
            while (s<k){

                AreaList.add(AreaLevel.get(r.nextInt(timee)));
                s++;
            }
        }
        Log.e("sdsd",String.valueOf(AreaList.size()));
        return AreaList;
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
