package com.quanxiaoha.xiaohashu.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
public class ThreadPoolConfig {

    @Bean(name = "taskExecutor")
    public Executor taskExecutor() {

        // 创建一个 ThreadPoolTaskExecutor 实例。ThreadPoolTaskExecutor 是 Spring 提供的一个方便的线程池封装类，基于 JDK 的 ThreadPoolExecutor 实现。
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

        // 核心线程数
        // 设置核心线程池的大小。核心线程池的线程数是线程池的基本大小，这些线程会一直存在，即使它们处于空闲状态。这里设置为 10，意味着最少会有 10 个线程一直存活。
        executor.setCorePoolSize(10);

        // 最大线程数
        // 设置线程池最大线程数。这个值表示线程池中允许创建的最大线程数。当核心线程池的线程都在忙时，会创建新的线程来处理任务，但不会超过这个最大值。这里设置为 50
        executor.setMaxPoolSize(50);

        // 队列容量
        // 设置队列的容量。任务队列用于保存等待执行的任务。这里设置为 200，意味着如果所有核心线程都在工作，新任务会被放在这个队列中等待执行，直到队列满为止。
        executor.setQueueCapacity(200);

        // 线程活跃时间（秒）
        // 设置线程的空闲时间。当线程池中线程数大于核心线程数时，多余的空闲线程的存活时间，超过这个时间会被销毁。这里设置为 30 秒。
        executor.setKeepAliveSeconds(30);

        // 线程名前缀
        // 设置线程名称的前缀。设置后，线程池中的线程名称会以这个前缀开头，便于在调试和监控时识别这些线程。
        executor.setThreadNamePrefix("AuthExecutor-");

        // 拒绝策略：由调用线程处理（一般为主线程）
        // 设置拒绝策略。当线程池达到最大线程数并且队列已满时，任务会被拒绝。CallerRunsPolicy 是一种拒绝策略，它会将任务返回给调用者线程执行，避免任务丢失。
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        // 等待所有任务结束后再关闭线程
        // 设置线程池在关闭时是否等待所有任务完成。设置为 true，意味着线程池会等待所有任务完成再关闭。
        executor.setWaitForTasksToCompleteOnShutdown(true);

        // 设置等待时间，如果超过这个时间还没有销毁就强制销毁，以确保应用最后能够被关闭，而不是被没有完成的任务阻塞
        // 设置线程池在关闭时等待任务完成的最大时间。这里设置为 60 秒，超过这个时间后，线程池会强制关闭，即使有任务未完成。
        executor.setAwaitTerminationSeconds(60);

        executor.initialize();
        return executor;
    }
}
