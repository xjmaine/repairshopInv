package nazeem.web.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import nazeem.web.model.Staff;

public interface StaffRepository extends JpaRepository<Staff, Long> {
    @Query("select s from Staff s " +
            //"join p.productType pt " +
            "where 1=1" +
            "and ( upper(s.staffName) like concat('%', upper(?1), '%') " + 
            "       or upper(s.staffSkills) like concat('%', upper(?1), '%') " +
            "       or upper(s.staffStatus) like concat('%', upper(?1), '%')" +
            //"       or upper(pt.name) like concat('%', upper(?1), '%')" +
            ")")
    List<Staff> searchStaff(String criteria); 
}