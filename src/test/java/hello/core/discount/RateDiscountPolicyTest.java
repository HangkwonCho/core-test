package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용됨")
    void vip_o() {
        // given
        Member member = new Member(1L, "vip", Grade.VIP);

        // when
        int discount = discountPolicy.discount(member, 20000);

        // then
        assertThat(discount).isEqualTo(2000);
    }

    @Test
    @DisplayName("VIP가 아닌경우 할인 미적용")
    void vip_x() {

        // given
        Member member = new Member(2L, "basic", Grade.BASIC);

        // when
        int discount = discountPolicy.discount(member, 10000);

        // then
        assertThat(discount).isEqualTo(0);
    }

}