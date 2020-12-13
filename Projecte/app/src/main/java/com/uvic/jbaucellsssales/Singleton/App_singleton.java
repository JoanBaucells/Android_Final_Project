package com.uvic.jbaucellsssales.Singleton;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.uvic.jbaucellsssales.Entitats.Competidor;
import com.uvic.jbaucellsssales.Entitats.Competition;
import com.uvic.jbaucellsssales.Entitats.User;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class App_singleton {
    private static final String USERS_FILE = "users.json";
    private static final String COMPETITOR_FILE = "competitor.json";
    private static final String USER_FILE = "user.json";
    private static final String COMPETITION_FILE = "competition.json";
    private Context context;
    private ArrayList<User> list_users;
    private ArrayList<Competidor> list_competidors;
    private ArrayList<Competition> list_competition;
    private User user;
    private String sError;


    private static class SingletonInstance {
        private static App_singleton INSTANCE = new App_singleton();
    }
    public static App_singleton getInstance() {
        return SingletonInstance.INSTANCE;
    }
    private App_singleton() {
        this.list_users = new ArrayList<User>();
        this.list_competidors = new ArrayList<Competidor>();
        this.list_competition = new ArrayList<Competition>();
        this.user = new User();
    }

    public void setContext(Context c){
        this.context = c;
        sync();
        Create_Admin();
    }

    private void sync(){
        StringBuilder sb;
        Type typeList = new TypeToken<List<User>>() {}.getType();
        Gson gson = new Gson();
        //
        sb = getFile(USER_FILE);
        if(!sb.toString().equals(""))
            this.user = gson.fromJson(sb.toString() ,User.class);
        else
            this.user = new User();
        sb = getFile(USERS_FILE);
        if(!sb.toString().equals("")) this.list_users = gson.fromJson(sb.toString(), typeList);
        sb = getFile(COMPETITOR_FILE);
        typeList = new TypeToken<List<Competidor>>() {}.getType();
        if(!sb.toString().equals("")) this.list_competidors = gson.fromJson(sb.toString(), typeList);
        sb = getFile(COMPETITION_FILE);
        typeList = new TypeToken<List<Competition>>() {}.getType();
        if(!sb.toString().equals("")) this.list_competition = gson.fromJson(sb.toString(), typeList);
    }

    public String getsError() {
        return sError;
    }

    private void Create_Admin(){
        if (list_users.size() == 0){
            User u = new User("Admin123","12345aA","Admin");
            addUser(u);
            getFile(USERS_FILE);
        }
    }

    // FILE FUNCTIONS
    private void setFile(String data, String sFile){
        FileOutputStream fOut = null;
        try {
            fOut = context.openFileOutput(sFile, Context.MODE_PRIVATE);
            fOut.write(data.getBytes());
            fOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private StringBuilder getFile(String sFile){
        FileInputStream fin = null;
        String receiveString;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            fin = context.openFileInput(sFile);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fin, "UTF-8"), 1024);
            while ((receiveString = bufferedReader.readLine()) != null) {
                stringBuilder.append(receiveString);
            }
            fin.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return stringBuilder;
    }

    // FUNCIONES SETTERS GETTERS
    public ArrayList<User> getList_users() {
        return this.list_users;
    }
    public void setList_users(ArrayList<User> list_users) {
        this.list_users = list_users;
        setFile(new Gson().toJson(this.list_users), USERS_FILE);
    }
    public void addUser(User u){
            this.list_users.add(u);
            setFile(new Gson().toJson(this.list_users), USERS_FILE);
    }
    public  ArrayList<Competidor> getList_competidors(){ return this.list_competidors; }
    public void setList_competidors(ArrayList<Competidor> list_competidors){
        this.list_competidors = list_competidors;
        setFile(new Gson().toJson(this.list_competidors), COMPETITOR_FILE);
    }
    public void addCompetidor(Competidor c){
        this.list_competidors.add(c);
        setFile(new Gson().toJson(this.list_competidors), COMPETITOR_FILE);
    }
    public User getUser(){ return this.user; }
    public void setUser(User u){
        this.user = u;
        setFile(new Gson().toJson(this.user), USER_FILE);
    }
    public String getUser_Rol(String username){
        String sRol = "";
        //
        for (User u: this.list_users) {
            if(u.getUsername().equals(username)){
                sRol = u.getRol();
            }
        }
        //
        return sRol;
    }

    public ArrayList<Competition> getList_competition() {
        return list_competition;
    }
    public void setList_competition(ArrayList<Competition> list_competition) {
        this.list_competition = list_competition;
        setFile(new Gson().toJson(this.list_competition), COMPETITION_FILE);
    }
    public void addCompetition(Competition c){
        this.list_competition.add(c);
        setFile(new Gson().toJson(this.list_competition), COMPETITION_FILE);
    }

    public int getNewIdCompetition(){
        return (this.list_competition.size() + 1);
    }
}