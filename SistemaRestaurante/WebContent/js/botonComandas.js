	function agregarComanda(){
		if(document.getElementById('Comanda2').style.display === "none"){
			document.getElementById('Comanda2').style.display = "inline";
		}
		else if(document.getElementById('Comanda3').style.display === "none"){
			document.getElementById('Comanda3').style.display = "inline";
		}
		else if(document.getElementById('Comanda4').style.display === "none"){
			document.getElementById('Comanda4').style.display = "inline";
		}
		else if(document.getElementById('Comanda5').style.display === "none"){
			document.getElementById('Comanda5').style.display = "inline";
		}
	}

	function quitarComanda(){
		if(document.getElementById('Comanda5').style.display === "inline"){
			document.getElementById('Comanda5').style.display = "none";
			document.getElementById('Cantidad5').value = "";
		}
		else if(document.getElementById('Comanda4').style.display === "inline"){
			document.getElementById('Comanda4').style.display = "none";
			document.getElementById('Cantidad4').value = "";
		}
		else if(document.getElementById('Comanda3').style.display === "inline"){
			document.getElementById('Comanda3').style.display = "none";
			document.getElementById('Cantidad3').value = "";
		}
		else if(document.getElementById('Comanda2').style.display === "inline"){
			document.getElementById('Comanda2').style.display = "none";
			document.getElementById('Cantidad2').value = "";
		}
	}