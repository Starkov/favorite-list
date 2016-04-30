'use strict';

angular.module('clientApp')
  .factory('movieDataSource', movieDataSource);

movieDataSource.$inject = ['$http', 'remoteApi','remoteApiImg', 'key'];

function movieDataSource($http, remoteApi, remoteApiImg,key) {
  return {
    search: search,
    loadImg: loadImg
  };

  function search(string) {
    return $http.get(remoteApi + 'search/movie' + '?api_key=' + key + '&query=' + string+'&page=1')
      .then(searchComplete)
      .catch(searchFail);

    function searchComplete(response) {
      return response.data;
    }

    function searchFail() {
      alert("search is fail");
    }
  }
  function loadImg(path) {
    return $http.get(remoteApiImg + 'path' + '?api_key=' + key)
  }
}
