package com.greenowl.tracker.repository;

import com.greenowl.tracker.domain.Point;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Ahmed on 2015-08-20.
 */
public interface PointRepository extends JpaRepository<Point, Long>  {
}
