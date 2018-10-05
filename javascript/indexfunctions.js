// normal variables
// setting controls into variables
var OpenModalButton = document.getElementById("button_1");
var MoveToPageTwoButton = document.getElementById("TextinArrow");
var MoveToPageThreeButton = document.getElementById("TextinArrow2");
var MovetoPageFourButton = document.getElementById("TextinArrow3");

// adding an addEventListener for the Event On click
OpenModalButton.addEventListener("click",JoinIn);
MoveToPageTwoButton.addEventListener("click",ToPage2);
MoveToPageThreeButton.addEventListener("click",ToPage3);
MovetoPageFourButton.addEventListener("click",ToPage4);



// functions of the page

function JoinIn(){
  document.querySelector("#backdrop").style.display="flex";
  document.querySelector(".Page1").style.display="flex";
}

function ToPage2(){
  //window.location.assign("https://www.google.ca");
  document.querySelector(".Page1").style.display="none";
  document.querySelector(".Page2").style.display="flex";
}

function ToPage3(){
  document.querySelector(".Page2").style.display="none";
  document.querySelector(".Page3").style.display="flex";
}
function ToPage4(){
  window.location.assign("https://www.google.ca");
}
