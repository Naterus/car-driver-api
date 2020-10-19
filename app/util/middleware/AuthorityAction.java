package util.middleware;

import play.Logger;
import play.libs.Json;
import play.libs.typedmap.TypedKey;
import play.mvc.Action;
import play.mvc.Http;
import play.mvc.Result;
import pojos.ResponsePayload;
import util.exceptions.GeneralAppException;
import util.security.Authority;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;

public class AuthorityAction extends Action.Simple {


    @Inject
    Authority auth;
    private static final Logger.ALogger logger = Logger.of(AuthorityAction.class);
    private static final TypedKey<? super ResponsePayload> status = null;

    @Override
    public CompletionStage<Result> call(Http.Request request) {

        logger.info("Checking Authority for {}",request);
        Http.RequestHeader headerRequest = request;

        try {
            if (!auth.isValidKey(headerRequest)){
                ResponsePayload responsePayload = new ResponsePayload();
                responsePayload.setStatusCode(401);
                responsePayload.setStatusTitle("unauthorized");
                responsePayload.setMessage("Invalid/missing authorization key. Ensure you include valid authorization key in request header.");

                Result r = unauthorized(Json.toJson(responsePayload));


                return delegate.call(request).thenApplyAsync(result -> r);
            }
        } catch (GeneralAppException e) {
            e.printStackTrace();
        }
        //Allow access if authority key is valid
        return delegate.call(request);
    }
}
