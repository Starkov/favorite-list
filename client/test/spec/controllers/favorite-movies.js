'use strict';

describe('Controller: FavoriteMoviesCtrl', function () {

  // load the controller's module
  beforeEach(module('clientApp'));

  var FavoriteMoviesCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    FavoriteMoviesCtrl = $controller('FavoriteMoviesCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(FavoriteMoviesCtrl.awesomeThings.length).toBe(3);
  });
});
