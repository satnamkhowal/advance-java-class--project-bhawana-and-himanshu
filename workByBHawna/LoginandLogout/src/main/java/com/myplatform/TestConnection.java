
package com.myplatform;

import java.sql.Connection;

public class TestConnection {

    public static void main(String[] args) {

        try {
            Connection con = DBConnection.getConnection();

            if (con != null) {
                System.out.println(
                    "DATABASE CONNECTED SUCCESSFULLY!"
                );

                System.out.println(
                    "Database: " +
                    con.getCatalog()
                );

                con.close();
            }

        } catch (Exception e) {
            System.out.println(
                "DATABASE CONNECTION FAILED!"
            );

            e.printStackTrace();
        }
    }
}
