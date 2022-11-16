package com.example.courseapi.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UpsertCourseRequest {
    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Description is required")
    @Size(min = 50, message = "Length password must greater 50")
    private String description;

    @NotBlank(message = "Type is required")
    private String type;

    private List<String> topics;
    private String thumbnail;
    private int userId;
}
