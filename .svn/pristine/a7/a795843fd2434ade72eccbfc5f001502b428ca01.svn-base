var uploadApp = angular.module('uploadApp', ['ngFileUpload']);
uploadApp.directive('fileModel', ['$parse', function ($parse) {
        return {
            restrict: 'A',
            link: function (scope, element, attrs) {
                var model = $parse(attrs.fileModel);
                var modelSetter = model.assign;
                element.bind('change', function () {
                    scope.$apply(function () {
                        modelSetter(scope, element[0].files[0]);
                    });
                });
            }
        };
    }]);
uploadApp.service('fileUpload', ['$http', function ($http) {
        this.uploadFileToUrl = function (file, uploadUrl) {
            var fd = new FormData();
            fd.append('file', file);
            $http.post(uploadUrl, fd, {
                transformRequest: angular.identity,
                headers: {'Content-Type': undefined}
            }).then(function (response) {
                console.log(response);
            });
        }
    }]);
uploadApp.controller('uploadController', ['$scope', 'fileUpload', '$http', 'Upload', function ($scope, fileUpload, $http, Upload) {
        $scope.value = 0;
        $scope.uploadFile = function () {
//            var file = $scope.myFile;
//            var uploadUrl = "http://localhost:8080/Dashboard/continueFileUpload";
//            fileUpload.uploadFileToUrl(file, uploadUrl);

            Upload.upload({
                url: 'http://localhost:8080/Dashboard/continueFileUpload',
                fields: {'name': $scope.myFile.name},
                file:  $scope.myFile
            }).progress(function (evt) {
                var progressPercentage = parseInt(100.0 * evt.loaded / evt.total);
                $scope.value = progressPercentage;
                console.log('progress: ' + progressPercentage + '% ' + evt.config.file.name);
            }).success(function (data, status, headers, config) {
                console.log('file ' + config.file.name + 'uploaded. Response: ' + data);
            });
        };

        $scope.showFiles = function () {
            $scope.data = {
                name: "C:/Demo/"
            }
            $http.post("http://localhost:8080/Dashboard/showFileUpload", $scope.data).then(function (response) {
                console.log(response.data);
                $scope.listOfFiles = response.data;
            })
        };

        $scope.getFile = function (file) {
            $http.get("http://localhost:8080/Dashboard/showFileByName", file)
                    .then(function (response) {
                        //console.log(response.data);
                    })
        };
    }]);




