package com.study.edu.inteceptor;

import com.dianping.cat.Cat;
import com.dianping.cat.message.Message;
import com.dianping.cat.message.Transaction;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2018/3/23.
 * 定义拦截器，实现埋点
 */
public class CatInterceptor extends HandlerInterceptorAdapter{
    private ThreadLocal<Transaction> tranLocal = new ThreadLocal<>();
    private ThreadLocal<Transaction> pageLocal = new ThreadLocal<>();
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        Transaction t = Cat.newTransaction("URL",uri);
        Cat.logEvent("URL.Method",request.getMethod(), Message.SUCCESS,request.getRequestURI().toString());
        Cat.logEvent("URL.HOST",request.getMethod(),Message.SUCCESS,request.getRemoteHost());
        tranLocal.set(t);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        String viewName = modelAndView!= null?modelAndView.getViewName():"无";
        Transaction t =Cat.newTransaction("View",viewName);
        pageLocal.set(t);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {

        Transaction pt  = pageLocal.get();
        pageLocal.remove();
        pt.setStatus(Transaction.SUCCESS);
        pt.complete();

        Transaction tt = tranLocal.get();
        tranLocal.remove();
        tt.setStatus(Transaction.SUCCESS);
        tt.complete();
    }
}
