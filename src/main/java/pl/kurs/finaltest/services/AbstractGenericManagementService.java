package pl.kurs.finaltest.services;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kurs.finaltest.exceptionhandling.exceptions.BadEntityException;
import pl.kurs.finaltest.models.Shape;
import java.util.Objects;
import java.util.Optional;

public abstract class AbstractGenericManagementService<T extends Shape, R extends JpaRepository<T, Long>> implements IManagementService<T> {

    protected R repository;


    public AbstractGenericManagementService(R repository) {
        this.repository = repository;
    }

    @Override
    public T add(T entity) {
        return repository.save(
                Optional.ofNullable(entity)
                        .filter(x -> Objects.isNull(x.getId()))
                        .orElseThrow(() -> new BadEntityException("Bad entity for persist")));
    }

}

