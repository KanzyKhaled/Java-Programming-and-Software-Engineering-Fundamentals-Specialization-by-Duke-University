
function makeGrey(Image2){
  for (var pixel of Image2.values())
  {
    var ave = (pixel.getRed()+pixel.getGreen()+pixel.getBlue())/3;
    pixel.setRed(ave);
    pixel.setGreen(ave);
    pixel.setBlue(ave);
  }
  return Image2;
}

function makeRed(image3){ 
  for(var px of image3.values()){
    px.setRed(255);
}
  return image3;
}
function redHueFilter(Image4){
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
  return Image4;
}


var image = new SimpleImage("chapel.png");
print(image);
print("after grey filter");
var greyImage = makeGrey(image);
print(greyImage);

print("after first Red filter");
var FirstRedImage = makeRed(image);
print(FirstRedImage);

print("after second Red filter");
var SecondRedImage = redHueFilter(image);
print(SecondRedImage);