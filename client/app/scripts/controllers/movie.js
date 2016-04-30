'use strict';
angular.module('clientApp')
  .controller('MovieCtrl', MovieCtrl);

MovieCtrl.$inject = ['$scope', '$stateParams', '$state', '$filter', 'movieDataSource', 'remoteApiImg', 'key'];

function MovieCtrl($scope, $stateParams, $state, $filter, movieDataSource, remoteApiImg, key) {
  if ($stateParams.query) {
    movieDataSource.search($stateParams.query).then(function (data) {
      $scope.movies = data.results;
    });
  }
  if ($stateParams.id) {
    var currentMovieList = $scope.$parent.currentMovieList;
    if (!currentMovieList) {
      $state.transitionTo('favorite');
    } else {
      $scope.movies = $scope.$parent.currentMovieList.movies;
    }
  }
  $scope.remoteApiImg = remoteApiImg;
  $scope.key = key;
  $scope.hasImg = hasImg;
  $scope.addToList = addToList;


  function addToList(index) {
    var movie = $scope.movies[index];
    var id = $scope.$parent.currentMovieList.id;
    var movieListArr = $filter('filter')($scope.$parent.movieLists, {id: id}, true);
    if (movieListArr && movieListArr.length > 0 && movieListArr[0].movies) {
      movieListArr[0].movies.push(movie)
    }
  }

  function hasImg(string) {
    if (string) {
      return true;
    }
    return false;
  }
}
