package com.greenowl.tracker.web.rest;

import com.greenowl.tracker.domain.Route;
import com.greenowl.tracker.factory.RouteFactory;
import com.greenowl.tracker.repository.RouteRepository;
import com.greenowl.tracker.web.dto.CreateRouteRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api")
public class RouteResource {

    private static final Logger LOG = LoggerFactory.getLogger(RouteResource.class);

    @Inject
    private RouteRepository routeRepository;

    @RequestMapping(value = "route", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody CreateRouteRequest req) throws IOException {
        Route route = RouteFactory.create(req);
        routeRepository.save(route);
        LOG.info("Saved.");
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


}
