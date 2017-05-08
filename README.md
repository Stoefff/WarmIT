# WarmIT
System for remote control of the thermal head of a central heating radiator
## Requirement/Feature
The System contains the following modules:
### Arduino
- [ ] Connect ESP8266 WiFi Module to the Arduino over UARD
- [x] Connect DC motor(simulating the termal head) to the Arduino with H-Bridge
- [x] Arduino web client over the WiFi component
- [ ] Client connection to the server, handling commands for the remote control
### Server
- [ ] Server acting as router, forwarding commands from the mobile client to Arduino module 
- [ ] Redis database for storing the UID of an Arduino as key and its socket(int the meaning of IP:PORT) as value
- [ ] Handling requests from the mobile client
- [ ] Sending commands to the Arduino
### Mobile Client
- [x] Android client for remotely controlling Arduino through the server
- [x] Activity for entering UID (and maybe password) of the Arduino
- [x] Activity for controlling the temperature through a slider, also showing some stats
- [ ] Service for establishing connection and passing the data to the server
