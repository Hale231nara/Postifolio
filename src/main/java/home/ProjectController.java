package home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import portfolioRepository.ProjectsRepository;
import projects.Project;

import java.util.List;

@Controller
public class ProjectController {

    @Autowired
    private ProjectsRepository projectsRepository;
// Model é uma interface de framework que passa dados do controlador para a visão.
    @GetMapping("/projects")
    public String Projects(Model model) {
        List<Project> projects = projectsRepository.findAll();
        model.addAttribute("projects", projects);
        return "projects";
    }
    @GetMapping("/project{id}")
    public String projectDatail(@PathVariable Long id, Model model) {
        Project project = projectsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid project id:" + id));
        model.addAttribute("project", project);
        return "project";
    }
    // utilizando esse construtor eu posso adicionar e salvar projeto no meu portfólio.
    @PostMapping("/projects")
    public String addProject(@ModelAttribute Project project){
        projectsRepository.save(project);
        return "redirect:/projects";
    }
}
