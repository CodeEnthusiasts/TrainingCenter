package codeenthusiast.TrainingCenterApp.user.details;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/user-details")
public class UserDetailsController {

    private final UDetailsServiceImpl userDetailsService;

    public UserDetailsController(UDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @GetMapping(value = "/{user_id}")
    public UserDetailsDTO getById(@PathVariable("id") Long id) {
        return userDetailsService.findByUserId(id);
    }

    @PatchMapping(value = "/{id}")
    public UserDetailsDTO update(@PathVariable("id") Long id,
                                 @RequestBody @Valid UserDetailsDTO dto) {
        return userDetailsService.update(id, dto);
    }
}
