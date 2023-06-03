package todolist.usecases;

import com.zaxxer.hikari.HikariDataSource;

import todolist.entities.UserEntity;
import todolist.models.LoginModel;
import todolist.utils.DBConnectionUtil;

public class LoginUsecase {
    private HikariDataSource dataSource;
    private LoginModel loginModel;

    public LoginUsecase(){
        dataSource = DBConnectionUtil.getDataSource();
        loginModel = new LoginModel(dataSource);
    }
    public String LoginValidate(String userid, String password){
        //Validasi Input
        if(userid.equals("")||password.equals("")){
            return "userid and password cannot be empty!";
        }

        UserEntity user = new UserEntity();
        user.setUserid(userid);
        user.setPassword(password);

        //validasi user exist pada DB
        if(!loginModel.CheckUserExists(user.getUserid())){
            return "userid does not exists, please try again.";
        }

        //validasi userid & password valid
        if(!loginModel.UserPasswordValid(user)){
            return "userid and password is not valid, please try again.";
        }
        return "";
    }
}
