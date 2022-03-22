package com.example.projeone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.projeone.Business.Concretes.AkısManager;
import com.example.projeone.Business.Concretes.MovementsManager;
import com.example.projeone.Business.Concretes.PosesManager;
import com.example.projeone.Business.Concretes.UserManager;
import com.example.projeone.DataAccess.Concretes.SQLite.DataBaseConnection;
import com.example.projeone.DataAccess.Concretes.SQLite.SQLiteAkısDao;
import com.example.projeone.DataAccess.Concretes.SQLite.SQLiteMovementsDao;
import com.example.projeone.DataAccess.Concretes.SQLite.SQLitePosesDao;
import com.example.projeone.DataAccess.Concretes.SQLite.SQLiteUserDao;
import com.example.projeone.Entities.Concretes.Movements;
import com.example.projeone.Entities.Concretes.Poses;
import com.example.projeone.Entities.Concretes.User;


import java.util.ArrayList;
import java.util.logging.Level;


public class MainActivity extends AppCompatActivity {
    private DataBaseConnection vt;

    public static String UserName=" ";
    public static String UserLastName=" ";
    public static int UserGender=0;
    public static String sporLevel=" ";
    public  static String sporAim=" ";
    public static  int sporTimeD=0;//günkük spor süresi
    public static int sporTimeW=0;
    public static String dailyDrink=" ";
    public static String dailySleep=" ";
    public static int height,age,weight=0;
    public static int[] UserDisanled=new int[6];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        User user=new User();
        user.setName("Mustafa");
        user.setLastName("ÖZTÜRK");
        user.setCinsiyet("Man");
        user.setTime(20);
        user.setWeight(100);
        user.setAge(21);
        user.setHeight(185);
        user.setLevelId(2);


      //Intent newIntent=new Intent(MainActivity.this,SportUser.class);

        vt=new DataBaseConnection(this);

        UserManager userManager=new UserManager(new SQLiteUserDao(vt));

        //userManager.Add(user);




