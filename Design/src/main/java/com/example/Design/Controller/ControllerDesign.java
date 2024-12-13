package com.example.Design.Controller;

import java.beans.DesignMode;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.Design.Dto.Dto;
import com.example.Design.Model.DesignModel;
import com.example.Design.Repository.RepositoryDesign;


import jakarta.validation.Valid;

@RestController
@RequestMapping("/design")
public class ControllerDesign {
	
	@Autowired 
	RepositoryDesign repo;
	
	@GetMapping
	public ResponseEntity<?> GetDesign(){
		List<DesignModel> lista = repo.findAll();
				return ResponseEntity.ok(lista);
		}
	
	@PostMapping
	public ResponseEntity<?> PostDesign(@RequestBody @Valid Dto design){
		DesignModel newDesign = new DesignModel (design);
		repo.save(newDesign);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> PutDesign (@PathVariable ("id") Long id, @RequestBody  @Valid Dto design){
Optional<DesignModel>  optionalDesing = repo.findById(id);
		
		if (optionalDesing.isPresent()) {
			DesignModel desing = optionalDesing.get();
			desing.setCriador(design.criador());
			desing.setNome(design.nome());
			desing.setDescricao(design.descricao());
			desing.setTipo(design.tipo());
			repo.save(desing);
		    return ResponseEntity.ok(desing);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity DeleteDesign(@PathVariable Long id) {
		repo.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}