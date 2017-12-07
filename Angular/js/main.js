var app = angular.module('dataRetrievalApp', []);
app.controller('repoController', function($scope, $http) {
    $http.get("https://api.github.com/orgs/sidgs/repos")
        .then(function (response) {$scope.repos = response.data;});
});