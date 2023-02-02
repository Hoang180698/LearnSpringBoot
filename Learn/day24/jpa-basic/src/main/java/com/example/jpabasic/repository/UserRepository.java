package com.example.jpabasic.repository;

import com.example.jpabasic.dto.UserDto;
import com.example.jpabasic.dto.UserInfo;
import com.example.jpabasic.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.Native;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByName(String name);

    List<User> findByNameContainingIgnoreCase(String name);

    List<User> findByAgeGreaterThan(int age);

    boolean existsByEmail(String email);

    long countByAgeBetween(int min, int max);

    Optional<User> findByEmail(String email);

    //JPQL Query : JPA Query Language
    @Query("select u from User u where u.name = ?1")
    List<User> findByNameJPQL(String name);

    @Query("select count(u) from User u where u.age between ?1 and ?2")
    long countByAgeBetweenJPQL(int min, int max);

    @Query("select u from User u where u.email = :emailValue")
    Optional<User> findByEmailJPQL(@Param("emailValue") String email);



    // Native Query
    @Query(nativeQuery = true, value = "select * from user u where u.name = ?1")
    List<User> findByNameNative(String name);

    //Update
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "update user u set u.name = ?2 where u.id = ?1")
    void updateNameUser(int id, String name);

    //Lấy Dto sử dụng JPQL;
//    @Query("select  new com.example.jpabasic.dto.UserDto(u.id, u.name, u.email) from User u where u.email like ?1")
    @Query("select new com.example.jpabasic.dto.UserDto(u.id, u.name, u.email) from User u where upper(u.email) like upper(concat('%', ?1, '%'))")
    List<UserDto> findByEmailContainingIgnoreCase(String email);

    // Lấy Entity
    List<User> findByNameStartingWith(String name);

    @Query(name = "findAllUserDto", nativeQuery = true)
    List<UserDto> findAllUserDto();

    // Sử dụng projection jpa
    List<UserInfo> findUserInfodByNameStartingWith(String prefix);
}
