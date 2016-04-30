'use strict';

describe('Controller: ShowMoviesCtrl', function () {

  // load the controller's module
  beforeEach(module('clientApp'));

  var ShowMoviesCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ShowMoviesCtrl = $controller('ShowMoviesCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(ShowMoviesCtrl.awesomeThings.length).toBe(3);
  });
});
