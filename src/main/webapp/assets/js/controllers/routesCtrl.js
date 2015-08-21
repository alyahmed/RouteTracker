'use strict';
/**
 * controllers for GoogleMap
 * AngularJS Directive
 */
app.controller('RoutesCtrl', ["$scope", "$http", function ($scope, $http) {

    $scope.loading = false;
    $scope.polylines = null;
    $scope.markers = [];
    $scope.routes = [];

    $scope.map = {
        center: {latitude: 43.6830971, longitude: -79.8196407},
        zoom: 12,
        markers: $scope.markers,
        events: null
    };


    $scope.getPoints = function(){
        $scope.loading = true;
        $http.get('api/route/points?routeId=8').then(function (response) {
            $scope.points = response.data;
            $scope.drawMarkers($scope.points);
        }, function (response) {
            // TODO: handle the error somehow
            alert("Error");
        }).finally(function () {
            // called no matter success or failure
            $scope.loading = false;
        });
    };

    $scope.drawMarkers = function(points){
        for(var i = 0; i < points.length; i++){
            var p = points[i];
            $scope.pushMarker(p.lat, p.lon, i, i);
        }
    };


    $scope.pushMarker = function (lat, lng, title, id) {
        $scope.markers.push({
            idKey: id,
            coords: {
                latitude: lat,
                longitude: lng
            },
            title: title,
            events: $scope.markerEvents,
            options: {
                icon: {
                    scaledSize: new google.maps.Size(30, 30)
                }
            }
        });
    };

    /**
     * All Event listeners for markers on the primary google map.
     * @type {{click: Function}}
     */
    $scope.markerEvents = {
        //marker Events
        click: function (marker, eventName, args) {
            var title = marker.model.title;
            if (!(title)) {
                title = "N/A";
            }
            alert(title);
        }
    }; //Marker Only Events


    console.log("finished loading RoutesCtrl.");
}]);