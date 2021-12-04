package carroll.tbel.tripupappbackendv2.mapper;

import bstorm.akimts.api.models.dto.UserDTO;
import bstorm.akimts.api.models.entity.User;
import bstorm.akimts.api.models.form.UserForm;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    public UserDTO toDTO(User User){
        if( User == null )
            return null;

        return UserDTO.builder()
                .id(User.getId())
                .username(User.getUsername())
                .roles(User.getRoles())
                .accountNonExpired(User.isAccountNonExpired())
                .accountNonLocked(User.isAccountNonLocked())
                .credentialsNonExpired(User.isCredentialsNonExpired())
                .enabled(User.isEnabled())
                .build();
    }

    public User formToEntity(UserForm form){
        if( form == null )
            return null;

        User u = new User();
        u.setUsername(form.getUsername());
        u.setPassword(form.getPassword());
        u.setRoles(form.getRoles());

        return u;
    }

}
