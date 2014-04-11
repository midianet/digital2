
jQuery( function(j) {
	j(".somenteNumeros").soNumeros();
});

( function($) {
	
	function verificarTeclasFuncionais(e) {
		var key = (e.keyCode ? e.keyCode : e.which);
		return key == 8 || key == 9 || (key >= 35 && key <= 40) || key == 32 || key == 13 || key == 46;
	}

	function verificarApenasNumeros(e) {
		var key = (e.keyCode ? e.keyCode : e.which);
		return verificarTeclasFuncionais(e) || (key >= 48 && key <= 57) || (key >= 96 && key <= 105);
	}
	
	$.fn.soNumeros = function() {
		
		function apenasDigitos(e) {
			 if(e.keyCode == 37 || e.keyCode == 39 || e.keyCode == 46 || e.keyCode == 8) { 
			}else {
				this.value = this.value.replace(/\D/g, '');
			 }
		}
		
		$(this).bind('keydown'  ,apenasDigitos);
		$(this).bind('keyup'    ,apenasDigitos);
		$(this).bind('change'   ,apenasDigitos);
		$(this).bind('keypress' ,apenasDigitos);
		$(this).bind('blur'     ,apenasDigitos);
		$(this).bind('mouseout' ,apenasDigitos);
		$(this).bind('mouseover',apenasDigitos);
		$(this).bind('mouseup'  ,apenasDigitos);
		
	};

})(jQuery);