package com.greenowl.tracker.factory;

import com.greenowl.tracker.domain.Point;
import com.greenowl.tracker.domain.Route;
import com.greenowl.tracker.web.dto.ClientLocation;

/**
 * Created by Ahmed on 2015-08-20.
 */
public class PointFactory {

    public static Point createPoint(ClientLocation loc, Route route){
        Point point = new Point(loc.getLat(), loc.getLon(), loc.getSpeed()
                , loc.getAccuracy(), loc.getBearing(), loc.getAltitude());
        point.setRoute(route);
        return point;
    }
}
