package my;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.CLASS)
@Inherited
@Documented
public @interface Version {
	int major() default 1; // 主版本号

	int minor() default 0; // 子版本号

}