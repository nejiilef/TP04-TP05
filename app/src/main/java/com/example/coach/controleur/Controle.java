package com.example.coach.controleur;

import android.content.Context;
import android.service.controls.Control;

import com.example.coach.modele.AccesLocal;
import com.example.coach.modele.Profil;
import com.example.coach.outils.Serializer;

import java.util.Date;

public final class Controle {

    private static Controle instance=null;
    private static Profil profil;
    private static String nomFic = "saveprofil";
    private static AccesLocal accesLocale;

    private Controle(){
        super();
    }

    /**
     * Création d'une instance
     * @return
     */
    public static final Controle getInstance(Context contexte){
        if(Controle.instance==null){
            Controle.instance=new Controle();
            accesLocale = new AccesLocal(contexte);
            profil = accesLocale.recupDernier();
            //recupSerializ(contexte);
        }
        return Controle.instance;
    }

    /**
     *
     * @param poids
     * @param taille en cm
     * @param age
     * @param sexe 1=H & 0=F
     */
    public void CreateProfil(Integer poids, Integer taille, Integer age, Integer sexe, Context contexte){
        profil=new Profil(new Date(),poids,taille,age,sexe);
        //Serializer.serialize(nomFic,profil,contexte);
        accesLocale.ajout(profil);

    }


    public float getImg(){
        return profil.getImg();
    }

    public String getMsg(){
        return profil.getMessage();
    }
    /**Récuperation de l'objet sérialisé (le profil)*/
    private static void recupSerializ(Context contexte){
        profil = (Profil) Serializer.deSerialize(nomFic,contexte);
    }

    public Integer getPoids(){
        if(profil == null){
            return null;
        }else {
            return profil.getPoids();
        }
    }

    public Integer getTaille() {
        if (profil == null) {
            return null;
        } else {
            return profil.getTaille();
        }
    }
    public Integer getAge(){
        if(profil == null){
            return null;
        }else {

            return profil.getAge();
        }
    }

    public Integer getSexe(){
        if(profil == null){
            return null;
        }else {
            return profil.getSexe();
        }

    }
}
