package com.nathan.pet.PomofocusClone.api.assemblers;

import com.nathan.pet.PomofocusClone.api.controllers.UserController;
import com.nathan.pet.PomofocusClone.api.models.User;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class UserModelAssembler implements RepresentationModelAssembler<User, EntityModel<User>> {

  @Override
  public EntityModel<User> toModel(User user) {
    EntityModel<User> entityModel = EntityModel.of(user,
        linkTo(methodOn(UserController.class).all()).withRel("users"),
        linkTo(methodOn(UserController.class).one(user.getId())).withSelfRel());

    return entityModel;
  }
}
