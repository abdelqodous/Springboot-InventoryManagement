package qodous.erp.inventory.configuration;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter{

    private final UserDetailsService userDetailsService;
    private final JwtService jwtService;
    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain) throws ServletException, IOException {

        System.out.println("$$.. doFilterInternal");
        final String authHeader = request.getHeader("Authorization");
        final String jwtToken;
        final String userName;

        if (authHeader == null || !authHeader.startsWith("Bearer ")){
            System.out.println("$$.. authHeader:" +authHeader);
            filterChain.doFilter(request, response);
            return;
        }

        jwtToken = authHeader.substring(7);
        System.out.println("$$.. jwtToken without prefix:" +jwtToken);
        userName = jwtService.extractUserName(jwtToken);
        System.out.println("$$.. userName:" +userName);

        //abstracting username from jwt token to filter userDetails with it, if not authenticated yet
        if(userName != null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(userName);
            System.out.println("$$.. userDetails:" +userDetails);

            if(jwtService.isTokenValid(jwtToken, userDetails)){
                System.out.println("$$.. Valid token........" );
                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                System.out.println("$$.. authToken: " +authToken);

                authToken.setDetails( new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }

        filterChain.doFilter(request, response);
    }
}
