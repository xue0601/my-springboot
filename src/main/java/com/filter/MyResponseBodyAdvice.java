package com.filter;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @program: my-springboot
 * @description:    response响应过滤(可对前端返回参数做处理)
 * @author: Xue0601
 * @create: 2018-12-10 18:31
 **/
@ControllerAdvice
public class MyResponseBodyAdvice implements ResponseBodyAdvice {

    @Override
    public Object beforeBodyWrite(Object returnValue, MethodParameter methodParameter,
                                  MediaType mediaType, Class clas, ServerHttpRequest serverHttpRequest,
                                  ServerHttpResponse serverHttpResponse) {
        //通过 ServerHttpRequest的实现类ServletServerHttpRequest 获得HttpServletRequest
        //ServletServerHttpRequest sshr=(ServletServerHttpRequest) serverHttpRequest;
        //此处获取到request 是为了取到在拦截器里面设置的一个对象 是我项目需要,可以忽略
        //HttpServletRequest request=   sshr.getServletRequest();

        //将返回值returnValue转成我需要的类型Message<?>  方便统一修改其中的某个属性
        // Messages是我自定义的一个类
//        Messages<?> msg=(Messages<?>) returnValue;
//        System.out.println("修改前");
//        System.out.println(returnValue.toString());
//        System.out.println("修改后");
//        System.out.println(returnValue.toString()+"++++++++++++++++++=============++++++++++++++");
////        统一修改返回值/响应体
//        msg.setXXX("测试修改返回值");
        //返回修改后的值
        return returnValue;
    }

    @Override
    public boolean supports(MethodParameter methodParameter, Class clas) {
        //获取当前处理请求的controller的方法
        String methodName=methodParameter.getMethod().getName();
        // 不拦截/不需要处理返回值 的方法
        String method= "loginCheck"; //如登录
        //不拦截
        return !method.equals(methodName);
    }
}
