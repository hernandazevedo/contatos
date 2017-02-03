angular.module("listaTelefonica").factory("contatosAPI", function ($http, config) {
	var _getContatos = function () {
		return $http.get(config.baseUrlRest + "/contatos");
	};

	var _getContato = function (id) {
		// PHP: $http.get(config.baseUrl + "/contatosBackend.php?id=" + id)
		return $http.get(config.baseUrlRest + "/contatos/" + id);
	};

	var _saveContato = function (contato) {
		return $http.post(config.baseUrlRest + "/contatos", contato);
	};

	return {
		getContatos: _getContatos,
		getContato: _getContato,
		saveContato: _saveContato
	};
});