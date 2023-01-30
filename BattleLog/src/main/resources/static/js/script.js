console.log('script.js loaded');

window.addEventListener('load', function(e) {
	console.log('Page loaded');
	init();
});

function init() {
	var addBattleForm = document.getElementsByName('addBattleForm');
	var battleForm = document.getElementsByName('battleForm');
	var deleteBattleButton = document.getElementById('deleteBattleButton');
	var showBattle = document.getElementById('showBattle');
	var updateBattleForm = document.getElementsByName('updateBattleForm');
	loadBattles();
	
	
	document.battleForm.findBattle.addEventListener('click', function(event) {
		event.preventDefault();
		let battleId = document.battleForm.battleId.value;
		if (!isNaN(battleId) && battleId > 0) {
			getBattle(battleId);
		}
	});

	function getBattle(battleId) {
		console.log(battleId)

		let xhr = new XMLHttpRequest();
		xhr.open('GET', 'api/battles/' + battleId)
		xhr.onreadystatechange = function() {
			if (xhr.readyState === 4) {
				if (xhr.status === 200 || 201) {
					let battle = JSON.parse(xhr.repsonseText);
					showBattle(battle);
				}
				else {
					displayError('Battle does not exist');
				}
			}
		};
		xhr.send();
	}

	function displayError(message) {
		let div = document.getElementById('battle');
		div.textContent = message;
	}

	document.addBattleForm.addBattleButton.addEventListener('click', function(evt) {
		evt.preventDefault();
		console.log('creating battle')
		let newBattle = {
			kills: document.addBattleForm.kills.value,
			captures: document.addBattleForm.captures.value,
			firePower: document.addBattleForm.firePower.value,
			points: document.addBattleForm.points.value,
			win: document.addBattleForm.win.value,
			mvpsss: document.addBattleForm.mvpsss.value,
			mvpss: document.addBattleForm.mvpss.value,
			mvps: document.addBattleForm.mvps.value
		};
		console.log(newBattle);
		addBattle(newBattle);

	});
}
function addBattle(newBattle) {
	let xhr = new XMLHttpRequest();
	xhr.open('POST', 'api/battles');
	xhr.onreadystatechange = funciton(); {
		if (xhr.readyState === 4) {
			if (xhr.status === 200) {
				let battle = JSON.parse(xhr.repsonseText);
				showBattle(battle);
			}
			else {
				displayError("Error occured when creating battle" + xhr.status);
			}
		}
	};
	xhr.setRequestHeader("Content-type", "application/json");
	xhr.send(JSON.stringify(newBattle));


	function showBattle(battle) {
		let battleDataDiv = document.getElementById('battle');
		battleDataDiv.textContent = '';

		let ul = document.createElement('ul');
		battleDataDiv.appendChild('ul');
		li = document.createElement('li');
		li.textContent = battle.kills;
		li = document.createElement('li');
		li.textContent = battle.win;
		li = document.createElement('li');
		li.textContent = battle.mvpsss;
		li = document.createElement('li');
		li.textContent = battle.mvpss;
		li = document.createElement('li');
		li.textContent = battle.mvps;
		li = document.createElement('li');
		li.textContent = battle.captures;
		li = document.createElement('li');
		li.textContent = battle.points;
		li = document.createElement('li');
		li.textContent = battle.firePower;
		li = document.createElement('li');
		li.textContent = battle.battleId;
		ul.appendChild('li');
	}

}

function deleteBattleButton() {

	let battleId = document.getElementById("showBattle").firstElementChild.textContent;
	console.log(battleId);
	deleteBattle(battleId);

}

function deleteBattle(battleId) {
	let xhr = new XMLHttpRequest();

	xhr.open('DELETE', 'api/battles/' + battleId);

	xhr.onreadystatechange = function() {
	if (xhr.readyState === 4) {
	if (xhr.status === 204) {
	} else if (xhr.status === 404) {
		console.log(xhr.responseText);
	}
		}
	};

	xhr.send();
}

function loadBattles() {
	let xhr = new XMLHttpRequest();
	xhr.open('GET', 'api/battles');
	xhr.onreadystatechange = function() {
	if (xhr.readyState === 4) {
	if (xhr.status === 200) {
	showBattle(JSON.parse(xhr.responseText));
	}
		else {
	console.error("Error can not load: " + xhr.status);
			}
		}
	}
	xhr.send();

}

document.updateBattleButton.getElementByName('updateBattleButton');
updateBattleButton.addEventListener('click', function(evt) {
		evt.preventDefault();
		console.log('updating battle')
		let updatedBattle = {
			kills: document.updateBattleForm.kills.value,
			captures: document.updateBattleForm.captures.value,
			firePower: document.updateBattleForm.firePower.value,
			points: document.updateBattleForm.points.value,
			win: document.updateBattleForm.win.value,
			mvpsss: document.updateBattleForm.mvpsss.value,
			mvpss: document.updateBattleForm.mvpss.value,
			mvps: document.updateBattleForm.mvps.value
		};
		console.log(newBattle);
		updateBattleButton(updatedBattle);

	});

function updatedBattleButton(updatedBattle) {
	let xhr = new XMLHttpRequest();
	xhr.open('PUT', 'api/battles' + battleId);
	xhr.onreadystatechange = funciton(); {
		if (xhr.readyState === 4) {
			if (xhr.status === 200) {
				let battle = JSON.parse(xhr.repsonseText);
				showBattle(battle);
			}
			else {
				displayError("Error occured when updating battle" + xhr.status);
			}
		}
	};
	xhr.setRequestHeader("Content-type", "application/json");
	xhr.send(JSON.stringify(updatedBattle));
	}
