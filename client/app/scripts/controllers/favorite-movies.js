'use strict';

angular.module('clientApp')
  .controller('FavoriteMoviesCtrl', FavoriteMoviesCtrl);

FavoriteMoviesCtrl.$inject = ['$scope', '$uibModal', 'movieListDataSource', '$state'];

function FavoriteMoviesCtrl($scope, $uibModal, movieListDataSource, $state) {
  init();
  $scope.open = open;
  $scope.search = search;
  $scope.showMoviesOf = showMoviesOf;
  $scope.saveOrUpdateMovieList = saveOrUpdateMovieList;

  function init() {
    movieListDataSource.loadAll().then(loadAllComplete);

    function loadAllComplete(result) {
      if (result && result.length > 0) {
        $scope.movieLists = result;
        showMoviesOf(result[0])
      }
    }
  }

  function open(movieList) {
    var configModal = {
      animation: $scope.animationsEnabled,
      templateUrl: 'views/movie-list.html',
      controller: 'MovieListCtrl',
      resolve: {
        selectedMovieList: function () {
          return movieList
        }
      }
    };

    var modalInstance = $uibModal.open(configModal);
    modalInstance.result.then(saveOrUpdateMovieList);
  }

  function saveOrUpdateMovieList(movieList) {
    if (!movieList.id) {
      movieListDataSource.save(movieList).then(init)
    } else {
      movieListDataSource.update(movieList).then(init);
    }
  }

  function search(query) {
    $state.transitionTo('favorite.search', {query: query});
    query='';
  }

  function showMoviesOf(movieList) {
    $scope.currentMovieList = movieList;
    $state.transitionTo("favorite.movieList", {id: movieList.id});
  }
}
