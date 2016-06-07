///reference path=angular.js />
var app=angular
               .module("mymodule",[])
               .controller("mycontroller",function($http,$scope){
                     $http({
                    method:"GET",
                    url:"${pageContext.request.contextPath}/result/angu.do"})
                     .then(function(response){
                      $scope.employee=response.data;
                         });
                   });