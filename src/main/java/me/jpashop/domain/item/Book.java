package me.jpashop.domain.item;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("B")
// 이 어노테이션의 값을 따로 지정하지 않을 경우 디폴트값은 클래스 이름인 "Book"이다.
@Getter
@Setter
public class Book extends Item{

    private String author;
    private String isbn;

}
