package qodous.erp.inventory.security.domain;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationRequest {
    private String userName;
    private String password;
}
