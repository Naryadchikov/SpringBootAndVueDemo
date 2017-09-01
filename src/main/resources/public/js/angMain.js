var app = angular.module("springDemo", []);

app.controller("appController", function ($scope, $http) {
    $scope.websites = [];

    $http.get('http://localhost:8090/api/stackOverflow').then(function (response) {
        $scope.websites = response.data;
    });
});