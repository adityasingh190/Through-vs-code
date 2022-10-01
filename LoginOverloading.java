public class LoginOverloading {
    String usr="aditya",pas="adi";
    int otp=123;
    boolean user(String username, String password)
    {
        if(username.equals(usr)&&password.equals(pas))
        return true;
        else
        return false;
    }
    boolean user(String username, String password,int otp1)
    {
        if(username.equals(usr)&&password.equals(pas))
        {
            if(otp1==otp)
        return true;
        else
        return false;
        }
        else
        return false;
    }
   public static void main(String[] args) {
    LoginOverloading l=new LoginOverloading();
    if(l.user("aditya","adi")||l.user("aditya","adi",123))
    System.out.println("Login Sucessfull");
    else
    System.out.println("Login not Sucessfull");


    
    
   }
    
    
}
