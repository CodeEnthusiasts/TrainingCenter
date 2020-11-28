package codeenthusiast.TrainingCenterApp.security;

import codeenthusiast.TrainingCenterApp.constants.ERole;
import codeenthusiast.TrainingCenterApp.exceptions.EntityAlreadyExistsException;
import codeenthusiast.TrainingCenterApp.exceptions.EntityNotFoundException;
import codeenthusiast.TrainingCenterApp.security.jwt.JwtUtils;
import codeenthusiast.TrainingCenterApp.security.request.LoginRequest;
import codeenthusiast.TrainingCenterApp.security.request.SignUpRequest;
import codeenthusiast.TrainingCenterApp.security.response.JwtResponse;
import codeenthusiast.TrainingCenterApp.security.response.MessageResponse;
import codeenthusiast.TrainingCenterApp.security.services.UserDetailsImpl;
import codeenthusiast.TrainingCenterApp.user.major.UserRepository;
import codeenthusiast.TrainingCenterApp.user.role.Role;
import codeenthusiast.TrainingCenterApp.user.role.RoleRepository;
import codeenthusiast.TrainingCenterApp.user.role.User;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;

    private final JwtUtils jwtUtils;

    private final PasswordEncoder encoder;

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    public AuthService(AuthenticationManager authenticationManager,
                       JwtUtils jwtUtils, UserRepository userRepository,
                       RoleRepository roleRepository, PasswordEncoder encoder) {
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.encoder = encoder;
    }

    public JwtResponse authenticateUser(LoginRequest loginRequest) {

        Authentication authentication = createUsernamePasswordAuthenticationToken(loginRequest);

        setAuthentication(authentication);

        String jwt = generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        List<String> roles = createNamesOfRoles(userDetails);

        return new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles);
    }

    public Authentication createUsernamePasswordAuthenticationToken(LoginRequest loginRequest) {
        return authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
    }

    public void setAuthentication(Authentication authentication) {
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    public String generateJwtToken(Authentication authentication) {
        return jwtUtils.generateJwtToken(authentication);
    }

    public List<String> createNamesOfRoles(UserDetails userDetails) {

        return userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
    }

    public MessageResponse registerUser(SignUpRequest signUpRequest) {

        validateRequest(signUpRequest);

        User user = createNewUserAccount(signUpRequest);

        assignUserRole(user);

        userRepository.save(user);

        return new MessageResponse("User registered successfully!");
    }

    public void validateRequest(SignUpRequest signUpRequest) {

        String username = signUpRequest.getUsername();
        if (userRepository.existsByUsername(username)) {
            throw new EntityAlreadyExistsException(username);
        }

        String email = signUpRequest.getEmail();
        if (userRepository.existsByEmail(email)) {
            throw new EntityAlreadyExistsException(email);
        }

        if (!signUpRequest.getPassword().equals(signUpRequest.getConfirmPassword())) {
            throw new RuntimeException("Passwords are different");
        }
    }

    public User createNewUserAccount(SignUpRequest signUpRequest) {
        short s = 0;
        return new User(signUpRequest.getUsername(), encoder.encode(signUpRequest.getPassword()),
                signUpRequest.getEmail());
    }

//     User generator //
//    @EventListener(ApplicationReadyEvent.class)
//    public void addUser() {
//        Role role = new Role(ERole.ROLE_USER);
//        roleRepository.save(role);
//    }

    public void assignUserRole(User user) {
        List<Role> defaultRoles = new ArrayList<>();
        defaultRoles.add(roleRepository.findByName(ERole.ROLE_USER)
                .orElseThrow(() -> new EntityNotFoundException("Basic USER role is not created yet")));
        user.setRoles(defaultRoles);
    }

}
