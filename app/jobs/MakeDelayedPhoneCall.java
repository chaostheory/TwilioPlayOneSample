package jobs;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import play.jobs.Job;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.CallFactory;
import com.twilio.sdk.resource.instance.Call;

public class MakeDelayedPhoneCall extends Job {
		
	private String phoneNumber;
	private String delay = "30";
	private String authToken;
	private String accountSid;
	private String applicationSid;
	private String callbackUrl;
	//This phone number will appear as the caller ID
	private String fromPhoneNumber;

	public void setDelay(String delay) {
		this.delay = delay;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public void setAccountSid(String accountSid) {
		this.accountSid = accountSid;
	}

	public void setApplicationSid(String applicationSid) {
		this.applicationSid = applicationSid;
	}

	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}

	public void setFromPhoneNumber(String fromPhoneNumber) {
		this.fromPhoneNumber = fromPhoneNumber;
	}

	@Override
	public void doJob() {
		try {
			TimeUnit.SECONDS.sleep(Integer.parseInt(delay));
			TwilioRestClient client = new TwilioRestClient(accountSid, authToken); 
			 
			// Build the parameters 
			List<NameValuePair> params = new ArrayList<NameValuePair>(); 
			params.add(new BasicNameValuePair("To", phoneNumber)); 
			params.add(new BasicNameValuePair("From", fromPhoneNumber)); 
			params.add(new BasicNameValuePair("Url", callbackUrl)); 
			params.add(new BasicNameValuePair("ApplicationSid", applicationSid)); 
			params.add(new BasicNameValuePair("Method", "GET"));  
			params.add(new BasicNameValuePair("FallbackMethod", "GET"));  
			params.add(new BasicNameValuePair("StatusCallbackMethod", "GET"));    
			params.add(new BasicNameValuePair("Record", "false"));
			CallFactory callFactory = client.getAccount().getCallFactory(); 
			Call call = callFactory.create(params); 
			System.out.println(call.getSid());
		} catch (TwilioRestException | NumberFormatException | InterruptedException e) {
			e.printStackTrace();
		} 
    }
}
