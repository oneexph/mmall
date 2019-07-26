package org.mmall.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理
 */
@Slf4j
@Component
public class ExceptionResolver implements HandlerExceptionResolver{

    /**
     *
     * <pre>
     *     {
     *          "msg": "接口异常,详情请查看服务端日志的异常信息",
     *          "data": "java.lang.ArithmeticException: / by zero",
     *          "status": 1
     *     }
     * </pre>
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        log.error("{} Exception", httpServletRequest.getRequestURI(), e);

        //当使用是jackson2.x的时候使用MappingJackson2JsonView，本项目中使用的是1.9。
        ModelAndView modelAndView = new ModelAndView(new MappingJacksonJsonView());
        modelAndView.addObject("status",ResponseCode.ERROR.getCode());
        modelAndView.addObject("msg","接口异常,详情请查看服务端日志的异常信息");
        modelAndView.addObject("data",e.toString());
        return modelAndView;
    }

}