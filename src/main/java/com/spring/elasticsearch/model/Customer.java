package com.spring.elasticsearch.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "test")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Customer {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private int age;

}
