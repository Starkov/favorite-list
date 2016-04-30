'use strict';

angular
  .module('clientApp', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ui.router',
    'ui.bootstrap',
    'ngSanitize',
    'ngTouch'
  ])
  .constant('api', "http://localhost:9000/app/")
  .constant('remoteApi', "http://api.themoviedb.org/3/")
  .constant('remoteApiImg', "http://image.tmdb.org/t/p/w300/")
  .constant('key', "7a4de0fe5da237bdb52d1168dae8cd14")

  .config(function ($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise('favorite');

    $stateProvider
      .state('favorite', {
        url: '/favorite',
        templateUrl: 'views/favorite-movies.html',
        controller: 'FavoriteMoviesCtrl'
      })
      .state('favorite.search',{
        url: '/search/:query',
        templateUrl: 'views/movies.html',
        controller: 'MovieCtrl'
      })
      .state('favorite.movieList',{
        url: '/movieList/:id',
        templateUrl: 'views/movies.html',
        controller: 'MovieCtrl'
      })
  });
