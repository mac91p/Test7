package pl.kurs.finaltest.models;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Component;
import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "squares")
@EntityListeners(AuditingEntityListener.class)
public class Square extends Shape implements Serializable {

    private double length;
    private double area;
    private double perimeter;

    public Square() {
    }

    public Square(String type, String createdBy, Instant createdAt, String lastModifiedBy, Instant lastModifiedAt, double length, double area, double perimeter) {
        super(type, createdBy, createdAt, lastModifiedBy, lastModifiedAt);
        this.length = length;
        this.area = area;
        this.perimeter = perimeter;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getArea() {
        return area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    @Override
    public double calculateArea() {
        return length * length;
    }

    @Override
    public double calculatePerimeter() {
        return 4 * length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Square square = (Square) o;
        return Double.compare(square.length, length) == 0 && Double.compare(square.area, area) == 0 && Double.compare(square.perimeter, perimeter) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), length, area, perimeter);
    }
}
