package todolist.models;

import java.lang.reflect.Parameter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;
import javax.sql.DataSource;

import com.mysql.cj.xdevapi.PreparableStatement;

import todolist.entities.UserEntity;

public class LoginModel {
    private DataSource dataSource;

    public LoginModel(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public boolean CheckUserExists(String userid){
        String sql = "SELECT * FROM user WHERE userid= ?";
        try(
            Connection connection = dataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)
        ){
            stmt.setString(1, sql);
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()){
                resultSet.close();
                return true;
            }
            else{
                resultSet.close();
                return false;
            }
            
        }catch(SQLException ex){
            throw  new RuntimeException(ex);
        }
        
    }
    public boolean UserPasswordValid(UserEntity user){
        String sql = "SELECT * FROM user WHERE userid= ? and password =?";
         try(
            Connection connection = dataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)
 
         ){
            stmt.setString(1, user.getUserid());
            stmt.setString(2, user.getPassword());
            ResultSet resultSet = stmt.executeQuery();

            if(resultSet.next()){
                resultSet.close();
                return true;
            }
            else{
                resultSet.close();
                return false;
            }
         }catch (SQLException ex){
            throw new RuntimeException(ex);
         }
    }
}
