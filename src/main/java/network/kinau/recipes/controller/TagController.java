package network.kinau.recipes.controller;

import network.kinau.recipes.dto.RecipeDto;
import network.kinau.recipes.dto.TagDto;
import network.kinau.recipes.services.TagService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tags")
public class TagController {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private TagService tagService;

    @GetMapping()
    public List<TagDto> getAllTags() {
        return tagService.getAllTags()
                .stream()
                .map(tag -> modelMapper.map(tag, TagDto.class))
                .toList();
    }
}
