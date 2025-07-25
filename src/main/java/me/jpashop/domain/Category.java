package me.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import me.jpashop.domain.item.Item;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Category {
    @Id @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    private String name;

    @ManyToMany // 다대다 관계 : 실무사용 x, 확장성이 좋지 않음. jpa 기능 소개를 위해 구현한 관계.
    @JoinTable(name = "category_item",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private List<Item> items = new ArrayList<>();

    // 계층 관계를 구현한 코드
    // 그냥 다른 엔티티라고 생각하고 연관관계를 연결하면 된다.
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();
}