        if (userManager.GetAll().size()>0){
            ArrayList<User> userArrayList=new ArrayList<>();
            userArrayList=userManager.GetAll();
            int i =0;
            for(User u:userArrayList){


                if(i==0){

                    UserName=u.getName();
                    UserLastName=u.getLastName();

                    if (u.getCinsiyet()=="Man"){UserGender=1;}
                    else if(u.getCinsiyet()=="Women"){UserGender=2;}
                    else{UserGender=0;}

                    if (u.getLevelId()==1){sporLevel="Beginner";}
                    else if(u.getLevelId()==2){sporLevel="Intermediate";}
                    else{sporLevel="Advanced";}

                    sporTimeD=u.getTime();
                    weight=u.getWeight();
                    age=u.getAge();
                    height=u.getHeight();



                }
                i++;
            }


          // startActivity(new Intent(MainActivity.this,Home.class));

           // finish();
        }
        else{
           // startActivity(new Intent(MainActivity.this,LoginScrenn.class));

            YogaDbWrite();
            FitnessDbWrite();

           // finish();
        }



    }
    void YogaDbWrite(){
        vt=new DataBaseConnection(this);



        PosesManager posesManager=new PosesManager(new SQLitePosesDao(vt));
        AkısManager akısManager=new AkısManager(new SQLiteAkısDao(vt),new SQLitePosesDao(vt));


        String [] NAME_EN={"Balancing Table Pose","Big Toe Pose","Bridge Pose","Butterfly Pose","Cat Pose","Chair Pose",
                "Chaturanga","Child’s Pose","Cobra Pose","Cow Pose","Dolphin Plank Pose","Downward-facing Dog","Easy Pose",
                "Extended Side Angle Pose","Fish Pose","Garland Pose","Half Lord of the Fishes Pose","Half Standing Forward Bend",
                "High Lunge","Mountain Pose","One-Legged Boat Pose","Palm Tree Pose (Upward Salute)","Plank Pose","Reverse Table Top Pose",
                "Sphinx Pose","Staff Pose","Standing Forward Bend","Table Pose","Triangle Pose","Upward-facing Dog","Archer Pose",
                "Bound Twisted Side Angle Pose","Bow Pose","Camel Pose","Compass Pose","Crane Pose","Crow Pose","Eagle Pose","Ear Pressure Pose",
                "Elephant Trunk Pose","Extended Hand-to-Big-Toe Pose","Full Boat Pose","Half Boat Pose","Half Lotus Pose","Half Reclined Hero",
                "Half-Moon Pose","Head To Knee Pose","Hero Pose","Heron Pose","Lizard Pose","Lord of the Dance Pose","Lotus Pose","Marichi’s Pose I",
                "Marichi’s Pose II","Marichi’s Pose III","Monkey Pose","One-Legged King Pigeon Pose","Pigeon Pose","Plow Pose","Reclining Hero Pose",
                "Reverse Warrior Pose","Scale Pose","Side Crow Pose","Side Plank Pose","Standing Split Pose","Supported Headstand Pose",
                "Supported Shoulder Stand","Tree pose","Twisted Chair Pose","Twisted Head-to-Knee Pose","Twisted Marichi’s Pose IV","Twisted Triangle Pose",
                "Revolved Side Angle Pose","Wheel Pose","Warrior I Pose","Warrior II Pose","Warrior III Pose","Wild Thing","Handstand Pose",
                "Rabbit Pose","Half Frog Pose","Frog Pose","Bharadvaja’s Twist","Bird of Paradise Pose","Eight Angle Pose","Feathered Peacock Pose",
                "Firefly Pose","Flying Pigeon Pose","Full Lord of the Fishes Pose","Little Thunderbolt Pose","One-Legged Crane Pose","One-Legged King Pigeon Pose II",
                "Peacock Pose","Sage Half Bound Lotus Pose","Sage Koundiya I Pose","Sage Koundiya II Pose","Scorpion Pose","Shoulder Pressing Pose",
                "Upward-facing Two-Footed Staff Pose","Legs Up The Wall Pose","Thunderbolt","Happy Baby","Wide Splits","Cow Face","Wide Legged Forward Bend",
                "Pyramid with Arms Extended","Seated Forward Bend","Wind Removing with Head Tucked","Corpse Pose","Locust Pose","Revolved Downward-Facing Dog","Revolved Child's",
                "Supine Spinal Twist","Revolved Wide Legged Forward Bend","Crescent Lunge Twist","Crescent Lunge on the Knee","Crescent Lunge Twist on the Knee",
                "Supine Bound Angle","Reclining Thread-the-Needle Pose","Goddess Pose","Front Corpse","Five Pointed Star","Eight Point",
                "Bound Side Angle","Revolved Bird of Paradise","Wide Child's","Dolphin","Seated Cat","Seated Cow","Plank with Knee to Tricep",
                "Plank with Knee to Tricep","Plank with Knee to Chest","Seated Twist","Three Legged Downward-Facing Dog","Three Legged Downward-Facing Dog with Hip Opener",
                "Extended Child's","Half Splits","Half Splits"};
        String [] NAME_LEVEL={"beginner","ıntermidiate","Intermediate","Advanced","Beginner","Beginner","Intermediate","Beginner",
                "Intermediate","Beginner","Intermediate","Beginner","Beginner","Intermediate","Advanced","Beginner","Advanced","Beginner",
                "Intermediate","Beginner","Intermediate","Beginner","Intermediate","Beginner","Beginner","Beginner","Beginner","Beginner",
                "Beginner","Intermediate","Intermediate","Advanced","Intermediate","Intermediate","Advanced","Intermediate","Intermediate",
                "Intermediate","Advanced","Advanced","Advanced","Intermediate","Intermediate","Beginner","Beginner","Intermediate","Intermediate",
                "Beginner","Beginner","Advanced","Intermediate","Advanced","Intermediate","Intermediate","Advanced","Intermediate","Advanced",
                "Advanced","Advanced","Intermediate","Intermediate","Intermediate","Advanced","Advanced","Intermediate","Intermediate",
                "Advanced","Intermediate","Intermediate","Intermediate","Intermediate","Advanced","Intermediate","Intermediate","Advanced",
                "Beginner","Beginner","Advanced","Intermediate","Advanced","Advanced","Intermediate","Intermediate","Intermediate",
                "Advanced","Advanced","Advanced","Advanced","Advanced","Advanced","Beginner","Advanced","Advanced","Advanced","Advanced",
                "Intermediate","Advanced","Advanced","Advanced","Advanced","Advanced","Beginner","Beginner","Beginner","Beginner","Advanced",
                "Intermediate","Intermediate","Beginner","Beginner","Intermediate","Intermediate","Beginner","Beginner","Intermediate",
                "Intermediate","Beginner","Beginner","Beginner","Beginner","Beginner","Beginner","Beginner","Intermediate","Advanced",
                "Advanced","Beginner","Beginner","Beginner","Beginner","Intermediate","Intermediate","Intermediate","Beginner","Beginner",
                "Beginner","Beginner","Intermediate","Advanced"};
        String [] NAME_SAN={"Utthita Cakravakasana","Padangusthasana","Setu Bandhasana","Baddha Konasana","Marjaryasana","Utkatasana",
                "Chaturanga Dandasana","Balasana","Bhujangasana","Bitilasana","Catur Svanasana","Adho Mukha Svanasana","Sukhasana",
                "Utthita Parsvakonasana","Matsyasana","Malasana","Ardha Matsyendrasana","Ardha Uttanasana","Utthita Ashwa Sanchalanasana",
                "Tadasana","Ekapada Navasana","Urdhva Hastasana","Phalakasana","Ardha Purvottanasana","Salamba Bhujangasana","Dandasana",
                "Uttanasana","Bharmanasana","Utthita Trikonasana","Urdhva Mukha Svanasana","Akarna Dhanurasana","Baddha Parivrtta Parsvakonasana",
                "Dhanurasana","Ustrasana","Parivrtta Surya Yantrasana","Bakasana","Kakasana","Garudasana","Karnapidasana","Eka Hasta Bhujasana",
                "Utthita Hasta Padangusthasana","Navasana","Ardha Navasana","Ardha Padmasana","Ardha Supta Virasana","Ardha Chandrasana",
                "Janu Sirsasana","Virasana","Krounchasana","Utthan Pristhasana","Natarajasana","Padmasana","Marichyasana 1","Marichyasana 2",
                "Marichyasana 3","Hanumanasana","Eka Pada Rajakapotasana","Kapotasana","Halasana","Supta Virasana","Parsva Virabhadrasana",
                "Tolasana","Parsva Bakasana","Vasisthasana","Urdhva Prasarita Eka Padasana","Salamba Sirsasana","Salamba Sarvangasana",
                "Vrksasana","Parivrtta Utkatasana","Parivrtta Janu Sirsasana","Marichyasana 4","Parivrtta Trikonasana","Parivrtta Parsvakonasana",
                "Urdhva Dhanurasana","Virabhadrasana 1","Virabhadrasana 2","Virabhadrasana 3","Camatkarasana","Adho Mukha Vrksasana",
                "Sasangasana","Ardha Bhekasana","Bhekasana","Bharadvajasana","Svarga Dvidasana","Astavakrasana","Pincha Mayurasana",
                "Tittibhasana","Eka Pada Galavasana","Purna Matsyendrasana","Laghu Vajrasana","Eka Pada Bakasana","Eka Pada Rajakapotasana II",
                "Mayurasana","Kasyapasana","Eka Pada Koundiyanasana I","Eka Pada Koundiyanasana II","Vrschikasana","Bhujapidasana","Dwi Pada Viparita Dandasana",
                "Viparita Karani","Vajrasana","Ananda Balasana","Upavistha Konasana","Gomukhasana","Prasarita Padottanasana","Parsvottanasana",
                "Paschimottanasana","Apanasana","Savasana","Salabhasana","Parivrtta Adho Mukha Svanasana","Succhirandrasana","Jathara Parivartanasana",
                "Parivrtta Prasarita Padottanasana","Parivrtta Utthita Ashwa Sanchalasana","Anjaneyasana","Parivrtta Anjaneyasana","Supta Baddha Konasana",
                "Supta Succhirandrasana","Utkata Konasana","Advasana","Five Pointed Star","Ashtangasana","Baddha Utthita Parsvakonasana",
                "Parivrtta Svarga Dvidasana","Utthita Balasana 2","Ardha Pincha Mayurasana","Marjaryasana 2","Bitilasana 2","Phalakasana 2",
                "Phalakasana 3","Phalakasana 4","Parivrtta Sukhasana","Adho Mukha Svanasana 2","Adho Mukha Svanasana 3","Utthita Balasana",
                "Ardha Hanumanasana","Pasasana"};




        int i=0;
        Poses pose;
        posesManager=new PosesManager(new SQLitePosesDao(vt));
        while (i<138){
            pose=new Poses();
            pose.setNameIng(NAME_EN[i]);
            pose.setNameSnk(NAME_SAN[i]);
            String lvl= NAME_LEVEL[i];
            if (lvl=="beginner"||lvl=="Beginner"){pose.setLevelId(1);}
            else if(lvl=="Intermediate"||lvl=="intermediate"){pose.setLevelId(2);}
            else if(lvl=="Advanced"||lvl=="advanced"){pose.setLevelId(3);}
            else{pose.setLevelId(4);}

            posesManager.Add(pose);
            i=i+1;
        }

        vt=new DataBaseConnection(this);
    }

    void FitnessDbWrite(){
        vt=new DataBaseConnection(this);


        MovementsManager movementsManager=new MovementsManager(new SQLiteMovementsDao(vt));

        Movements sinav= new Movements();
        sinav.setName("Şınav");
        sinav.setLevelId(1);
        sinav.setArea("gögüs");
        movementsManager.Add(sinav);

        Movements atlamaKriko= new Movements();
        atlamaKriko.setName("Atlama Krikolar");
        atlamaKriko.setLevelId(1);
        atlamaKriko.setArea("gögüs");
        movementsManager.Add(atlamaKriko);

        Movements kobraGerinmesi= new Movements();
        kobraGerinmesi.setName("Kobra Gerinmesi");
        kobraGerinmesi.setLevelId(1);
        kobraGerinmesi.setArea("gögüs");
        movementsManager.Add(kobraGerinmesi);


        Movements dizdenSinav= new Movements();
        dizdenSinav.setName("Dizden Şınav");
        dizdenSinav.setLevelId(1);
        dizdenSinav.setArea("gögüs");
        movementsManager.Add(dizdenSinav);


        Movements hintliŞınav= new Movements();
        hintliŞınav.setName("Hintli Şınav");
        hintliŞınav.setLevelId(1);
        hintliŞınav.setArea("gögüs");
        movementsManager.Add(hintliŞınav);




        Movements omuzGerme= new Movements();
        omuzGerme.setName("Omuz Germe");
        omuzGerme.setLevelId(2);
        omuzGerme.setArea("gögüs");
        movementsManager.Add(omuzGerme);



        Movements yamukŞınav= new Movements();
        yamukŞınav.setName("Yamuk Şınav");
        yamukŞınav.setLevelId(2);
        yamukŞınav.setArea("gögüs");
        movementsManager.Add(yamukŞınav);


        Movements declineŞınav= new Movements();
        declineŞınav.setName("Decline Şınav");
        declineŞınav.setLevelId(2);
        declineŞınav.setArea("gögüs");
        movementsManager.Add(declineŞınav);


        Movements şinav= new Movements();
        şinav.setName("Şınav");
        şinav.setLevelId(2);
        şinav.setArea("gögüs");
        movementsManager.Add(şinav);


        Movements dizdenŞınav= new Movements();
        dizdenŞınav.setName("Dizden Şınav");
        dizdenŞınav.setLevelId(2);
        dizdenŞınav.setArea("gögüs");
        movementsManager.Add(dizdenŞınav);




        Movements kolDöndürme= new Movements();
        kolDöndürme.setName("Kol Döndürme");
        kolDöndürme.setLevelId(3);
        kolDöndürme.setArea("gögüs");
        movementsManager.Add(kolDöndürme);


        Movements burpee= new Movements();
        burpee.setName("Burpee");
        burpee.setLevelId(3);
        burpee.setArea("gögüs");
        movementsManager.Add(burpee);


        Movements spidermanŞınav= new Movements();
        spidermanŞınav.setName("Spiderman Şınav");
        spidermanŞınav.setLevelId(3);
        spidermanŞınav.setArea("gögüs");
        movementsManager.Add(spidermanŞınav);


        Movements OmuzGerme= new Movements();
        OmuzGerme.setName("Omuz Germe");
        OmuzGerme.setLevelId(3);
        OmuzGerme.setArea("gögüs");
        movementsManager.Add(OmuzGerme);


        Movements DeclineŞınav= new Movements();
        DeclineŞınav.setName("Decline Şınav");
        DeclineŞınav.setLevelId(3);
        DeclineŞınav.setArea("gögüs");
        movementsManager.Add(DeclineŞınav);





//karın


        Movements rusBüküm= new Movements();
        rusBüküm.setName("Rus Büküm");
        rusBüküm.setLevelId(1);
        rusBüküm.setArea("karın");
        movementsManager.Add(rusBüküm);


        Movements dağTırmanıcı= new Movements();
        dağTırmanıcı.setName("Dağ Tırmanıcı");
        dağTırmanıcı.setLevelId(1);
        dağTırmanıcı.setArea("karın");
        movementsManager.Add(dağTırmanıcı);


        Movements plank= new Movements();
        plank.setName("Plank");
        plank.setLevelId(1);
        plank.setArea("karın");
        movementsManager.Add(plank);


        Movements TopuğaDokunma= new Movements();
        TopuğaDokunma.setName("Topuğa Dokunma");
        TopuğaDokunma.setLevelId(1);
        TopuğaDokunma.setArea("karın");
        movementsManager.Add(TopuğaDokunma);


        Movements KobraGerinmesi= new Movements();
        KobraGerinmesi.setName("Kobra Gerinmesi");
        KobraGerinmesi.setLevelId(1);
        KobraGerinmesi.setArea("karın");
        movementsManager.Add(KobraGerinmesi);

        Movements yanKöprü= new Movements();
        yanKöprü.setName("Yan Köprü");
        yanKöprü.setLevelId(2);
        yanKöprü.setArea("karın");
        movementsManager.Add(yanKöprü);

        Movements bisikletCrunch= new Movements();
        bisikletCrunch.setName("Bisiklet Crunch");
        bisikletCrunch.setLevelId(2);
        bisikletCrunch.setArea("karın");
        movementsManager.Add(bisikletCrunch);


        Movements bacakKaldırma= new Movements();
        bacakKaldırma.setName("Bacak Kaldırma");
        bacakKaldırma.setLevelId(2);
        bacakKaldırma.setArea("karın");
        movementsManager.Add(bacakKaldırma);


        Movements YanaPlank= new Movements();
        YanaPlank.setName("Yana Plank");
        YanaPlank.setLevelId(2);
        YanaPlank.setArea("karın");
        movementsManager.Add(YanaPlank);


        Movements topuğaDokunma= new Movements();
        topuğaDokunma.setName("Topuğa Dokunma");
        topuğaDokunma.setLevelId(2);
        topuğaDokunma.setArea("karın");
        movementsManager.Add(topuğaDokunma);



        Movements Mekik= new Movements();
        Mekik.setName("Mekik");
        Mekik.setLevelId(3);
        Mekik.setArea("karın");
        movementsManager.Add(Mekik);

        Movements RusBüküm= new Movements();
        RusBüküm.setName("Rus Büküm");
        RusBüküm.setLevelId(3);
        RusBüküm.setArea("karın");
        movementsManager.Add(RusBüküm);


        Movements BisikletCrunch= new Movements();
        BisikletCrunch.setName("Bisiklet Crunch");
        BisikletCrunch.setLevelId(3);
        BisikletCrunch.setArea("karın");
        movementsManager.Add(BisikletCrunch);


        Movements DağTırmanıcı= new Movements();
        DağTırmanıcı.setName("Dağ Tırmanıcı");
        DağTırmanıcı.setLevelId(3);
        DağTırmanıcı.setArea("karın");
        movementsManager.Add(DağTırmanıcı);

        Movements YanKöprü= new Movements();
        YanKöprü.setName("Yan Köprü");
        YanKöprü.setLevelId(3);
        YanKöprü.setArea("karın");
        movementsManager.Add(YanKöprü);

//KOL

        Movements yumrukAtma= new Movements();
        yumrukAtma.setName("yumruk Atma");
        yumrukAtma.setLevelId(1);
        yumrukAtma.setArea("kol");
        movementsManager.Add(yumrukAtma);

        Movements DuvardaŞınav= new Movements();
        DuvardaŞınav.setName("Duvarda Şınav");
        DuvardaŞınav.setLevelId(1);
        DuvardaŞınav.setArea("kol");
        movementsManager.Add(DuvardaŞınav);


        Movements karoŞınav= new Movements();
        karoŞınav.setName("Karo Şınav");
        karoŞınav.setLevelId(1);
        karoŞınav.setArea("kol");
        movementsManager.Add(karoŞınav);


        Movements kollarıYukarıAçma= new Movements();
        kollarıYukarıAçma.setName("kolları Yukarı Açma");
        kollarıYukarıAçma.setLevelId(1);
        kollarıYukarıAçma.setArea("kol");
        movementsManager.Add(kollarıYukarıAçma);

        Movements gögüsPresi= new Movements();
        gögüsPresi.setName("gögüs Presi");
        gögüsPresi.setLevelId(1);
        gögüsPresi.setArea("kol");
        movementsManager.Add(gögüsPresi);


        Movements YuvarlakÇizme= new Movements();
        YuvarlakÇizme.setName("Yuvarlak Çizme");
        YuvarlakÇizme.setLevelId(2);
        YuvarlakÇizme.setArea("kol");
        movementsManager.Add(YuvarlakÇizme);

        Movements tripseps= new Movements();
        tripseps.setName("Tripseps");
        tripseps.setLevelId(2);
        tripseps.setArea("kol");
        movementsManager.Add(tripseps);

        Movements ipleAtlama= new Movements();
        ipleAtlama.setName("İple Atlama");
        ipleAtlama.setLevelId(2);
        ipleAtlama.setArea("kol");
        movementsManager.Add(ipleAtlama);

        Movements kolMakası= new Movements();
        kolMakası.setName("Kol Makası");
        kolMakası.setLevelId(2);
        kolMakası.setArea("kol");
        movementsManager.Add(kolMakası);

        Movements Burpee= new Movements();
        Burpee.setName("Burpee");
        Burpee.setLevelId(2);
        Burpee.setArea("kol");
        movementsManager.Add(Burpee);



        Movements yuvarlakÇizme= new Movements();
        yuvarlakÇizme.setName("Yuvarlak Çizme");
        yuvarlakÇizme.setLevelId(3);
        yuvarlakÇizme.setArea("kol");
        movementsManager.Add(yuvarlakÇizme);

        Movements GögüsPresi= new Movements();
        GögüsPresi.setName("GögüsPresi");
        GögüsPresi.setLevelId(3);
        GögüsPresi.setArea("kol");
        movementsManager.Add(GögüsPresi);

        Movements kolBükmeliEzme= new Movements(); //no foto
        kolBükmeliEzme.setName("kol BükmeliEzme");
        kolBükmeliEzme.setLevelId(3);
        kolBükmeliEzme.setArea("kol");
        movementsManager.Add(kolBükmeliEzme);

        Movements AskeriŞınav= new Movements();//no foto
        AskeriŞınav.setName("Askeri Şınav");
        AskeriŞınav.setLevelId(3);
        AskeriŞınav.setArea("kol");
        movementsManager.Add(AskeriŞınav);


        Movements OmuzTimsahı= new Movements();//no foto
        OmuzTimsahı.setName("OmuzTimsahı");
        OmuzTimsahı.setLevelId(3);
        OmuzTimsahı.setArea("kol");
        movementsManager.Add(OmuzTimsahı);

//bacak

        Movements Çömelme= new Movements();
        Çömelme.setName("Çömelme");
        Çömelme.setLevelId(1);
        Çömelme.setArea("bacak");
        movementsManager.Add(Çömelme);

        Movements BacakAçma= new Movements();
        BacakAçma.setName("Bacak Açma");
        BacakAçma.setLevelId(1);
        BacakAçma.setArea("bacak");
        movementsManager.Add(BacakAçma);

        Movements yanaAtlama= new Movements();
        yanaAtlama.setName("yana Atlama");
        yanaAtlama.setLevelId(1);
        yanaAtlama.setArea("bacak");
        movementsManager.Add(yanaAtlama);

        Movements kalçadanTekme= new Movements();
        kalçadanTekme.setName("kalçadan Tekme");
        kalçadanTekme.setLevelId(1);
        kalçadanTekme.setArea("bacak");
        movementsManager.Add(kalçadanTekme);

        Movements ileriHamle= new Movements();
        ileriHamle.setName("ileri Hamle");
        ileriHamle.setLevelId(1);
        ileriHamle.setArea("bacak");
        movementsManager.Add(ileriHamle);



        Movements tersKelebekDuruşu= new Movements();
        tersKelebekDuruşu.setName("ters Kelebek Duruşu");
        tersKelebekDuruşu.setLevelId(2);
        tersKelebekDuruşu.setArea("bacak");
        movementsManager.Add(tersKelebekDuruşu);

        Movements baldırSekme= new Movements();
        baldırSekme.setName("baldır Sekme");
        baldırSekme.setLevelId(2);
        baldırSekme.setArea("bacak");
        movementsManager.Add(baldırSekme);


        Movements baldırKaldırma= new Movements();
        baldırKaldırma.setName("baldır Kaldırma");
        baldırKaldırma.setLevelId(2);
        baldırKaldırma.setArea("bacak");
        movementsManager.Add(baldırKaldırma);


        Movements solBaldırGerme= new Movements();
        solBaldırGerme.setName("sol Baldır Germe");
        solBaldırGerme.setLevelId(2);
        solBaldırGerme.setArea("bacak");
        movementsManager.Add(solBaldırGerme);


        Movements sağBaldırGerme= new Movements();
        sağBaldırGerme.setName("sağBaldırGerme");
        sağBaldırGerme.setLevelId(2);
        sağBaldırGerme.setArea("bacak");
        movementsManager.Add(sağBaldırGerme);



        Movements burpe= new Movements();
        burpe.setName("Burpee");
        burpe.setLevelId(3);
        burpe.setArea("bacak");
        movementsManager.Add(burpe);


        Movements altBacaKaldırma= new Movements();
        altBacaKaldırma.setName("alt Bacak Kaldırma");
        altBacaKaldırma.setLevelId(3);
        altBacaKaldırma.setArea("bacak");
        movementsManager.Add(altBacaKaldırma);

        Movements reverans= new Movements();
        reverans.setName("Reverans Hamle");
        reverans.setLevelId(3);
        reverans.setArea("bacak");
        movementsManager.Add(reverans);

        Movements KalçadanTekme= new Movements();
        KalçadanTekme.setName("Kalçadan Tekme");
        KalçadanTekme.setLevelId(3);
        KalçadanTekme.setArea("bacak");
        movementsManager.Add(KalçadanTekme);

        Movements germeKaldırma= new Movements();
        germeKaldırma.setName("Germe Kaldırma");
        germeKaldırma.setLevelId(3);
        germeKaldırma.setArea("bacak");
        movementsManager.Add(germeKaldırma);




        //omuz ve sırt

        Movements atlamaKrikolar= new Movements();
        atlamaKrikolar.setName("atlama Krikolar");
        atlamaKrikolar.setLevelId(1);
        atlamaKrikolar.setArea("omuz ve sırt");
        movementsManager.Add(atlamaKrikolar);

        Movements dizdensinav= new Movements();
        dizdensinav.setName("dizden sinav");
        dizdensinav.setLevelId(1);
        dizdensinav.setArea("omuz ve sırt");
        movementsManager.Add(dizdensinav);


        Movements KolMakası= new Movements();
        KolMakası.setName("Kol Makası");
        KolMakası.setLevelId(1);
        KolMakası.setArea("omuz ve sırt");
        movementsManager.Add(KolMakası);


        Movements KolKaldırma= new Movements();
        KolKaldırma.setName("Kol Kaldırma");
        KolKaldırma.setLevelId(1);
        KolKaldırma.setArea("kol");
        movementsManager.Add(KolKaldırma);


        Movements yerdeGerinme= new Movements();
        yerdeGerinme.setName("yerde Gerinme");
        yerdeGerinme.setLevelId(1);
        yerdeGerinme.setArea("omuz ve sırt");
        movementsManager.Add(yerdeGerinme);



        Movements sumoEğilmesi= new Movements();
        sumoEğilmesi.setName("Sumo Eğilmesi ");
        sumoEğilmesi.setLevelId(2);
        sumoEğilmesi.setArea("omuz ve sırt");
        movementsManager.Add(sumoEğilmesi);


        Movements tersKelebekD= new Movements();
        tersKelebekD.setName("Ters Kelebek Duruşu");
        tersKelebekD.setLevelId(2);
        tersKelebekD.setArea("omuz ve sırt");
        movementsManager.Add(tersKelebekD);


        Movements DuvardaGerdirme= new Movements();
        DuvardaGerdirme.setName("Duvarda Gerdirme");
        DuvardaGerdirme.setLevelId(2);
        DuvardaGerdirme.setArea("omuz ve sırt");
        movementsManager.Add(DuvardaGerdirme);


        Movements tekBacakSekme= new Movements();
        tekBacakSekme.setName("tek Bacak Sekme");
        tekBacakSekme.setLevelId(2);
        tekBacakSekme.setArea("omuz ve sırt");
        movementsManager.Add(tekBacakSekme);


        Movements BaldırGerme= new Movements();
        BaldırGerme.setName("BaldırGerme");
        BaldırGerme.setLevelId(2);
        BaldırGerme.setArea("omuz ve sırt");
        movementsManager.Add(BaldırGerme);




        Movements SırtÜstüŞınav= new Movements();
        SırtÜstüŞınav.setName("Sırt Üstü Şınav");
        SırtÜstüŞınav.setLevelId(3);
        SırtÜstüŞınav.setArea("omuz ve sırt");
        movementsManager.Add(SırtÜstüŞınav);


        Movements tersŞınav= new Movements();
        tersŞınav.setName("Ters Şınav");
        tersŞınav.setLevelId(3);
        tersŞınav.setArea("omuz ve sırt");
        movementsManager.Add(tersŞınav);


        Movements tırtılEgzersiz= new Movements();
        tırtılEgzersiz.setName("Tırtıl Egzersiz");
        tırtılEgzersiz.setLevelId(3);
        tırtılEgzersiz.setArea("omuz ve sırt");
        movementsManager.Add(tırtılEgzersiz);


        Movements pikeŞınavı= new Movements();
        pikeŞınavı.setName("Pike Şınavı");
        pikeŞınavı.setLevelId(3);
        pikeŞınavı.setArea("omuz ve sırt");
        movementsManager.Add(pikeŞınavı);


        Movements hiperUzanma= new Movements();
        hiperUzanma.setName("Hiper Uzanma");
        hiperUzanma.setLevelId(3);
        hiperUzanma.setArea("omuz ve sırt");
        movementsManager.Add(hiperUzanma);
    }


}