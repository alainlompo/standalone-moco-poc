# standalone-moco-poc
a simple poc showing how to use moco to provide stub to web server (example with json response and requests)

In order to use this project correctly you should download the standalone version of moco here: https://repo1.maven.org/maven2/com/github/dreamhead/moco-runner/0.10.1/moco-runner-0.10.1-standalone.jar and then run it by using the
launch_moco.bat file (use for example port number 10500) and run the GreatestAthleteMoco.java main class to check that it is working correctly

Using Moco with a variable (dynamic) number of parameters in the request.

In a moco request we can use the "contain" operator to specify that a request contains a certain piece of text
<pre>
"request": {
   "text": {
      "contain":"text that should appear in the request"
   }
},
"response": {
  "json": {
      "userToken":"Hys8475KLO451",
      "deviceId":123
  }
}
</pre>
No matter how many more parameters appear in the request, if it contains the text associated with the "contain" operator, moco will produce the same response
