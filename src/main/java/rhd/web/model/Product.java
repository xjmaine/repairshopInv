package nazeem.web.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="product")
public class Product {

    protected Product() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;
    
    @Column(name = "item_type_id")
    @NotNull(message = "Select Item type!")
    private Integer itemTypeId;
    
    @NotEmpty(message = "Name can't be empty!")
    @Column(name = "name")
    private String name;
    
    @Column(name = "brand")
    private String brand;
    
    @Column(name = "madein")
    private String madein;
    
    @Column(name = "phone")
    private String phone;
    
    @Column(name = "item_description")
    private String item_description;
    
    @Column(name = "date_modified")
    private java.sql.Date  dateModified;
    
    @Column(name = "staff_id")
   	private Long staffId;


    public Long getStaffId() {
		return staffId;
	}
	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}
	public java.sql.Date getDateModified() {
		return dateModified;
	}
	public void setDateModified(java.sql.Date dateModified) {
		this.dateModified = dateModified;
	}
	public String getItem_description() {
		return item_description;
	}
	public void setItem_description(String item_description) {
		this.item_description = item_description;
	}
	public Long getId() {
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }

    

    public Integer getItemTypeId(){
        return this.itemTypeId;
    }
    public void setItemTypeId(Integer itemTypeId){
        this.itemTypeId=itemTypeId;
    }

  

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name=name;
    }

   

    public String getBrand(){
        return this.brand;
    }
    public void setBrand(String brand){
        this.brand=brand;
    }

   

    public String getMadein(){
        return this.madein;
    }
    public void setMadein(String madein){
        this.madein=madein;
    }

   

    public String getPhone(){
        return this.phone;
    }
    public void setPhone(String phone){
        this.phone=phone;
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