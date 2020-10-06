package com.xdj.interfaces.mallinterface.security;



import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.xdj.interfaces.mallinterface.util.TokenUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 *
 * @author xinshengshu
 * @date 2018/9/25
 */
@Component
public class SuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    private final TokenUtils tokenUtils;

    private final ObjectMapper objectMapper;

    private final JsonNodeFactory jsonNodeFactory;

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    public SuccessHandler(TokenUtils tokenUtils) {
        this.tokenUtils = tokenUtils;
        this.objectMapper = new ObjectMapper();
        this.jsonNodeFactory = JsonNodeFactory.instance;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        logger.info("----auth-success-------{}",authentication.getName());
        logger.info(authentication.getName());
        response.setStatus(HttpStatus.OK.value());
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        try (Writer writer = response.getWriter()){
            JsonNode jsonNode = jsonNodeFactory.objectNode()
                .put("token",tokenUtils.generateToken(authentication));
            objectMapper.writeValue(writer,jsonNode);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
