package org.giovanni.MicroServicesMacroGains;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
class MemberController {
    private final MemberRepository repository;
    private final MemberModelAssembler assembler;

    public MemberController(MemberRepository repository, MemberModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    @GetMapping("/members")
    CollectionModel<EntityModel<Member>> all() {
        List<EntityModel<Member>> members = repository.findAll().stream()
                .map(assembler::toModel)
                .toList();

        return CollectionModel.of(members, linkTo(methodOn(MemberController.class).all()).withSelfRel());
    }

    @GetMapping("/members/{id}")
    EntityModel<Member> one (@PathVariable Long id) {
        Member member = repository.findById(id)
                .orElseThrow(() -> new MemberNotFoundException(id));

        return assembler.toModel(member);
    }

    @PostMapping("/members/new")
    ResponseEntity<?> newMember (@RequestBody Member newMember) {
        EntityModel<Member> entityModel = assembler.toModel(repository.save(newMember));

        return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }

    @DeleteMapping("/members/{id}")
    ResponseEntity<?> deleteMember(@PathVariable Long id) {
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/members/{id}")
    ResponseEntity<?> replaceMember(@RequestBody Member newMember, @PathVariable Long id) {
        Member updateMember = repository.findById(id)
                .map(member -> {
                    member.setName(newMember.getName());
                    member.setGenderChoice(newMember.getGenderChoice());
                    member.setGender(newMember.getGenderChoice().getOpt());
                    member.setHeight(newMember.getHeight());
                    member.setWeight(newMember.getWeight());
                    member.setBodyFatPercent(newMember.getBodyFatPercent());
                    member.setRegistrationDate(newMember.getRegistrationDate());
                    member.setActive(newMember.isActive());
                    return repository.save(member);
                })
                .orElseGet(() -> {
                    newMember.setId(id);
                    return repository.save(newMember);
                });

        EntityModel<Member> entityModel = assembler.toModel(updateMember);

        return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);

    }

}
