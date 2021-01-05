package codeenthusiast.TrainingCenterApp.user.details;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController(value = "/api")
public class UserDetailsController {

    private final UDetailsServiceImpl userDetailsService;

    public UserDetailsController(UDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @PreAuthorize("authentication.principal.id == #userId")
    @GetMapping(value = "/users/{user_id}/user-details")
    public ResponseEntity<UserDetailsDTO> getUserDetailsByUserId(@PathVariable("user_id") Long userId) {
        return ResponseEntity.ok(userDetailsService.getUserDetailsByUserId(userId));
    }

    @PatchMapping(value = "/user-details/{user_details_id}")
    public ResponseEntity<UserDetailsDTO> updateUserDetails(@PathVariable("user_details_id") Long userDetailsId,
                                                            @RequestBody @Valid UserDetailsDTO dto) {
        return ResponseEntity.ok(userDetailsService.updateUserDetails(userDetailsId, dto));
    }
}
