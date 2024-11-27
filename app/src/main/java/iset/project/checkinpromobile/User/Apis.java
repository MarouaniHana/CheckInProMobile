package iset.project.checkinpromobile.User;

public class Apis {
    private static final String Url="http://10.0.2.2:8080/"; //emulator localhost
    public static UserService getService(){
        return  Client.getRetrofit(Url).create(UserService.class);
    }
}
