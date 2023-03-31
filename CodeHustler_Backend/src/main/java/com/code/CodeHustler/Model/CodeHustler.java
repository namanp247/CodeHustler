package com.code.CodeHustler.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "code")
public class CodeHustler {
    @Id
    private String id;
    private String dataStructure;
    private String title;
    private String difficulty;
    private String problemstatement;
    private Object example ;
    private String task;
    private Object links;
    private String solutionexplanation;
    private Object solution ;
    private Object companiesasked;



}

