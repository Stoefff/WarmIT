#include <ESP8266WiFi.h>
#include <ESP8266mDNS.h>
#include <ArduinoOTA.h>
#include <ESP8266WebServer.h>
#include <time.h>

const int toggleSwitch = 2; // Digital Pin 2 connects to the toggle switch          old 2  FUCKING WORD PINOUT WTFFFFFF IS WRONG WITH THIS ESP ????????????????????????????
const int motorTerminal1 = 0; // Digital Pin 3 connects to motor terminal 1         old 3 
const int motorTerminal2 = 2; // Digital Pin 4 connects to motor terminal 2         old 4 
const int enablePin = 14; // Digital pin 8/9 connects to the enable pin                old 9 


const char* ssid = "#FreaKzzy";
const char* password = "TARAKSAKUM4edanebaratneta03"; //delete plz
const char* ID = "123456";
int heat = 0; 

ESP8266WebServer server(80);

const char* www_username = "admin";
const char* www_password = "esp8266";

void setup() {

  pinMode(toggleSwitch, INPUT); //the toggle switch functions as an input 

  //The rest of the pins function as outputs
  pinMode(motorTerminal1, OUTPUT);
  pinMode(motorTerminal2, OUTPUT);
  pinMode(enablePin, OUTPUT);

  digitalWrite(enablePin, HIGH);
  
  Serial.begin(115200);
  WiFi.mode(WIFI_STA);
  WiFi.begin(ssid, password);
  if(WiFi.waitForConnectResult() != WL_CONNECTED) {
    Serial.println("WiFi Connect Failed! Rebooting...");
    delay(1000);
    ESP.restart();
  }
  ArduinoOTA.begin();
/*
  server.on("/", [](){
    if(!server.authenticate(www_username, www_password))
      return server.requestAuthentication();
    server.send(200, "text/plain", "Login OK");
  });
*/
  server.on("/id/123456", [](){
    char body[80] = "ip: ";
    char* IP ;//= WiFi.localIP();
    server.send(200, "text/plain", strcat(body, IP)); //not serialized, cant run jsmn 
  });

  server.on("/", [](){
   // String body = server.arg('body'); // no serializer ??????
   int heatTemp; //= body.heat;
    if (heat > heatTemp){
      int temp = heat - heatTemp;
      negative_motion(&temp);
    }
    if (heat < heatTemp){
      int temp = heatTemp - heat;
      positive_motion(&temp);
    }
   server.send(200, "text/plain", "OK");
  });

  server.begin();

  Serial.print("Open http://");
  Serial.print(WiFi.localIP());
  Serial.println("/ in your browser to see it working");
}

void loop() {
  ArduinoOTA.handle();
  server.handleClient();

  if ( true /*digitalRead(toggleSwitch) == HIGH*/) { 
    digitalWrite(motorTerminal1, LOW); //these logic levels create forward direction
    digitalWrite(motorTerminal2, HIGH); 
  }
  else {
    digitalWrite(motorTerminal1, HIGH); // these logic levels create reverse direction
    digitalWrite(motorTerminal2, LOW); 
  }
}

void positive_motion(int* time_wanted){
   clock_t begin;
   double time_spent;
   long int i;

   /* Mark beginning time */
   begin = clock();
   for (i=0;1;i++){
    digitalWrite(motorTerminal1, LOW); //these logic levels create forward direction
    digitalWrite(motorTerminal2, HIGH);
    time_spent = (double)(clock() - begin) / CLOCKS_PER_SEC;
    if (time_spent> time_wanted)
      break;
   }
}

void negative_motion(int* time_wanted){
   clock_t begin;
   double time_spent;
   long int i;

   /* Mark beginning time */
   begin = clock();
   for (i=0;1;i++){
    digitalWrite(motorTerminal1, HIGH); // these logic levels create reverse direction
    digitalWrite(motorTerminal2, LOW);
    time_spent = (double)(clock() - begin) / CLOCKS_PER_SEC;
    if (time_spent> time_wanted)
      break;
   }
}

