######[Submission for SwampHacks 2016]
![alt text](http://i.imgur.com/zSvMjIc.png)
##Inspiration
We came across the idea of Iris while exploring the unique ability of the Clarifai API to analyze images and parse them for descriptive tags. We broke Clarifai down into an equation: Picture + Clarifai = Tags. So why not flip that equation on its head and use tags to "create" a picture? Through the use of descriptive tags, Iris aurally illustrates a scene in the minds of the blind. After all, a picture is worth a thousand words.
We also wanted to challenge ourselves to create an app that could be easily used by the visually impaired. By simply opening the app and sliding your device into your breast pocket with the camera peeking out, you're ready to go. Controls are simple with the Myo wristband, which enables the blind to interact with our app in a meaningful way.
Iris is a novel marriage of software and hardware, and we're excited for you to give it a try!

##What it does
Iris is an application built to help those who can’t see, experience vision in a new way. With a simple gesture, Iris captures an image and gathers data about the image. Then, this information is spoken directly to the user, without any physical interaction with the device.

##How we built it
Iris peeks out of the user’s breast pocket, waiting until needed. Using the Myo armband, the user makes a fist to capture an image through Iris. The image is saved on the device and analyzed using the Clarifai API asynchronously. When the API returns information about the image, Android’s text to speech functionality is used to read the attributes of the image to the user.

##Challenges we ran into
Most of the challenges we faced were because of the many asynchronous threads required to make Iris function. The camera, Clarifai API, text to speech, and loading screen all run separate threads, making it extremely difficult to implement them all at once. When working with the camera, we had to get around using the built in camera software by using Android’s hardware camera. The issue with this is that it is asynchronous, and we also have to handle raw image data, using byte streams and byte arrays. Our other significant issue was that the Myo armband became very unreliable at times, forcing us to recalibrate it before each use.

##Accomplishments that we're proud of
Our team is fairly new to asynchronous programming, so creating a working product was a large feat for us. We worked hard to create an application that was meant to help those who really need it, and we produced an application that does exactly that, despite its difficulties.

##What we learned
We really learned a great deal about the less common sides of Android development. File manipulation, camera usage, and asynchronous task management, were among these aspects. As CS majors we usually do not dabble on the hardware side of things, so working with the armband was also a big learning experience for us.
