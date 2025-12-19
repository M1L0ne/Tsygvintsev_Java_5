package tsygvintsev;

import java.util.*;
import java.util.stream.Stream;

public class Polyline {
    private final List<Point> points;

    public Polyline(List<Point> points) {
        this.points = new ArrayList<>(points);
    }

    @Override
    public String toString() {
        return "Линия [" + String.join(", ", points.stream()
                .map(Point::toString)
                .toList()) + "]";
    }
}