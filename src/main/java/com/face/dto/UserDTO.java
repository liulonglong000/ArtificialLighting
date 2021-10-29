package com.face.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserDTO {
    private Integer id;
    private String username;
    private Integer role;
    private Integer deptId;
    private String deptName;
    private String phone;
    private String email;
    private Date createTime;
    private Date updateTime;
    private String truename;
    private String jobnumber;
}