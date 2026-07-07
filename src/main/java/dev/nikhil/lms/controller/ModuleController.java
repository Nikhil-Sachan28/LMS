package dev.nikhil.lms.controller;

import dev.nikhil.lms.dto.requestDTO.CreateModuleRequest;
import dev.nikhil.lms.model.Module;
import dev.nikhil.lms.service.ModuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/modules")
@RequiredArgsConstructor
public class ModuleController {
    private final ModuleService modService;

    @PostMapping
    public Module addModule(@RequestBody CreateModuleRequest module){
        return modService.addModule(module);
    }

    @GetMapping
    public List<Module> getModules(){

        return modService.getModules();
    }

    @DeleteMapping("/{id}")
    public void deleteModule(@PathVariable UUID id){
        modService.deleteModule(id);
    }

}
