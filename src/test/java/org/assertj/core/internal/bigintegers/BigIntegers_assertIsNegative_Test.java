/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright 2012-2020 the original author or authors.
 */
package org.assertj.core.internal.bigintegers;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.test.TestData.someInfo;

import java.math.BigInteger;

import org.assertj.core.api.AssertionInfo;
import org.assertj.core.internal.BigIntegers;
import org.assertj.core.internal.BigIntegersBaseTest;
import org.junit.jupiter.api.Test;

/**
 * Tests for <code>{@link BigIntegers#assertIsNegative(AssertionInfo, BigInteger)}</code>.
 */
public class BigIntegers_assertIsNegative_Test extends BigIntegersBaseTest {

  @Test
  public void should_succeed_since_actual_is_negative() {
    numbers.assertIsNegative(someInfo(), new BigInteger("-1"));
  }

  @Test
  public void should_fail_since_actual_is_not_negative() {
    assertThatExceptionOfType(AssertionError.class).isThrownBy(() -> numbers.assertIsNegative(someInfo(), BigInteger.ONE))
                                                   .withMessage(format("%nExpecting:%n <1>%nto be less than:%n <0> "));
  }

  @Test
  public void should_fail_since_actual_is_zero() {
    assertThatExceptionOfType(AssertionError.class).isThrownBy(() -> numbers.assertIsNegative(someInfo(), BigInteger.ZERO))
                                                   .withMessage(format("%nExpecting:%n <0>%nto be less than:%n <0> "));
  }

  @Test
  public void should_succeed_since_actual_is_negative_according_to_custom_comparison_strategy() {
    numbersWithComparatorComparisonStrategy.assertIsNegative(someInfo(), new BigInteger("-1"));
  }

  @Test
  public void should_fail_since_actual_is_not_negative_according_to_custom_comparison_strategy() {
    assertThatExceptionOfType(AssertionError.class).isThrownBy(() -> numbersWithComparatorComparisonStrategy.assertIsNegative(someInfo(), BigInteger.ONE))
                                                   .withMessage(format("%nExpecting:%n <1>%nto be less than:%n <0> when comparing values using BigIntegerComparator"));
  }

}
