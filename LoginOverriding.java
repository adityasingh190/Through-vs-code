  class Abc{
    String usr="aditya";
    String pass="adi";
    void user(String user,String pswrd)
    {
        if(usr.equals(user)&&pass.equals(pswrd))
        System.out.println("login sucessfull");
        else
        System.out.println("login unsucessfull");
    }
}
    class LoginOverriding extends Abc
    {
        String usr="Adit";
    String pass="adit";
    int otp1=861;
    int otp()
    {
        return 861;
    }
    void user(String user,String pswrd)
    {
        if(usr.equals(user)&&pass.equals(pswrd))
        {
            if(otp()==otp1)
        System.out.println("login sucessfull");
           else
        System.out.println("login unsucessfull");
}
        else

    System.out.println("login unsucessfull");

    }

    public static void main(String args[])
    {
        Abc k=new LoginOverriding();
        k.user("Aditya","adi");

        Abc j=new Abc();
        j.user("Adit","adf");
    }
    
}
