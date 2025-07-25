package me.jpashop.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
// 값 타입을 정의할 때 사용. 다른 엔티티에 포함되어 사용될 수 있는 객체라는 의미.
// 독립적인 엔티티가 아니라 db에 테이블이 생성되지 않음.
// 값 타입 클래스의 필드들은 포함된 엔티티의 테이블에 컬럼으로 합쳐져 저장됨.
// 참고 : 값 타입은 변경 불가능 하게 설계해야 함.
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;

    // jpa 스펙상 필요한 기본 생성자.
    // jpa 구현 라이브러리가 객체를 생성할 때 리플랙션 같은 기술을 사용할 수 있도록 지원해야 하기 때문.
    protected Address() {
    }
    // setter 사용 없이 생성 당시에만 값을 지정. <- 변경 불가능
    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
