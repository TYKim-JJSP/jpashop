package me.jpashop.domain.item;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
// 상속관계 전략은 부모 클래스에 지정한다. InheritanceType은 single table, table per class, joined가 있다.
// 각 전략마다 장단점이 있다.
@DiscriminatorColumn(name = "dtype")
// single table 전략 사용시 필요한 어노테이션.
// 각 엔티티를 구분하기 위해 사용된다.
@Getter @Setter
public abstract class Item {    // 추상클래스 : 상속관계 매핑활용
    @Id @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;


}
