var fileinput = document.getElementById("finput");
var canvas1 = document.getElementById("can1");
function upload(){
  var Image1 = new SimpleImage(fileinput);
  Image1.drawTo(canvas1);
}

function makeGrey(){
  var Image2 = new SimpleImage(fileinput);
  for (var pixel of Image2.values())
  {
    var ave = (pixel.getRed()+pixel.getGreen()+pixel.getBlue())/3;
    pixel.setRed(ave);
    pixel.setGreen(ave);
    pixel.setBlue(ave);
  }
  Image2.drawTo(canvas1);
}

function makeRed(){ 
  var image3 = new SimpleImage(fileinput);
  for(var px of image3.values()){
    px.setRed(255);
}
  image3.drawTo(canvas1);
}
function redHueFilter(){
  var Image4 = new SimpleImage(fileinput);
  for (var pixel of Image4.values())
  {
    var ave = (pixel.getRed()+pixel.getGreen()+pixel.getBlue())/3;
    if(ave < 128 ){
      pixel.setRed(ave*2);
      pixel.setGreen(0);
      pixel.setBlue(0);
    }
    else{
      pixel.setRed(255);
      pixel.setGreen(ave*2-255);
      pixel.setBlue(ave*2-255);
    }
  }
  Image4.drawTo(canvas1);
}
