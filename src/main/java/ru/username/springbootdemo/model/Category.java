package ru.username.springbootdemo.model;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "categories")
public class Category {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   @OneToMany(mappedBy= "category",cascade = CascadeType.ALL)
   @ToString.Exclude
   private List<Product> products;
    @OneToMany(mappedBy= "category",cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Option> options;
   @Column(name = "name")
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Category category = (Category) o;
        return id != null && Objects.equals(id, category.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
