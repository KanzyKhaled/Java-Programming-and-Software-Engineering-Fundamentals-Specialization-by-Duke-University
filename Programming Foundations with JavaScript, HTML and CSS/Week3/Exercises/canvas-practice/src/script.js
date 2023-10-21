function doBlue(){
  var can1 = document.getElementById("can1"); 
  can1.style.backgroundColor ="blue";
  var context = can1.getContext("2d");
  context.fillStyle = "yellow";
  context.fillRect(10,10,60,60);
  context.fillRect(80,10,60,60);
  
  context.fillStyle = "black";
  context.font = "20px Arial";
  context.fillText("Hello", 15,45);
  }

function doRed(){
   var can2 = document.getElementById("can2"); 
   can2.style.backgroundColor ="red";
  }