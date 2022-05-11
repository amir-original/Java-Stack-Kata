import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StackTest {
    private Stack stack;

    @BeforeEach
    void init() {
        stack = new Stack(5);
    }

    @Test
    void newly_created_stacks_should_be_empty() {
        assertThat(stack.getSize()).isEqualTo(0);
    }

    @Test
    void after_one_push_stack_size_should_be_one() {
        stack.push("A");
        assertThat(stack.getSize()).isEqualTo(1);
    }

    @Test
    void after_one_push_and_one_pop_stack_should_be_empty() {
        stack.push("A");
        stack.pop();
        assertThat(stack.getSize()).isEqualTo(0);
    }

    @Test
    void When_pushed_passed_limit_throw_stack_overflows_exception() {
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        stack.push("E");
        Assertions.assertThatExceptionOfType(StackOverflowException.class).isThrownBy(()->stack.push("F"));
    }

    @Test
    void When_popped_passed_limit_throw_stack_underflow_exception() {
        stack.push("A");
        stack.push("B");
        stack.pop();
        stack.pop();
        Assertions.assertThatExceptionOfType(StackUnderflowException.class).isThrownBy(()->stack.pop());
    }

    @Test
    void When_two_values_are_pushed_then_one_is_popped_should_stack_size_is_one() {
        stack.push("A");
        stack.push("B");
        stack.pop();
        assertThat(stack.getSize()).isEqualTo(1); 
    }

    @Test
    void When_one_and_two_are_pushed_should_two_and_one_are_popped() {
        stack.push("A");
        stack.push("B");
        stack.pop();
        assertThat(stack.top()).isEqualTo("A");
        stack.pop();
        assertThat(stack.getSize()).isEqualTo(0);
        Assertions.assertThat(stack.isEmpty()).isTrue();
    }

    @Test
    void When_creating_stack_with_negative_size_should_be_throw_IllegalCapacity_Exception() {
       Assertions.assertThatExceptionOfType(StackIllegalCapacityException.class).isThrownBy(()->new Stack(-5));
    }

    @Test
    void When_creating_stack_with_zero_capacity_any_push_should_overflow() {
        Stack stack = new Stack(0);
        Assertions.assertThatExceptionOfType(StackOverflowException.class).isThrownBy(()-> stack.push("A"));
    }

    @Test
    void When_one_is_pushed_should_be_one_is_on_top() {
        stack.push("A");
        assertThat(stack.top()).isEqualTo("A");
        stack.push("B");
        assertThat(stack.top()).isEqualTo("B");
    }

    @Test
    void When_stack_is_empty_top_should_be_throws_empty_exception() {
        stack.push("A");
        stack.pop();
        assertThat(stack.isEmpty()).isTrue();
        assertThatExceptionOfType(StackEmptyException.class).isThrownBy(()->stack.top());
    }

    @Test
    void With_zero_capacity_stack_top_should_be_throws_empty_exception() {
        Stack stack = new Stack(0);
        assertThatExceptionOfType(StackEmptyException.class).isThrownBy(()-> stack.top());
    }

    @Test
    void Given_stack_with_one_two_pushed_should_be_find_one_and_two() {
        stack.push("A");
        stack.push("B");
        assertThat(stack.getElements()).containsExactly("A","B");
    }

    @Test
    void Given_a_stack_with_no_two_find_two_returns_null() {
        stack.push("B");
        assertThat(stack.find("B")).isEqualTo(0);
        assertThat(stack.find("A")).isNull();
    }

    @Test
    void Elements_should_be_unique_in_stack() {
        stack.push("B");
        Assertions.assertThatExceptionOfType(StackUniqueException.class).isThrownBy(()->stack.push("B"));
    }
}
