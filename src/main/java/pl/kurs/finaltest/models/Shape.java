package pl.kurs.finaltest.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "shapes")
public abstract class Shape implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    @Column(nullable = false)
    private String type;
    @Version
    private Long version;
    @Column(nullable = false)
    private String createdBy;
    @Column(nullable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private String lastModifiedBy;
    @Column(nullable = false)
    private LocalDateTime lastModifiedAt;
    private double area;
    private double perimeter;

    public Shape() {
    }

    public Shape(String type, String createdBy, LocalDateTime createdAt, String lastModifiedBy, LocalDateTime lastModifiedAt) {
        this.type = type;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.lastModifiedBy = lastModifiedBy;
        this.lastModifiedAt = lastModifiedAt;
        this.area = calculateArea();
        this.perimeter = calculatePerimeter();
    }

    public abstract double calculateArea();

    public abstract double calculatePerimeter();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public LocalDateTime getLastModifiedAt() {
        return lastModifiedAt;
    }

    public void setLastModifiedAt(LocalDateTime lastModifiedAt) {
        this.lastModifiedAt = lastModifiedAt;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double diameter) {
        this.area = diameter;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shape shape = (Shape) o;
        return Objects.equals(type, shape.type) && Objects.equals(createdBy, shape.createdBy) && Objects.equals(createdAt, shape.createdAt) && Objects.equals(lastModifiedBy, shape.lastModifiedBy) && Objects.equals(lastModifiedAt, shape.lastModifiedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, createdBy, createdAt, lastModifiedBy, lastModifiedAt);
    }
}
