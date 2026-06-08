package vn.hoidanit.laptopshop.repository;
import vn.hoidanit.laptopshop.domain.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    // User save(User bao); Không cần nữa vì Jpa đã có sẵn hàm save()
    List<User> findByEmail(String email);
}
