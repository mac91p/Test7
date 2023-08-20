package pl.kurs.finaltest.dto;


public class SquareDto extends ShapeDto{

    private Double length;
    private Double area;
    private Double perimeter;

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
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


