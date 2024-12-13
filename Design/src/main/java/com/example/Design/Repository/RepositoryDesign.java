package com.example.Design.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Design.Model.DesignModel;

@Repository
public interface RepositoryDesign extends JpaRepository<DesignModel, Long>{

}
