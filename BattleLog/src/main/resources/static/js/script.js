console.log('script.js loaded');

window.addEventListener('load', function(e){
    console.log('Page loaded')
	init();
});

function init(){
	loadBattleLog();
}

function loadBattleLog(){
	//AJAX
let xhr = new XMLHttpRequest();
xhr.open('GET', 'api/battles');
xhr.onreadystatechange = function() {
	if(xhr.readyState === 4) {
		if (xhr.status === 200){
			let battleList = JSON.parse(xhr.responseText);
			console.log(battleList);
			displayBattleLog();
		}
	   else {
		       //todo display an error
	   }
	}
	
};
xhr.send();
}


function displayBattleLog(){
	//DOM
}