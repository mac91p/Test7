package pl.kurs.finaltest.security;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class AuditorAwareImpl implements AuditorAware<String> {

    private final AuthenticationProvider authenticationProvider;

    public AuditorAwareImpl(AuthenticationProvider authenticationProvider) {
        this.authenticationProvider = authenticationProvider;
    }


    @Override
    public Optional<String> getCurrentAuditor() {
        String username = authenticationProvider.getUsername();
        return Optional.ofNullable(username);
    }
}
