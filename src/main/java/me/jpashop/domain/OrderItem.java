package me.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class OrderItem {
    @Id @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    private Item item;
    @ManyToOne
    @JoinColumn(name = "order_id")  // OrderItem 테이블에 생성될 foreign key 칼럼 이름을 order_id 로 지정한다는 뜻.
    private Order order;

    private int orderPrice; // 주문 가격
    private int count;  // 주문 수량


}
