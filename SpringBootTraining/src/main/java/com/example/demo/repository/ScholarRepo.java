package com.example.demo.repository;
import com.example.demo.model.SampleModel;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class ScholarRepo {

    static Connection dbConnection = null;
    static PreparedStatement preparedStatement = null;

    private static void connectToDatabase(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/training","root","");

            if(dbConnection != null){
                System.out.print("Database Conenction Successful");
            }else{
                System.out.println("Database Connection failed");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    public List<SampleModel> getAllScholars() throws SQLException {
        connectToDatabase();
        List<SampleModel> scholars = new ArrayList<>();

        String fetchQuery = "Select * from scholar_data";
        preparedStatement = dbConnection.prepareStatement(fetchQuery);
        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()){
            SampleModel data = new SampleModel();
            data.setName(rs.getString(1));
            data.setiNumber(rs.getString(2));
            data.setDOB(rs.getString(3));
            data.setJoiningYear(rs.getInt(4));
            data.setCourseDuration(rs.getInt(5));
            scholars.add(data);
        }
        dbConnection.close();
        return scholars;


    }

    public SampleModel getScholar(String iNumber){
        SampleModel data = new SampleModel();
        connectToDatabase();
        String retrieveQuery = "Select * from scholar_data where iNumber=\'"+iNumber+"\'";
        try {
            preparedStatement = dbConnection.prepareStatement(retrieveQuery);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                data.setName(rs.getString(1));
                data.setiNumber(rs.getString(2));
                data.setDOB(rs.getString(3));
                data.setJoiningYear(rs.getInt(4));
                data.setCourseDuration(rs.getInt(5));
            }


        }catch (SQLException e){
            e.printStackTrace();
        }
        return data;
    }

    public void addScholar(SampleModel scholar){
        connectToDatabase();

        String insertQuery = "Insert into scholar_data values(?,?,?,?,?);";
        try {
            preparedStatement = dbConnection.prepareStatement(insertQuery);

        preparedStatement.setString(1, scholar.getName());
        preparedStatement.setString(2, scholar.getiNumber());
        preparedStatement.setString(3,scholar.getDOB());
        preparedStatement.setInt(4,scholar.getCourseDuration());
        preparedStatement.setInt(5,scholar.getJoiningYear());

        preparedStatement.executeUpdate();
        System.out.println("Data Entered Successfully");
        dbConnection.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
