	function agregarComanda2(){
		if(document.getElementById('Comanda_2').style.display === "none"){
			document.getElementById('Comanda_2').style.display = "inline";
		}
		else if(document.getElementById('Comanda_3').style.display === "none"){
			document.getElementById('Comanda_3').style.display = "inline";
		}
		else if(document.getElementById('Comanda_4').style.display === "none"){
			document.getElementById('Comanda_4').style.display = "inline";
		}
		else if(document.getElementById('Comanda_5').style.display === "none"){
			document.getElementById('Comanda_5').style.display = "inline";
		}
	}

	function quitarComanda2(){
		if(document.getElementById('Comanda_5').style.display === "inline"){
			document.getElementById('Comanda_5').style.display = "none";
			$("#tipoProducto_5").val(-1);
			$("#Producto_5").val(-1);
			document.getElementById('Cantidad_5').value = "";
		}
		else if(document.getElementById('Comanda_4').style.display === "inline"){
			document.getElementById('Comanda_4').style.display = "none";
			$("#tipoProducto_4").val(-1);
			$("#Producto_4").val(-1);
			document.getElementById('Cantidad_4').value = "";
		}
		else if(document.getElementById('Comanda_3').style.display === "inline"){
			document.getElementById('Comanda_3').style.display = "none";
			$("#tipoProducto_3").val(-1);
			$("#Producto_3").val(-1);
			document.getElementById('Cantidad_3').value = "";
		}
		else if(document.getElementById('Comanda_2').style.display === "inline"){
			document.getElementById('Comanda_2').style.display = "none";
			$("#tipoProducto_2").val(-1);
			$("#Producto_2").val(-1);
			document.getElementById('Cantidad_2').value = "";
		}
	}