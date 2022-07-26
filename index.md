## Welcome to My home security API

There is a API concept - you application should support this kind of devices 

 - Sensor
 - Camera
 - Sound
 - Light
 
 There is some kind of data coming from sourecs
 
 - on or off
 - http link to image
 - int value
 - float value

### Data started
{
  "version": "0.1alpha",
  "name": "My house",
  "house": [
    {
      "room": "Kitchen",
      "type": "Sensor",
      "subtype": "switch",
      "value": "on"
    },
    {
      "room": "Toilet",
      "type": "Camera",
      "subtype": "onetime",
      "value": "https://images.unsplash.com/photo-1589824783837-6169889fa20f?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8"
    },
    {
      "room": "Kitchen",
      "type": "Camera",
      "subtype": "onetime",
      "value": "https://www.wrenkitchens.com/blog/wp-content/uploads/2021/12/2022-kitchen-design-trends-dark-kitchen-2048x1366.jpg"
    },
    {
      "room": "Lounge",
      "type": "Sound",
      "subtype": "level",
      "value": "2.34"
    },
    {
      "room": "Toilet",
      "type": "Sound",
      "subtype": "onetime",
      "value": "off"
    },
    {
      "room": "Corridor",
      "type": "Light",
      "subtype": "level",
      "value": "7"
    }
  ]
}
### Data ended
