package com.mes.system.controller;

import com.mes.common.Result;
import com.mes.security.JwtUtil;
import com.mes.system.dto.LoginDTO;
import com.mes.system.entity.SysUser;
import com.mes.system.service.SysUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private SysUserService userService;

    @PostMapping("/login")
    public Result<Map<String, Object>> login(@Valid @RequestBody LoginDTO dto) {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword()));
        Map<String, Object> claims = new HashMap<>();
        claims.put("username", dto.getUsername());
        String token = jwtUtil.generateToken(dto.getUsername(), claims);
        SysUser user = userService.getByUsername(dto.getUsername());
        Map<String, Object> data = new HashMap<>();
        data.put("token", token);
        data.put("user", user);
        return Result.success(data);
    }

    @GetMapping("/info")
    public Result<SysUser> info(@RequestParam String username) {
        return Result.success(userService.getByUsername(username));
    }
}
