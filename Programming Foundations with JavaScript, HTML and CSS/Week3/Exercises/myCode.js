// write your code here
var bgimage = new SimpleImage("dinos.png");
var fgimage = new SimpleImage("drewRobert.png");
var output = new SimpleImage(fgimage.getWidth(), fgimage.getHeight());
// missing code
for(var px of fgimage.values()){
    if(px.getGreen() > px.getRed() + px.getBlue()){
        var x = px.getX();
        var y = px.getY();
        var bgpixel = bgimage.getPixel(x,y);
        output.setPixel(x,y,bgpixel);
    }
    else{
        output.setPixel(px.getX(),px.getY(),px);
    }
}

print(output);
//--------------------------------------------------------

var img = new SimpleImage(200,200);
for (var px of img.values()){
  var x = px.getX();
  var y = px.getY();
  if (x < img.getWidth()/2){
    px.setRed(255);
  }
  if (y>img.getHeight()/2){
    px.setBlue(255);
  }
  if(x >= img.getWidth()/2 && y <= img.getHeight()/2 ) {
    px.setGreen(255);
  }
}
print(img);
//--------------------------------------------------------
function setBlack(pixel){
    pixel.setRed(0);
    pixel.setGreen(0);
    pixel.setBlue(0);
    return pixel;
}

//---------------

function addBorder(image,thickness){
    height = image.getHeight();
    width = image.getWidth();
    for(var px of image.values()){
        if(px.getY() >= height - thickness || px.getY() <= thickness){
            setBlack(px);
        }
         if(px.getX() >= width - thickness || px.getX() <= thickness){
            setBlack(px);
        }
    }
    return image;
}

var image3 = new SimpleImage("astrachan.jpg");
// missing code
height = image3.getHeight();
width = image3.getWidth();
for(var px of image3.values()){
    if(px.getY() >= height - 40 || px.getY() <= 40){
        setBlack(px);
    }
     if(px.getX() >= width - 10 || px.getX() <= 10){
        setBlack(px);
    }
}
print(image3);

//-------------------------------------

var image = new SimpleImage("duke_blue_devil.png");
for(var px of image.values()){
    x= px.getX();
    y= px.getY();
    if(x>y){
        px.setRed(0);
        px.setBlue(0);
    }
}
print(image);
