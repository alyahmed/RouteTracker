package com.greenowl.tracker.factory;

import com.greenowl.tracker.domain.Point;
import com.greenowl.tracker.domain.Route;
import com.greenowl.tracker.web.dto.ClientLocation;
import com.greenowl.tracker.web.dto.CreateRouteRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RouteFactory {

    private static final Logger LOG = LoggerFactory.getLogger(RouteFactory.class);

    /**
     * Create a Route from a CreateRouteRequest.
     * @param req
     * @return
     */
    public static Route create(CreateRouteRequest req){
        List<ClientLocation> cps = req.getLocations();
        Route route = new Route();
        route.setDeviceId(req.getDeviceId());
        LOG.info("Creating new Route with deviceId = {}", req.getDeviceId());
        return route;
    }


}
