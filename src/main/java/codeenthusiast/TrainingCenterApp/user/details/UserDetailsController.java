package codeenthusiast.TrainingCenterApp.user.details;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserDetailsController {

    private final UDetailsServiceImpl userDetailsService;

    public UserDetailsController(UDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @PreAuthorize("authentication.principal.id == #userId")
    @GetMapping(value = "/users/{user_id}/user_details")
    public UserDetailsDTO getByUserId(@PathVariable("user_id") Long userId) {
        return userDetailsService.findByUserId(userId);
    }

    @PatchMapping(value = "/user_details/{user_details_id}")
    public UserDetailsDTO update(@PathVariable("user_details_id") Long userDetailsId,
                                 @RequestBody @Valid UserDetailsDTO dto) {
        return userDetailsService.updateUserDetails(userDetailsId, dto);
    }
}
