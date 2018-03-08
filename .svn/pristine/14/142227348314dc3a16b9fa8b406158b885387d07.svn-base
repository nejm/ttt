var myApp = angular.module('myApp', []);

myApp.controller('remoteController', function ($scope, $http) {

    $scope.initRemote = function () {
        $http.get("/Dashboard/remote/statistiques").then(function(response){
            $scope.statistiquesRemote = response.data;
        })
    }
    
    $scope.visualiseRemote = function(){
        var obj = {
            username : $scope.usernameRemote,
            id : $scope.chosenStat
        }
        $http.post("/Dashboard/remote/statistiques/visualize",obj).then(function(response){
            console.log(response.data);
        })
    }
});


