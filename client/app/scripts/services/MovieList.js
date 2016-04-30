'use strict';

angular.module('clientApp')
  .factory('movieListDataSource', movieListDataSource);

movieListDataSource.$inject = ['$http', 'api'];

function movieListDataSource($http, api) {
  return {
    load: load,
    loadAll: loadAll,
    remove: remove,
    update: update,
    save: save
  };


  function load(movieListId) {
    return $http.get(api + 'movieList/id-' + movieListId)
      .then(getMovieListComplete)
      .catch(getMovieListFail);

    function getMovieListComplete(response) {
      return response.data;
    }

    function getMovieListFail(error) {
      alert("get movie list fail: " + error.data);
    }
  }

  function remove() {
    $http.delete(api + 'movieList' + id);
  }

  function update(item) {
    return $http.put(api + 'movieList', item);
  }

  function save(item) {
    return $http.post(api + 'movieList', item);
  }

  function loadAll() {
    return $http.get(api + 'movieList/all')
      .then(getMovieListComplete)
      .catch(getMovieListFail);

    function getMovieListComplete(response) {
      return response.data;
    }

    function getMovieListFail(error) {
      alert("load movie lists fail: " + error.data);
    }
  }
}
