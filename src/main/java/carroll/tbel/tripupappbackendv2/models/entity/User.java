package carroll.tbel.tripupappbackendv2.models.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Builder
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles;

    @Column(nullable = false)
    private boolean accountNonExpired = true;
    @Column(nullable = false)
    private boolean accountNonLocked = true;
    @Column(nullable = false)
    private boolean credentialsNonExpired = true;
    @Column(nullable = false)
    private boolean enabled = true;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map( SimpleGrantedAuthority::new )
                .collect(Collectors.toList());
    }
}
