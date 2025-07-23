package me.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Delivery {
    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery")
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    // Enumerated 어노테이션 값을 따로 지정하지 않을 경우 디폴트값은 ordinal 인데,
    // 이 경우 enum을 순차적인 숫자로 구분하므로 나중에 enum의 종류를 늘렸을 때 오류가 발생할 수 있음.
    // 오류 방지를 위해 string 사용이 권장됨.
    private DeliveryStatus status;  // READY, COMP
}
