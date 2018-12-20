# mimicApp

Es una aplicacion en Android de un juego de digalo con mimica.
Se listan peliculas y el equipo tiene que adivinar la pelicula 


Solucion a problema con timer 
  CountDownTimer waitTimer;
  
  
     waitTimer = new CountDownTimer(60000, 300) {

       public void onTick(long millisUntilFinished) {
          //called every 300 milliseconds, which could be used to
          //send messages or some other action
       }

       public void onFinish() {
          //After 60000 milliseconds (60 sec) finish current 
          //if you would like to execute something when time finishes          
       }
     }.start();
to stop the timer early:

     if(waitTimer != null) {
         waitTimer.cancel();
         waitTimer = null;
     }
