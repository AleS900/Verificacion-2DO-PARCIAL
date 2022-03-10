package runner;

import factoryRequest.FactoryRequest;
import factoryRequest.RequestInformation;
import helpers.Configuration;
import helpers.JsonAssert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class MyStepClean {
    Response response;
    RequestInformation requestInformation = new RequestInformation();
    Map<String,String> dynamicVar = new HashMap<>();

    @Given("I use {} authentication")
    public void iUseThatAuthentication(String auth) {
        String authBasic="Basic " + Base64.getEncoder().encodeToString((Configuration.user + ":" + Configuration.pwd).getBytes());
        if(auth.equals("basic")){
            requestInformation.setHeaders("Authorization", authBasic);
        }else{
            RequestInformation searchToken = new RequestInformation();
            searchToken.setUrl(Configuration.host + "/api/authentication/token.json");
            searchToken.setHeaders("Authorization", authBasic);
            response= FactoryRequest.make("get").send(searchToken);
            String token = response.then().extract().path("TokenString");
            requestInformation.setHeaders("Token", token);
        }
    }

    @When("I use the {} request to {} with the body")
    public void iSendPOSTRequestToTheAPIProjectWithTheBody(String request, String url, String body) {
        requestInformation.setUrl(Configuration.host + replaceVar(url))
                .setBody(replaceVar(body));
        response = FactoryRequest.make(request).send( requestInformation );
    }

    @Then("the code that I receive should be {int}")
    public void theCodeThatIReceiveShouldBe(int expected) {
        response.then().statusCode(expected);
    }

    @And("the expected body should be")
    public void theExpectedBodyShouldBe(String expectedJson) throws Exception {
        JsonAssert.areEqualJson(replaceVar(expectedJson), response.body().asPrettyString(),"different JSON");
    }

    @When("I update in {} with the user {}, the password {} and the body")
    public void iUpdateUserUsingHisUserPasswordAndABody(String url, String user, String pwd, String body) {
        String authBasic="Basic "+ Base64.getEncoder().encodeToString((user + ":" + pwd).getBytes());
        requestInformation.setHeaders("Authorization", authBasic);
        requestInformation.setUrl(Configuration.host + replaceVar(url))
                .setBody(replaceVar(body));
        response = FactoryRequest.make("put").send(requestInformation);
    }

    @And("I save {} of the response in {}")
    public void iSaveAnAttributeOFTheResponseInAVariable(String property, String var) {
        dynamicVar.put(var,response.then().extract().path(property)+"");

    }

    @When("I send a DELETE request with {} to {}")
    public void iSendADeleteRequestWithATokenToAnAPI(String token, String url) {
        response = given().header("Token", replaceVar(token)).when().delete(Configuration.host + url);
    }

    @And("the attribute {} should be {}")
    public void theAttributeXShouldBeY(String attribute,String expectedValue) {
        response.then().body(attribute,equalTo(expectedValue));
    }

    private String replaceVar(String value){
        for (String attribute: dynamicVar.keySet() ) {
            value=value.replace(attribute,dynamicVar.get(attribute));
        }
        return value;
    }
}
