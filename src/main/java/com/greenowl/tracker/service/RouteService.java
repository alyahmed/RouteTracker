package com.greenowl.tracker.service;

import com.greenowl.tracker.domain.Point;
import com.greenowl.tracker.domain.Route;
import com.greenowl.tracker.factory.PointFactory;
import com.greenowl.tracker.factory.RouteFactory;
import com.greenowl.tracker.repository.PointRepository;
import com.greenowl.tracker.repository.RouteRepository;
import com.greenowl.tracker.web.dto.ClientLocation;
import com.greenowl.tracker.web.dto.CreateRouteRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class RouteService {

    private static final Logger LOG = LoggerFactory.getLogger(RouteService.class);

    @Inject
    private RouteRepository routeRepository;

    @Inject
    private PointRepository pointRepository;

    public void save(CreateRouteRequest req){
        Route route = RouteFactory.create(req);
        Route savedRoute = routeRepository.save(route);
        savePoints(req, savedRoute);
    }


    private void savePoints(CreateRouteRequest req, Route route){
        List<ClientLocation> locations = req.getLocations();
        if(locations == null){
            return;
        }
        for (ClientLocation location : locations) {
            Point p = PointFactory.createPoint(location, route);
            pointRepository.save(p);
        }
        LOG.info("Saved {} points.", locations.size());
    }
}
