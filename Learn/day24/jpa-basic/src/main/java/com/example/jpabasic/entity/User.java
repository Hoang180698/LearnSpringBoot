package com.example.jpabasic.entity;

import com.example.jpabasic.dto.UserDto;
import jakarta.persistence.*;
import lombok.*;

import javax.lang.model.element.Name;
import java.util.List;

@SqlResultSetMappings(value = {
        @SqlResultSetMapping(
                name = "listUserDto",
                classes = @ConstructorResult(
                        targetClass = UserDto.class,
                        columns = {
                                @ColumnResult(name = "id", type = Integer.class),
                                @ColumnResult(name = "name", type = String.class),
                                @ColumnResult(name = "email", type=String.class)
                        }
                )
        )
})
@NamedNativeQuery(
        name = "findAllUserDto",
        resultSetMapping = "listUserDto",
        query = "select id, name, email from user ")

@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity(name = "User")
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "age")
    private int age;
}
