package utils;

import com.twilio.sdk.verbs.Gather;
import com.twilio.sdk.verbs.Say;
import com.twilio.sdk.verbs.TwiMLException;
import com.twilio.sdk.verbs.TwiMLResponse;

import exceptions.InterviewException;

public class TwilioUtil {
	public static TwiMLResponse askForFizzBuzzNumber()
			throws InterviewException {
		TwiMLResponse result = new TwiMLResponse();
		Say say = new Say(
				"Tell me a number, by pressing number keys. When you are finished, press the pound key.");
		Gather gather = new Gather();
		gather.setAction("/answer");
		gather.setTimeout(100);
		gather.setFinishOnKey("#");
		gather.setMethod("POST");
		try {
			result.append(say);
			result.append(gather);
		} catch (TwiMLException e) {
			throw new InterviewException("Failed to create TwiML response.", e);
		}
		return result;
	}

	public static TwiMLResponse sayFizzBuzzAnswer(Long fizzBuzzNumber)
			throws InterviewException {
		TwiMLResponse result = new TwiMLResponse();
		Say say = new Say(FizzBuzzUtil.fizzBuzz(fizzBuzzNumber));
		try {
			result.append(say);
		} catch (TwiMLException e) {
			throw new InterviewException("Failed to create TwiML response.", e);
		}
		return result;
	}
}
