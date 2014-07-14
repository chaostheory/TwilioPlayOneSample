TwilioPlayOneSample
===================

A Twilio sample Java app that uses Play framework 1.2.x

This web application demonstrates how to:
* initiate a Twilio phone call to a specified phone number
* read a text message as a recorded message
* accept user telephone pad input and respond to that input

=Getting Started=

This example requires:
* installation of the Play Framework 1.2.x
* a developer account for Heroku (https://signup.heroku.com/signup/dc)
* a developer account for Twilio (https://www.twilio.com/try-twilio)

==Play Framework Installation==

To install the Play Framework, follow the instructions found within the link:

http://www.playframework.com/documentation/1.2.7/install

==Heroku Setup==

Heroku is a great cloud web application host. It is a great tool for prototyping and early testing.

To set up a Play 1.2.x web application on Heroku, please refer to the following link:

https://devcenter.heroku.com/articles/getting-started-with-play

Once finished you should have a working Play instance hosted on the Heroku cloud as well as a live postgres database instance.

==Twilio Setup==

For Twilio this sample application will need several pieces of data relevant to your Twilio account. The Account SID and Authentication Code can be found under Dev Tools > Test Credentials (https://www.twilio.com/user/account/developer-tools/test-credentials)

This application requires the addition of a TWIML app to your Twilio developer account. When adding it, you may be required to the callback URL to the sample application's ask route. The sample application's ask route is: Your Heroku App URL/ask (e.g. http://calm-anchorage-1234.herokuapp.com/ask). Once added, the TWIML app will provide you with the Application SID.

This application will also need verified phone numbers. To verify a phone number, go to Numbers (https://www.twilio.com/user/account/phone-numbers/incoming) and add your phone to be verified by Twilio.
