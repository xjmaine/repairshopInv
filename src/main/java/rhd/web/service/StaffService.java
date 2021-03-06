package nazeem.web.service;

import java.util.Collections;
import java.util.List;

import nazeem.web.model.Staff;
import nazeem.web.repository.StaffRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StaffService {

    @Autowired
    private StaffRepository repo;

    public List<Staff> listAll() {
        return (List<Staff>) repo.findAll();
    }

    public Page<Staff> findPaginated(String search, Pageable pageable) {
        List<Staff> staffs = repo.searchStaff(search); //repo.findAll();

        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Staff> list;

        if (staffs.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, staffs.size());
            list = staffs.subList(startItem, toIndex);
        }

        Page<Staff> bookPage = new PageImpl<Staff>(list, PageRequest.of(currentPage, pageSize), staffs.size());

        return bookPage;
    }

    public void save(Staff staff) {
        repo.save(staff);
    }

    public Staff get(long id) {
        return repo.findById(id).get();
    }

    public void delete(long id) {
        repo.deleteById(id);
    }
}