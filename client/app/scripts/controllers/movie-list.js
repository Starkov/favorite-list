'use strict';

angular.module('clientApp')
  .controller('MovieListCtrl', MovieListCtrl);

MovieListCtrl.$inject = ['$scope','$uibModalInstance','selectedMovieList'];

function MovieListCtrl($scope,$uibModalInstance, selectedMovieList) {
  $scope.save = save;
  $scope.cancel = cancel;
  $scope.list = selectedMovieList;

  function save(list) {
    $uibModalInstance.close(list);
  }

  function cancel() {
    $uibModalInstance.dismiss('cancel');
  }
}
