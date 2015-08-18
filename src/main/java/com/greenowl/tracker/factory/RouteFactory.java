package com.greenowl.tracker.factory;

import com.greenowl.tracker.domain.Point;
import com.greenowl.tracker.domain.Route;
import com.greenowl.tracker.web.dto.ClientLocation;
import com.greenowl.tracker.web.dto.CreateRouteRequest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RouteFactory {

    /**
     * Create a Route from a CreateRouteRequest.
     * @param req
     * @return
     */
    public static Route create(CreateRouteRequest req){
        List<ClientLocation> cps = req.getLocations();
        Set<Point> points = new HashSet<>();
        for(ClientLocation cp : cps){
            points.add(createPoint(cp));
        }
        return new Route(req.getDeviceId(), points);
    }


    private static Point createPoint(ClientLocation loc){
        return new Point(loc.getLat(), loc.getLon(), loc.getSpeed()
        , loc.getAccuracy(), loc.getBearing(), loc.getAltitude());
    }

}
