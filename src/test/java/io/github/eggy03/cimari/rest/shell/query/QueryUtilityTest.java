/*
 * SPDX-License-Identifier: MIT
 * SPDX-FileCopyrightText: 2026 The ferrumx-windows contributors
 * SPDX-FileCopyrightText: 2026 Cimari contributors
 */
package io.github.eggy03.cimari.rest.shell.query;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.eggy03.cimari.rest.annotation.WmiClass;
import io.github.eggy03.cimari.rest.exception.AnnotationNotFoundException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class QueryUtilityTest {

    @Test
    void getWmiClassNameFromWmiClassAnnotation_success() {
        String expectedString = "testClass";
        String actualString = QueryUtility.getClassNameFromWmiClass(MockWmiAnnotatedClass.class);

        assertThat(expectedString).isEqualTo(actualString);
    }

    @Test
    void getWmiClassNameFromWmiClassAnnotation_nonAnnotatedClass_throwsException() {

        assertThrows(
                AnnotationNotFoundException.class,
                () -> QueryUtility.getClassNameFromWmiClass(MockNonWmiAnnotatedClass.class)
        );
    }

    @Test
    void getPropertiesFromJsonProperty_withAnnotatedFields_success() {

        String expectedString = "method_one, method_three, method_two";
        String actualString = QueryUtility.getPropertiesFromJsonProperty(MockWithAnnotatedFields.class);

        assertThat(expectedString).isEqualTo(actualString);
    }

    @Test
    void getPropertiesFromJsonProperty_withoutAnnotatedFields_returnsEmptyString() {

        String expectedString = "";
        String actualString = QueryUtility.getPropertiesFromJsonProperty(MockWithoutAnnotatedFields.class);

        assertThat(expectedString).isEqualTo(actualString);
    }

    @Test
    void getPropertiesFromJsonProperty_withEmptyClass_success_emptyString() {

        String actualString = QueryUtility.getPropertiesFromJsonProperty(MockEmptyClass.class);
        assertThat(actualString).isNotNull().isEmpty();
    }

    @Test
    void getFromJsonProperties_withAnnotatedFields_inheritedPropertiesFromAnotherClass_success() {

        String expectedString = "method_four"; // inherited methods are not included
        String actualString = QueryUtility.getPropertiesFromJsonProperty(ExtensionOfMockWithAnnotatedFields.class);

        assertThat(expectedString).isEqualTo(actualString);
    }

    @Test
    @SuppressWarnings("all")
    void testBothFieldsForNullInputs_throwsException() {
        NullPointerException ex1 = assertThrows(NullPointerException.class, () -> QueryUtility.getClassNameFromWmiClass(null));
        NullPointerException ex2 = assertThrows(NullPointerException.class, () -> QueryUtility.getPropertiesFromJsonProperty(null));
        assertThat(ex1.getMessage()).isEqualTo("tClass is marked non-null but is null");
        assertThat(ex2.getMessage()).isEqualTo("tClass is marked non-null but is null");
    }

    // inner test class where fields are annotated with Jackson's @JsonProperty
    @SuppressWarnings("unused")
    static class MockWithAnnotatedFields {

        @JsonProperty("method_one")
        public String methodOne;

        @JsonProperty("method_two")
        public String methodTwo;

        @JsonProperty("method_three")
        public String methodThree;
    }

    @SuppressWarnings("unused")
    static class MockWithoutAnnotatedFields {

        public String methodOne;

        public String methodTwo;

        public String methodThree;
    }

    static class MockEmptyClass {

    }

    @SuppressWarnings("unused")
    static class ExtensionOfMockWithAnnotatedFields extends MockWithAnnotatedFields {

        @JsonProperty("method_four")
        public String methodFour;
    }

    @SuppressWarnings("unused")
    @WmiClass(className = "testClass")
    static class MockWmiAnnotatedClass {

    }

    @SuppressWarnings("unused")
    static class MockNonWmiAnnotatedClass {

    }
}
