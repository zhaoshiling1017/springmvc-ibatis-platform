package com.ducetech.api.security;

import java.lang.annotation.*;

/**
 * 忽略安全性检查
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface IgnoreSecurity {
}
