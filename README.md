TwilioPlayOneSample
===================

A FizzBuzz Twilio sample Java app that uses Play framework 1.2.x

This web application demonstrates how to:
* initiate a Twilio phone call to a specified phone number
* read a text message as a recorded message
* accept user telephone pad input and respond to that input 

#Getting Started

This example requires:
* general familiarity with MVC (Model View Controller) frameworks
* installation of the Play Framework 1.2.x
* a developer account for Heroku (https://signup.heroku.com/signup/dc)
* a developer account for Twilio (https://www.twilio.com/try-twilio)

##Play Framework Installation

To install the Play Framework, follow the instructions found within the link:

http://www.playframework.com/documentation/1.2.7/install

##Heroku Setup

Heroku is a great cloud web application host. It is a great tool for prototyping and early testing.

To set up a Play 1.2.x web application on Heroku, please refer to the following link:

https://devcenter.heroku.com/articles/getting-started-with-play

Once finished you should have a working Play instance hosted on the Heroku cloud as well as a live postgres database instance.

##Twilio Setup

For Twilio this sample application will need several pieces of data relevant to your Twilio account. The Account SID and Authentication Code can be found under Dev Tools > Test Credentials (https://www.twilio.com/user/account/developer-tools/test-credentials)

This application requires the addition of a TWIML app to your Twilio developer account. When adding it, you may be required to the callback URL to the sample application's ask route. The sample application's ask route is: Your Heroku App URL/ask (e.g. http://calm-anchorage-1234.herokuapp.com/ask). Once added, the TWIML app will provide you with the Application SID.

This application will also need verified phone numbers. To verify a phone number, go to Numbers (https://www.twilio.com/user/account/phone-numbers/incoming) and add your phone to be verified by Twilio.

#Overview

Here's a high level description to describe what's occuring and how this application works. HINT: Take a look at the Application.java Play controller.

1. The user posts the phone number she wants to be called by Twilio, as well as the delay in seconds before Twilio makes the call.

User <= => app.index
User => app.phone

2. The sample application makes a phone call request, providing relevant data related to authentication, as well the sample applcation's URL for providing phone call instructions (with details below).

app.phone => Twilio API service
app.ask <= Twilio API service

3. The Twilio service makes a call to the sample application, based on the provided callback URL. The ask Play action will play the initial message (asking the caller for a number) as well as listening for user entered phone digits (after the caller presses the '#' button). The ask controller Play action will then direct Twilio to perform another callback to the answer play action. 

app.ask <= Twilio API service
app.answer <= Twilio API service

4. When the Twilio service makes a call to the sample application's 'answer' action, the answer action will direct Twilio to read the Fizzbuzz sequence for the caller entered number. (http://c2.com/cgi/wiki?FizzBuzzTest)

app.answer <= Twilio API service




