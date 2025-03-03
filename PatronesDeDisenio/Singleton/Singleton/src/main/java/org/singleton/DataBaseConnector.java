package org.singleton;

public class DataBaseConnector {

    private static DataBaseConnector instance;

    private DataBaseConnector(){
        System.out.println("Create Objetc");
    }

    public static synchronized DataBaseConnector getInstance(){

        if(instance == null){
            instance = new DataBaseConnector();
        }

        return instance;
    }

    public void DatabaseConnect(){
        System.out.println("Connect to DB: " + instance);
    }

    public void disConnectDataBase(){
        System.out.println("Disconnecting to DB: " + instance);
    }
}
