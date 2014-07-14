package controllers;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import models.OldPhoneCall;
import jobs.MakeDelayedPhoneCall;
import play.Play;
import play.mvc.Controller;
import utils.TwilioUtil;

import com.twilio.sdk.TwilioRestException;

import exceptions.InterviewException;

public class Application extends Controller {
	public static void index() {
		List<OldPhoneCall> olderPhoneCalls = OldPhoneCall.find(
				"ORDER BY created DESC").fetch();
		render(olderPhoneCalls);
	}

	public static void phone() throws TwilioRestException, NumberFormatException, InterruptedException {
		OldPhoneCall newPhoneRecord = new OldPhoneCall(params.get("phone"), params.get("delay"));
		newPhoneRecord.save();
		
		MakeDelayedPhoneCall phoneJob = new MakeDelayedPhoneCall();
		phoneJob.setDelay(params.get("delay"));
		phoneJob.setPhoneNumber(params.get("phone"));
		phoneJob.setApplicationSid(Play.configuration.getProperty("applicationSid"));
		phoneJob.setAccountSid(Play.configuration.getProperty("accountSid"));
		phoneJob.setAuthToken(Play.configuration.getProperty("authToken"));
		phoneJob.setCallbackUrl(Play.configuration.getProperty("callbackUrlForTwilio"));
		phoneJob.setFromPhoneNumber(Play.configuration.getProperty("twilioValidatedFromPhoneNumber"));
		phoneJob.now();
		
		index();
	}

	public static void ask() throws InterviewException, InvalidKeyException,
			NoSuchAlgorithmException {
		renderXml(TwilioUtil.askForFizzBuzzNumber().toXML());
	}

	public static void answer() throws InterviewException {
		String fizzBuzzNumberStr = params.get("Digits");
		renderXml(TwilioUtil.sayFizzBuzzAnswer(
				Long.parseLong(fizzBuzzNumberStr)).toXML());
	}
}