package com.klabsy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private int Cno;
    private String Cname;
    private int Cpno;
    private int Ccredit;
}
