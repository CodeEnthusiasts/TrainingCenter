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
    @GetMapping(value = "/users/{user_id}/user-details")
    public UserDetailsDTO getUserDetailsByUserId(@PathVariable("user_id") Long userId) {
        return userDetailsService.getUserDetailsByUserId(userId);
    }

    @PatchMapping(value = "/user-details/{user_details_id}")
    public UserDetailsDTO updateUserDetails(@PathVariable("user_details_id") Long userDetailsId,
                                            @RequestBody @Valid UserDetailsDTO dto) {
        return userDetailsService.updateUserDetails(userDetailsId, dto);
    }
}
