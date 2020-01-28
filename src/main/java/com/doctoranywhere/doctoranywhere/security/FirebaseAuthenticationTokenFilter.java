package com.doctoranywhere.doctoranywhere.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.doctoranywhere.doctoranywhere.constant.DoctoranywhereConstant;
import com.doctoranywhere.doctoranywhere.util.DataUtils;
import com.google.api.core.ApiFuture;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseToken;

@Component
public class FirebaseAuthenticationTokenFilter extends OncePerRequestFilter {
	
   private static final Logger log=LogManager.getLogger(FirebaseAuthenticationTokenFilter.class);
   
   @Override
   protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
           throws ServletException, IOException {
       HttpServletRequest httpRequest = request;
       String authToken = httpRequest.getHeader(DoctoranywhereConstant.TOKEN_HEADER);
       if (DataUtils.isEmpty(authToken, false)) {
    	   log.info("authToken Empty"+authToken);
           filterChain.doFilter(request, response);
           return;
       }
       try {
           Authentication authentication = getAndValidateAuthentication(authToken);
           SecurityContextHolder.getContext().setAuthentication(authentication);
       } catch (Exception ex) {
    	   log.error("Exception in doFilterInternal"+ex.getStackTrace());
           HttpServletResponse httpResponse = response;
           httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
       }
       log.info("Firebase Authentication"+authToken);
       filterChain.doFilter(request, response);
   }

  private Authentication getAndValidateAuthentication(String authToken) throws InterruptedException, ExecutionException  {
       Authentication authentication;
       FirebaseToken firebaseToken = authenticateFirebaseToken(authToken);
       authentication = new UsernamePasswordAuthenticationToken(firebaseToken, authToken, new ArrayList<>());
       return authentication;
   }

    private FirebaseToken authenticateFirebaseToken(String authToken) throws InterruptedException, ExecutionException {
       ApiFuture<FirebaseToken> app = FirebaseAuth.getInstance().verifyIdTokenAsync(authToken);
       return app.get();
   }

   @Override
   public void destroy() {
	   log.info("Destroy FirebaseAuthenticationTokenFilter");
   }

}
