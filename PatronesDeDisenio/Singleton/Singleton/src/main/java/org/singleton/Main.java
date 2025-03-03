package org.singleton;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

            DataBaseConnector dataBaseConnector = DataBaseConnector.getInstance();

            System.out.println("dataBaseConnector = " + dataBaseConnector);

            DataBaseConnector dataBaseConnector2 = DataBaseConnector.getInstance();

            System.out.println("dataBaseConnector2 = " + dataBaseConnector2);

            dataBaseConnector.DatabaseConnect();
            dataBaseConnector2.DatabaseConnect();

        }
    }