package me.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member")
    // 연관관계의 주인 설정.
    // 연관관계의 주인은 order 클래스에 있는 member 필드
    // mappedBy 는 해당 필드에 의해 매핑된 거울이라는 뜻. (읽기 전용)
    // 이 필드에 변경이 생겨도 연관관계의 주인 테이블의 foreign key는 변경되지 않음.
    private List<Order> orders = new ArrayList<>();
}
