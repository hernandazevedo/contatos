angular.module("listaTelefonica").controller("novoContatoCtrl", function ($scope, contatosAPI, serialGenerator, $location, operadoras,tmhDynamicLocale) {
	$scope.operadoras = operadoras.data;
	
	//tmhDynamicLocale.set('fr-fr');
	tmhDynamicLocale.set('pt-br');
	$scope.adicionarContato = function (contato) {
		contato.serial = serialGenerator.generate();
		contatosAPI.saveContato(contato).success(function (data) {
			delete $scope.contato;
			$scope.contatoForm.$setPristine();
			$location.path("/contatos");
		});
	};
});