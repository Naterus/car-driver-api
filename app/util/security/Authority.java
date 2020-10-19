package util.security;

import models.Authorization;
import play.mvc.Http;
import util.exceptions.GeneralAppException;

import java.security.SecureRandom;

public class Authority {

    //SecureRandom string generator
    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static SecureRandom rnd = new SecureRandom();

    public String randomString( int length ){
        StringBuilder sb = new StringBuilder( length );
        for( int i = 0; i < length; i++ )
            sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
        return sb.toString();
    }

    public Boolean isValidKey(Http.RequestHeader request) throws GeneralAppException {

        try{
            String authorization = request.header("Authorization").get();
            Authorization authKey = Authorization.find.byId(authorization);

            if (authKey == null){
                return false;
            }
            return true;
        }catch (Exception e){
            return false;
        }

    }

}
