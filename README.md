

##Introduction

This application is developed as part of interview assessment for CurrencyFair.

This application exposes the REST endpoint to POST the currency transaction data in JSON format.

It also provides the frontend UI to see the live data which is posted to the REST service. A live chart which plots the current conversion rate against time is also present in this UI. This chart is a technology demonstrator and can be extended to provide additional information to the user. 

A combination of Java Spring, ActiveMQ and websockets is used to achieve this. 

##Technology Stack

- Java Spring MVC
- Java Spring RESTful service
- ActiveMQ
- Websockets
- JSP - for front end
- Maven - build tool
- Tomcat 9 - server
- Eclipse - IDE


##Architecture

It contains three components

- RESTful service for POSTing JSON data
- Currency Report Application to receive ( and if required process) this data
- Websocket based Front end UI for the user.

##RESTful service for POSTing JSON data

![Alt text](https://cloud.githubusercontent.com/assets/25563324/22806452/139cfe78-ef1a-11e6-984c-6f2bdde5e633.png "POST_end_point")

https://currencyrestservice.eu-gb.mybluemix.net/currency


Have used the Java Spring to provide the REST service to POST the currency data.

The received currency data is pushed into ActiveMQ . This is done to ensure reliable and low latency communication between processes and to reduce the delay in handling large number of POST requests. 



##Currency Report Application

![Alt text](https://cloud.githubusercontent.com/assets/25563324/22806453/13b3368e-ef1a-11e6-815a-5d3efeec074b.png "Currency_report")

https://currencyreportapp.eu-gb.mybluemix.net/currencyReport


Have used the spring mvc for the base of the web application. When the data is been pushed to the ActiveMQ through REST service, the ActiveMQ would store  the message until the client reads the messages. Once the application is ready with ActiveMQConnectionFactory configurations, using DefaultJmsListenerContainerFactory listener the application starts listening to the queue.
Once any message is listened by the DefaultJmsListenerContainerFactory, it is sent to the websocket. The websocket configurations are made through annotations @EnableWebSocketMessageBroker, MessageBrokerRegistry and StompEndpointRegistry are used to set the broker and endpoint. 


##End Points

There are two end points in this project

###RESTful service for POSTing JSON data

REST endpoint to POST json data - set ContentType as application/json in header

https://currencyrestservice.eu-gb.mybluemix.net/currency

###Currency Report Application 

https://currencyreportapp.eu-gb.mybluemix.net/currencyReport



##Github links

For RESTful service ( Message consumption endpoint)
https://github.com/chaithra-krishna/RESTfulService

For Application ( User UI)
https://github.com/chaithra-krishna/currencyReport

##Testing Method

- Open the currency report application (https://github.com/chaithra-krishna/currencyReport)in web browser. Initially it will be empty as we have not yet posted any data.

- POST the JSON input using a tool like  RESTClient or Postman.  
 
- A short program/script also used to generate random values for these parameters for testing purposes.

	Sample data:
	
	Url: https://currencyrestservice.eu-gb.mybluemix.net/currency
	
	Header : ContentType : application/json
	
	Input/payload : 
	
{
	"userId": "134256",
	"currencyFrom": "tterersdsft",
	"currencyTo": "GBP",
	"amountSell": 234,
	"amountBuy": 747.10,
	"rate": 0.7471,
	"timePlaced": "24-JAN-15 10:27:44",
	"originatingCountry": "FR"
}

Success message : Currency data added successfully

Status Code : 200 OK

Now the chart and data in the browser get updated with live data.

![Alt text](https://cloud.githubusercontent.com/assets/25563324/22806310/67c1ccc8-ef19-11e6-97dc-af9ab7199ad3.png "Chart")


 

