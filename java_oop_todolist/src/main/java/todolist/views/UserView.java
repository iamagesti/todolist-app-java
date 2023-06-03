package todolist.views;

import java.util.Scanner;

import todolist.usecases.UserUseCase;



public class UserView {
    public static void ShowUserMain() {
        Scanner inputScanner = new Scanner(System.in);

        System.out.println("=====================");
        System.out.println("List User");

        UserUseCase userUsecase = new UserUseCase();
        userUsecase.GetUserList();

        System.out.println("===");
        System.out.println("MENU");
        System.out.println("===");
        System.out.println("[1] - Add New User Account");
        System.out.println("[2] - Change Password");
        System.out.println("[3] - Back to Welcome Page");
        System.out.println();
        System.out.println("Input Menu (Number) : ");
        Integer menu = inputScanner.nextInt();

        switch(menu){
            case 0:
                WelcomeView.ShowWelcomeView();
                break;
            case 1:
                ShowAddUser();
                break;
            case 2:
                ShowChangePassword();
                break;

        }
        inputScanner.close();
        
    }

    private static void ShowAddUser() {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("======================");
        System.out.println("userid: ");
        String sUserid = inputScanner.nextLine();
        System.out.println("password: ");
        String sPassword = inputScanner.nextLine();

        UserUseCase userUseCase =new UserUseCase();
        userUseCase.AddUser(sUserid,sPassword);
    }

    private static void ShowChangePassword(){
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("======================");
        System.out.println("Userid : ");
        String sUserid = inputScanner.nextLine();
        System.out.println("Password : ");
        String sPassword = inputScanner.nextLine();

        UserUseCase userUsecase = new UserUseCase();
        userUsecase.ChangePasswordUser(sUserid, sPassword);

        ShowUserMain();
        inputScanner.close();
    }
}