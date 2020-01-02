package com.ariel.oop;

import java.sql.*;

public class SqlHandler {
    String mDB_path;
    Connection mConn;

    SqlHandler(String db_path) {
        mDB_path = db_path;
        mConn = connect2DB(mDB_path);
    }

    /**
     * Connects to the SQL database
     *
     * @param db_path the path to the database
     * @return The connection object
     */
    public Connection connect2DB(String db_path) {
        if (!(null == mConn)) {
            try {
                mConn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("Could not close old connection");
                return null;
            }
        }
        Connection conn = null;
        try {
            // db parameters
            db_path = db_path.endsWith(".db") ? db_path : db_path + ".db";
            String url = "jdbc:sqlite:sqlite/db/" + db_path;
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
     * Get the max ship id
     *
     * @return the last id (INT)
     */
    public int getLastId() {
        return getLastId("ships");
    }

    /**
     * Get max id from a table
     *
     * @param table_str the table name
     * @return the last id (INT)
     */
    public int getLastId(String table_str) {
        String sql = "SELECT MAX(id) FROM " + table_str;

        try (PreparedStatement pstmt = mConn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();

            // loop through the result set
            int ret_id = 0;
            while (rs.next()) {
                ret_id = rs.getInt(1);
                return ret_id;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return -1;
    }

    /**
     * Prints all the ships
     */
    public void printShips() {
        String sql = "SELECT name,id " +
                "FROM ships";

        try (PreparedStatement pstmt = mConn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();

            // loop through the result set
            while (rs.next()) {
                System.out.println(
                        "Id:\t" + rs.getString(2)
                                + "\n\tName:\t" + rs.getString(1)
                );
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Adds another ship to the database
     *
     * @param name      Ship name
     * @param type      Ship type
     * @param class_str Ship class
     */
    public void insertShipData(String name, String type, String class_str) {
        String sql = "INSERT INTO ships(name,id,type,class) VALUES(?,?,?,?)";
        int next_id = getLastId() + 1;
        try (PreparedStatement pstmt = mConn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, next_id);
            pstmt.setString(3, type);
            pstmt.setString(4, class_str);
            pstmt.executeUpdate();

            System.out.println("Added new ship.");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Deletes ship by ID
     *
     * @param ship_id Ships ID
     */
    public void deleteShipById(int ship_id) {
        String sql = "DELETE FROM ships WHERE id = ?";

        try (PreparedStatement pstmt = mConn.prepareStatement(sql)) {
            // set the corresponding param
            pstmt.setInt(1, ship_id);
            // execute the delete statement
            pstmt.executeUpdate();

            System.out.println("Ship retired");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Delete a table from the database
     *
     * @param table_name The table to delete
     */
    public void deleteTable(String table_name) {
        String sql = String.format("DROP TABLE %s;", table_name);

        try (PreparedStatement pstmt = mConn.prepareStatement(sql)) {
            // execute the delete statement
            pstmt.executeUpdate();

            System.out.println(String.format("Deleted <%s> table.", table_name));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Empty a tables content from the database
     *
     * @param table_name The table to delete
     */
    public void truncateTable(String table_name) {
        String sql = String.format("DELETE FROM %s;", table_name);

        try (PreparedStatement pstmt = mConn.prepareStatement(sql)) {
            // execute the delete statement
            pstmt.executeUpdate();

            System.out.println(String.format("Cleared <%s> contents.", table_name));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Adds another ship to the database
     *
     * @param name Ship name
     */
    public void insertPassengerData(String name, int ship_id) {
        String sql = "INSERT INTO passengers(id,name,ship_id) VALUES(?,?,?)";
        int next_id = getLastId("passengers") + 1;
        try (PreparedStatement pstmt = mConn.prepareStatement(sql)) {
            pstmt.setString(2, name);
            pstmt.setInt(1, next_id);
            pstmt.setInt(3, ship_id);
            pstmt.executeUpdate();

            System.out.println("Added new passenger.");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Create a Passengers table and adds entries
     */
    public void createAndFillPassengers() {
        String sql = "CREATE TABLE IF NOT EXISTS passengers(\n"
                + "    id INTEGER PRIMARY KEY,\n"
                + "    name TEXT NOT NULL,\n"
                + "    ship_id INTEGER NOT NULL"
                + ");";

        try (Statement stmt = mConn.createStatement()
        ) {
            stmt.execute(sql);

            insertPassengerData("Yossi", 1);
            insertPassengerData("Captian Picard", 1);
            insertPassengerData("Mr. Data", 2);
            insertPassengerData("Dr. McCoy", 2);

            System.out.println("Added and filled Passengers table");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Prints the Passengers table
     */
    public void printTablePassengers() {
        String sql = "SELECT id,name,ship_id " +
                "FROM passengers";

        try (PreparedStatement pstmt = mConn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();

            // loop through the result set
            while (rs.next()) {
                System.out.println(
                        "Id:\t" + rs.getString(1)
                                + "\n\tName:\t" + rs.getString(2)
                );
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Print the passengers onboard a ship by ship id
     * @param ship_id ship ID
     */
    public void printPassengersByShip(int ship_id) {
        String sql = "SELECT passengers.id,passengers.name,ships.name " +
                "FROM ships,passengers " +
                "WHERE ships.id=passengers.ship_id AND ships.id=" + ship_id;

        try (PreparedStatement pstmt = mConn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();

            // loop through the result set
            while (rs.next()) {
                System.out.println(
                        "Pass. Name:\t("+rs.getString(1)+") " + rs.getString(2)
                                + "\n\tShip Name:\t" + rs.getString(3)
                );
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
