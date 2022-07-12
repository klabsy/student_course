package com.klabsy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StuCourse {
    private int Sno;
    private int Cno;
    private String Cname;
    private String Sname;
    private int Ccredit;
    private int Grade;
}