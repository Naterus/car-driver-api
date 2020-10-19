package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import io.ebean.Ebean;
import io.ebean.Query;
import io.ebean.RawSql;
import io.ebean.RawSqlBuilder;
import models.Authorization;
import models.Driver;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import pojos.ResponsePayload;
import util.exceptions.GeneralAppException;
import util.security.Authority;

import javax.inject.Inject;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;

public class AuthorizationController extends Controller {

    @Inject
    Authority auth;

    public Result generateKey(Http.Request request) throws GeneralAppException {

        JsonNode formData = request.body().asJson();

        String authorizationKey = "CDS."+auth.randomString(20);
        String name = formData.findPath("name").textValue();
        String email = formData.findPath("email").textValue();

        if(email == null || name == null){
            ResponsePayload responsePayload = new ResponsePayload();
            responsePayload.setStatusCode(401);
            responsePayload.setStatusTitle("bad request");
            responsePayload.setMessage("Email or name can not be empty");

            return badRequest(Json.toJson(responsePayload));
        }

        Authorization authorizationModel = new Authorization();
        authorizationModel.setEmail(email);
        authorizationModel.setAuthorizationKey(authorizationKey);
        authorizationModel.setName(name);

        authorizationModel.save();

        HashMap<String,String> result =  new HashMap<>();

        result.put("statusCode","201");
        result.put("statusTitle","created");
        result.put("authorizationKey",authorizationKey);
        result.put("message","New authorization key created and can only be accessed once. Please save your authorization key securely.");

        return created(Json.toJson(result));
    }

}
