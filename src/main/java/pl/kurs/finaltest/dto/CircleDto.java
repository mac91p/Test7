package pl.kurs.finaltest.dto;


public class CircleDto extends ShapeDto {

    private Double radius;
    private Double area;
    private Double perimeter;

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(Double perimeter) {
        this.perimeter = perimeter;
    }
}