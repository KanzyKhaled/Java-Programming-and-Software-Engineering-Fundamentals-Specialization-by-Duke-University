var fileinput = document.getElementById("finput");

function upload(){
  
  var image1 = new SimpleImage(fileinput);
  var canvas1 = document.getElementById("can1");
  image1.drawTo(canvas1);
}

function makeGrey(){
  var image2 = new SimpleImage(fileinput);
  for (var pixel of image2.values())
  {
    var ave = (pixel.getRed()+pixel.getGreen()+pixel.getBlue())/3;
    pixel.setRed(ave);
    pixel.setGreen(ave);
    pixel.setBlue(ave);
  }
  var canvas2 = document.getElementById("can2");
  image2.drawTo(canvas2);
}
