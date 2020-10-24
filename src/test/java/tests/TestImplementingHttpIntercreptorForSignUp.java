package tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.Test;

public class TestImplementingHttpIntercreptorForSignUp extends TestBase {
	
	
	public TestImplementingHttpIntercreptorForSignUp() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test(priority=1)
	public void UserCanVerifySigupHttpRequestandValidateTheResponse() throws IOException, InterruptedException 
	{
		TestBase.extentTest = TestBase.extent.startTest("Implement an HTTP interceptor for the signUp API request ");
		System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");

		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(prop.getProperty("URL"));
		HttpResponse response = client.execute(request);
		BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		String line = "";
		StringBuffer sb = new StringBuffer();
		while ((line = br.readLine()) != null) {
		sb.append(line);

		}
		System.out.println(response.getStatusLine());
		PrintWriter pw = new PrintWriter(System.getProperty("user.dir") + "//Response//signUP.html"); //
		pw.write(sb.toString());
		pw.close();
		pw.flush();
	

	}


}
