package com.javacode2020.chat03.demo4.dto;

import lombok.*;

/**
 * @author 水面行走
 * @date 2020/8/18 12:44 
 */
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserFindDto {
    private Long userId;
    private String userName;
}