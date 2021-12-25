package nazeem.web.model;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="product_type")
public class ProductType {

    protected ProductType() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_type_id")
    private Long id;

    public Long getId() {
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }


    @Column(name = "name")
    @NotEmpty(message = "Name can't be empty!")
    private String name;

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name=name;
    }

    @Column(name = "is_deleted")
    private boolean isDeleted;

    public boolean getIsDeleted(){
        return this.isDeleted;
    }
    public void setIsDeleted(boolean isDeleted){
        this.isDeleted=isDeleted;
    }

    // other getters and setters are hidden for brevity
}