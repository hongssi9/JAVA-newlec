window.onload = function(){

}

// ------------------------------------------------------

window.onload = function(){
    var section = document.getElementById("ex1");

    var submitButtons = section.getElementsByClassName("submit-button");
    var submitButton = submitButtons[0];
    
    
    
    submitButton.onclick = function(){
        console.log("test");
    }
};