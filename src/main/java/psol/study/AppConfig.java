package psol.study;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import psol.study.discount.DiscountPolicy;
import psol.study.discount.RateDiscountPolicy;
import psol.study.member.MemberRepository;
import psol.study.member.MemberService;
import psol.study.member.MemberServiceImpl;
import psol.study.member.MemoryMemberRepository;
import psol.study.order.OrderService;
import psol.study.order.OrderServiceImpl;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
