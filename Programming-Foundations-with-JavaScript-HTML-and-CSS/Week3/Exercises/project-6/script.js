var fgImage= null;
var bgImage = null;
var canvas1 = document.getElementById("can1");
var canvas2 = document.getElementById("can2");
//--------------------------------
function loadForegroundImage(){
  var foregroundImage = document.getElementById("fginput");
  fgImage = new SimpleImage(foregroundImage);
  fgImage.drawTo(canvas1);
}
//--------------------------------
function loadBackgroundImage(){ 
  var backgroundImage = document.getElementById("bginput");
  bgImage = new SimpleImage(backgroundImage); 
  bgImage.drawTo(canvas2);
}
//--------------------------------
function doGreenScreen(){
    if(fgImage == null || !fgImage.complete()){
      alert("Foreground Image not Loaded");
      return;
    }
     if(bgImage == null || !bgImage.complete()){
      alert("Background Image not Loaded");
      return;
    }
    var output = new SimpleImage(fgImage.getWidth(),fgImage.getHeight());
  for(var px of fgImage.values()){
      if(px.getGreen() > px.getRed() + px.getBlue()){
          var x = px.getX();
          var y = px.getY();
          var bgpixel = bgImage.getPixel(x,y);
          output.setPixel(x,y,bgpixel);
      }
      else{
          output.setPixel(px.getX(),px.getY(),px);
      }
  } 
    clearCanvas();
    output.drawTo(canvas1);
}
function clearCanvas () {
  var context1 = canvas1.getContext("2d");
  context1.clearRect(0, 0, canvas1.width, canvas1.height);
  var context2 = canvas2.getContext("2d");
  context2.clearRect(0, 0, canvas2.width, canvas2.height);
}