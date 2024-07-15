package com.lcwd.user.service.repositories;

import com.lcwd.user.service.entities.User;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, String> {
    //TODO: Add additional custom method
}
