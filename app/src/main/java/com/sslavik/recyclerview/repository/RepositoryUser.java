package com.sslavik.recyclerview.repository;

import com.sslavik.recyclerview.Model.UserModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Singleton que contiene el listado de usuarios contacots de nuestra app
 */
public class RepositoryUser  {

    // Eager Intialization Singleton
    private static volatile RepositoryUser sRepositoryUser = new RepositoryUser();
    private static List<UserModel> users;
    // Database Access Objects
        //private DAOMySQL;


    // NO SE PUEDE INSANCIAR DESDE FUERA
    private RepositoryUser(){
        users = new ArrayList<>();
        initialiceSampleDate();
    }

    public static RepositoryUser getInstance(){
        return sRepositoryUser;
    }

    /**
     * Método que inicializa la lista
     */
    private void initialiceSampleDate(){
        users.add(new UserModel("Lourdes RM", "moronlu18@gmail.com"));
        users.add(new UserModel("Vyacheslav S", "sslavikshy@gmail.com"));
        users.add(new UserModel("Guille VF", "guillevf@gmail.com"));
        users.add(new UserModel("Papaparapa", "ppp@gmail.com"));
        users.add(new UserModel("Perepeperepe", "ppp@gmail.com"));
        users.add(new UserModel("Tututurutu", "ttt@gmail.com"));
        users.add(new UserModel("Tarara. TARARA!", "ttt@gmail.com"));
        users.add(new UserModel("Jesus!", "Jesusito@gmail.com"));
        users.add(new UserModel("Enpajillao COn el Movih!", "Sebastian@gmail.com"));
        users.add(new UserModel("Adrian", "Adrian@gmail.com"));
        users.add(new UserModel("Sergio", "sergio@gmail.com"));
        users.add(new UserModel("Javier", "Javier@gmail.com"));
        users.add(new UserModel("Carlos", "Carlos@gmail.com"));
        users.add(new UserModel("CarlosDiabolico", "Carlos666@gmail.com"));
        users.add(new UserModel("Why we Still here... Just To SUFFER", "BRAH@gmail.com"));

    }

    /**
     * Devuelve los usuarios creados
     * @return List?UserModel instanciado y devuelto
     */
    public List<UserModel> getUsers(){
        return users;
    }

}
