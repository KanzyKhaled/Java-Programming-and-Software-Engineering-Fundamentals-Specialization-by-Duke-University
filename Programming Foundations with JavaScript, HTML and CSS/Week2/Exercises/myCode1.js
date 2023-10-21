// write your code here
var image = new SimpleImage("chapel.png");

// missing code
for(var px of image.values()){
    px.setRed(255);
}

print(image);
//-------------------------------
for(var px of image.values()){
    px.setRed(0);
}

print(image);
//--------------------------------
var image2 = new SimpleImage("eastereggs.jpg");

// missing code
for(var px of image2.values()){
    if(px.getRed() > 70){
        px.setRed(70)
    }
}
print(image2);
//-------------------------------
var image3 = new SimpleImage("astrachan.jpg");

// missing code
height = image3.getHeight();
for(var px of image3.values()){
    if(px.getY() >= height - 10){
        px.setRed(0);
        px.setGreen(0);
        px.setBlue(0);
    }
}
print(image3);
//-------------------------------
var image4 = new SimpleImage("chapel.png");
for(var px of image4.values()){
    if(px.getY() <= 50 && px.getX() <= 50){
        px.setRed(0);
        px.setGreen(255);
        px.setBlue(0);
    }
}

print(image4)
//------------------------------

function topRightCorner(cornerWidth, cornerHeight, someImage, red, green, blue) {

    // missing code
    heigth = someImage.getHeight();
    width = someImage.getWidth();
    for(var px of someImage.values()){
        if(px.getY() <= cornerHeight && px.getX() > width - cornerWidth){
            px.setRed(red);
            px.setGreen(green);
            px.setBlue(blue);
        }
    }
    return someImage;
}

var picture = new SimpleImage("chapel.png");
var result = topRightCorner(30,60,picture,255,255,0);
var result2 = topRightCorner(60,30,result,0,0,255);
var result3 = topRightCorner(30,30,result2,0,255,0);
print(result3);
//---------------------------------------------------

function changeRed(width,height){
    var picture = new SimpleImage(width,height);
    var red = 0;
    
    for(var px of picture.values()){

        px.setRed(red);
        px.setGreen(0);
        px.setBlue(0);
        
        if(px.getRed()<255){
            red = red+1;
        }
        if(px.getRed()==255){
            red = 0;
        }

        
    }
    
    return picture;
}

var redImage = changeRed(256,200);
print (redImage);

//----------------------------------

var image = new SimpleImage("hilton.jpg");
var width = image.getWidth();

for (var px of image.values()){
    var x = px.getX()
    if(x < width/3){
        px.setRed(255);
    }
    else if( x < 2*(width/3)){
        px.setGreen(255);
    }
     else{
        px.setBlue(255);
    }
}
print(image);
//--------------------------------

function swapRedGreen(pixel){
    
    var newGreen = pixel.getRed();
    var newRed = pixel.getGreen();
    pixel.setRed(newRed);
    pixel.setGreen(newGreen);
    return pixel;
    
}