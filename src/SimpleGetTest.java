import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class SimpleGetTest 
{
	@Test
	public void GetWeatherDetails() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response httpResponse = httpRequest.request(Method.GET, "/Chennai");
		String responseBody = httpResponse.getBody().asString();
		System.out.println(responseBody);
		
		int statusCode = httpResponse.getStatusCode();
		System.out.println("statusCode " + statusCode);
		
		Assert.assertEquals(statusCode/*actual code*/, 200/*expected code*/);
	}
	
	@Test
	public void GetInvalidStatusCode() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response httpResponse = httpRequest.request(Method.GET, "784768458");
		String responseBody = httpResponse.getBody().asString();
		System.out.println(responseBody);
		
		int statusCode = httpResponse.getStatusCode();
		System.out.println("statusCode " + statusCode);
		
		Assert.assertEquals(statusCode/*actual code*/, 400/*expected code*/);
	}
	
	@Test
	public void GetGivenStatusLine() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response httpResponse = httpRequest.request(Method.GET, "/Hyderabad");
		String responseBody = httpResponse.getBody().asString();
		System.out.println(responseBody);
		
		String statusLine = httpResponse.getStatusLine();
		System.out.println("statusLine " + statusLine);
		
		Assert.assertEquals(statusLine/*actual line*/, "HTTP/1.1 200 OK"/*expected line*/);
	}
	
	@Test
	public void GetResponseHeader() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response httpResponse = httpRequest.request(Method.GET, "/Hyderabad");
		String header = httpResponse.header("Content-Type");
		String header2 = httpResponse.header("Server");
		String header3 = httpResponse.header("Content-Encoding");
		System.out.println(header + header2 + header3 );
					}
	
	@Test
	public void GetAllHeaderValues() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response httpResponse = httpRequest.request(Method.GET, "/Hyderabad");
		Headers headers = httpResponse.headers();
		for(Header header : headers) {
			System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
		}
	}
	
	@Test
	public void 
() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response httpResponse = httpRequest.request(Method.GET, "/Hyderabad");
		ResponseBody body = httpResponse.body();
		 System.out.println("Response Body is: " + body.asString());
		}
	}
		
