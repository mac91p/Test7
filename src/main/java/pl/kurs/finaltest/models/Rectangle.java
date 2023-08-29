package pl.kurs.finaltest.models;

;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Component;
import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "rectangles")
@EntityListeners(AuditingEntityListener.class)
public class Rectangle  extends Shape implements Serializable {

    private double width;
    private double height;
    private double area;
    private double perimeter;

    public Rectangle() {
    }

    public Rectangle(String type, String createdBy, Instant createdAt, String lastModifiedBy, Instant lastModifiedAt, double width, double height, double area, double perimeter) {
        super(type, createdBy, createdAt, lastModifiedBy, lastModifiedAt);
        this.width = width;
        this.height = height;
        this.area = area;
        this.perimeter = perimeter;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(rectangle.width, width) == 0 && Double.compare(rectangle.height, height) == 0 && Double.compare(rectangle.area, area) == 0 && Double.compare(rectangle.perimeter, perimeter) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), width, height, area, perimeter);
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * width + 2 * height;
    }
}
