package com.ariel.oop;

import java.sql.*;

/**
 * @author sqlitetutorial.net
 */
public class Main {
    /**
     * Connect to a sample database
     */
    public static Connection connect(String db_name) {
        Connection conn = null;
        try {
            // db parameters
            db_name = db_name.endsWith(".db") ? db_name : db_name + ".db";
            String url = "jdbc:sqlite:sqlite/db/" + db_name;
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return conn;
    }

    /**
     * Connect to a sample database
     *
     * @param sql_conn the database file name
     */
    public static void createNewDatabase(Connection sql_conn) {
        try {
            if (sql_conn != null) {
                DatabaseMetaData meta = null;
                meta = sql_conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createNewTable(Connection sql_conn) {
        String sql = "CREATE TABLE IF NOT EXISTS ships(\n"
                + "    id integer PRIMARY KEY,\n"
                + "    name text NOT NULL,\n"
                + "    type text,\n"
                + "    class text\n"
                + ");";

        try (Statement stmt = sql_conn.createStatement()
        ) {
            stmt.execute(sql);

            System.out.println("New Table added successfully to the StarFleet Database");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String database_name = "StarFleet";
        // Part 1: Basics
//        Connection conn = connect(database_name);
//
//        createNewDatabase(conn);
//        createNewTable(conn);

        // Part 2: Insert, extract and delete data
        SqlHandler sql_h = new SqlHandler(database_name);

        sql_h.printShips();
//        sql_h.insertShipData(
//                "USS Enterprise",
//                "Warp 5 prototype/long range cruiser",
//                "Naval Experimental (NX)"
//                );
//
//        sql_h.insertShipData(
//                "USS Ares",
//                "Battle Cruiser",
//                "Ares Class prototype"
//        );
//
//        sql_h.deleteShipById(3);
//
//        sql_h.printShips();
//        sql_h.deleteTable("ships");
    }
}
