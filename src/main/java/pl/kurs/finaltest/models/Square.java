package pl.kurs.finaltest.models;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "squares")
@EntityListeners(AuditingEntityListener.class)
public class Square extends Shape implements Serializable {

    private double length;

    public Square() {
    }

    public Square(String type, String createdBy, Instant createdAt, String lastModifiedBy, Instant lastModifiedAt, double length) {
        super(type, createdBy, createdAt, lastModifiedBy, lastModifiedAt);
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Square square = (Square) o;
        return Double.compare(square.length, length) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), length);
    }
}
