angular.module("listaTelefonica", ["ngMessages", "serialGenerator", "ui", "ngRoute","tmh.dynamicLocale"])
.config(function(tmhDynamicLocaleProvider) {
    tmhDynamicLocaleProvider.localeLocationPattern('/api/lib/angular/angular-locale_{{locale}}.js');
});