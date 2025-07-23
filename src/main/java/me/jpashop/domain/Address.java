package me.jpashop.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
// 내장 타입을 정의할 때 사용. 다른 엔티티에 포함되어 사용될 수 있는 객체라는 의미.
// 독립적인 엔티티가 아니라 db에 테이블이 생성되지 않음.
// 내장 타입 클래스의 필드들은 포함된 엔티티의 테이블에 컬럼으로 합쳐져 저장됨.
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;
}
