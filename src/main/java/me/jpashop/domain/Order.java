package me.jpashop.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders") // order는 sql 문법과 혼동될 수 있으므로 db 테이블 이름을 orders로 바꿔서 사용.
public class Order {
    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    // 연관관계의 주인 : 이 필드에 값을 세팅하면 member 테이블에 매핑된 foreign key가 변경됨.
    private Member member;

    private List<OrderItem> orderItems = new ArrayList<>();

    private Delivery delivery;

    private LocalDateTime orderDate;    // 주문시간

    private OrderStatus status; // 주문상태 [ORDER, CANCEL]
}
