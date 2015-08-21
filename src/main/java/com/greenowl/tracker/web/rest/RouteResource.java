package com.greenowl.tracker.web.rest;

import com.greenowl.tracker.domain.Point;
import com.greenowl.tracker.domain.Route;
import com.greenowl.tracker.factory.RouteFactory;
import com.greenowl.tracker.repository.PointRepository;
import com.greenowl.tracker.repository.RouteRepository;
import com.greenowl.tracker.service.RouteService;
import com.greenowl.tracker.web.dto.CreateRouteRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.springframework.http.HttpStatus.OK;

@SuppressWarnings("SpringJavaAutowiringInspection")
@RestController
@RequestMapping("/api")
public class RouteResource {

    private static final Logger LOG = LoggerFactory.getLogger(RouteResource.class);

    @Inject
    private RouteRepository routeRepository;

    @Inject
    private RouteService routeService;


    @RequestMapping(value = "route", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody CreateRouteRequest req) throws IOException {
        routeService.
                save(req);
        return new ResponseEntity<>(OK);
    }


    @RequestMapping(value = "routes", method = RequestMethod.GET)
    public ResponseEntity<?> get() throws IOException {
        List<Route> routes = routeRepository.findAll();
        if(routes == null){
            routes = new ArrayList<>();
        }
        LOG.info("Returning routes {}", routes);
        return new ResponseEntity<>(routes, OK);
    }


    @RequestMapping(value = "route/points", method = RequestMethod.GET)
    public ResponseEntity<?> getPointsForRoute(@RequestParam final Long routeId) throws IOException {
        Route route = routeRepository.findOne(routeId);
        if(route == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Set<Point> points = route.getPoints();
        return new ResponseEntity<>(points, OK);
    }

}
