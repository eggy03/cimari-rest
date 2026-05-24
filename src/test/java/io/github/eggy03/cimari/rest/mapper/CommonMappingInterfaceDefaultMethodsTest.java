/*
 * SPDX-License-Identifier: MIT
 * SPDX-FileCopyrightText: 2025 The ferrumx-windows contributors
 * SPDX-FileCopyrightText: 2026 Cimari contributors
 */
package io.github.eggy03.cimari.rest.mapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.github.eggy03.cimari.rest.exception.MappingException;
import io.github.eggy03.cimari.rest.mapping.CommonMappingInterface;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CommonMappingInterfaceDefaultMethodsTest {

    private final CommonMappingInterface<MockEntity> mapper = new CommonMappingInterface<>() {
    };
    private final ObjectMapper objectMapper = mapper.getObjectMapper();

    // MAP TO OBJECT TESTS

    @Test
    void testMapToObject_validJsonObject_matchesSchema_returnsMockEntityWithNonNullFields() throws JsonProcessingException {

        // construct a MockEntity object
        MockEntity constructedMockEntity = new MockEntity(1L, "SomeValue");

        // manually construct json
        ObjectNode mockEntityJsonObject = objectMapper.createObjectNode();
        mockEntityJsonObject.put("ID", 1L);
        mockEntityJsonObject.put("Value", "SomeValue");

        // get it as string
        String mockEntityJson = objectMapper.writeValueAsString(mockEntityJsonObject);

        // deserialize it
        Optional<MockEntity> deserializedMockEntity = mapper.mapToObject(mockEntityJson, MockEntity.class);

        // assert that the deserialization was a success
        assertThat(deserializedMockEntity).contains(constructedMockEntity);
    }

    @Test
    void testMapToObject_validJsonObject_doesNotMatchSchema_throwsMappingException() {

        String json = "{\"a\" : \"1\" , \"b\" : \"2\"}";
        assertThrows(MappingException.class, ()->mapper.mapToObject(json, MockEntity.class));
    }

    @Test
    void testMapToObject_validJsonType_butIsNotObject_throwsIllegalArgumentException() {
        String stringToken = "\"json string\"";
        assertThrows(MappingException.class, () -> mapper.mapToObject(stringToken, MockEntity.class));

        String nullToken = "null";
        assertThrows(MappingException.class, () -> mapper.mapToObject(nullToken, MockEntity.class));

        String trueToken = "true";
        assertThrows(MappingException.class, () -> mapper.mapToObject(trueToken, MockEntity.class));

        String falseToken = "false";
        assertThrows(MappingException.class, () -> mapper.mapToObject(falseToken, MockEntity.class));

        String jsonArray = "[{\"a\" : \"1\" , \"b\" : \"2\"}, {\"c\" : \"3\" , \"d\" : \"4\"}]";
        assertThrows(MappingException.class, () -> mapper.mapToObject(jsonArray, MockEntity.class));
    }

    @Test
    void testMapToObject_invalidJsonType_throwsJacksonException() {
        String invalidJson = "invalid json string";
        assertThrows(MappingException.class, () -> mapper.mapToObject(invalidJson, MockEntity.class));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "   "})
    void testMapToObject_emptyOrWhiteSpaceJsonString_optionalNotPresent(String json) {
        Optional<MockEntity> deserializedMockEntity = mapper.mapToObject(json, MockEntity.class);
        assertThat(deserializedMockEntity).isNotPresent();
    }

    @Test
    @SuppressWarnings("all")
    void testMapToObject_nullParameters_throwsException() {
        NullPointerException ex1 = assertThrows(NullPointerException.class, () -> mapper.mapToObject(null, MockEntity.class));
        NullPointerException ex2 = assertThrows(NullPointerException.class, () -> mapper.mapToObject("", null));
        assertThat(ex1.getMessage()).isEqualTo("inputJson is marked non-null but is null");
        assertThat(ex2.getMessage()).isEqualTo("objectClass is marked non-null but is null");
    }


    // MAP TO LIST TESTS

    @Test
    void testMapToList_validJsonArray_returnsListOfMockEntitiesWithNonNullFields() throws JsonProcessingException {

        // construct two MockEntity objects
        MockEntity constructedMockEntityOne = new MockEntity(1L, "SomeValue");
        MockEntity constructedMockEntityTwo = new MockEntity(2L, "AnotherValue");

        // construct json
        ArrayNode rootArray = objectMapper.createArrayNode();

        ObjectNode mockEntityJsonObjectOne = objectMapper.createObjectNode();
        mockEntityJsonObjectOne.put("ID", 1L);
        mockEntityJsonObjectOne.put("Value", "SomeValue");

        ObjectNode mockEntityJsonObjectTwo = objectMapper.createObjectNode();
        mockEntityJsonObjectTwo.put("ID", 2L);
        mockEntityJsonObjectTwo.put("Value", "AnotherValue");

        rootArray.add(mockEntityJsonObjectOne);
        rootArray.add(mockEntityJsonObjectTwo);

        String mockEntityJson = objectMapper.writeValueAsString(rootArray);

        List<MockEntity> deserializedEntityList = mapper.mapToList(mockEntityJson, MockEntity.class);
        assertThat(deserializedEntityList).contains(constructedMockEntityOne, constructedMockEntityTwo);

        // test immutability
        assertThrows(UnsupportedOperationException.class, () -> deserializedEntityList.add(null));
    }

    @Test
    void testMapToList_validJsonObject_returnsSingletonListOfMockEntityWithNonNullFields() throws JsonProcessingException {

        // construct one MockEntity object
        MockEntity constructedMockEntity = new MockEntity(1L, "SomeValue");

        // manually construct json
        ObjectNode mockEntityJsonObject = objectMapper.createObjectNode();
        mockEntityJsonObject.put("ID", 1L);
        mockEntityJsonObject.put("Value", "SomeValue");

        // get it as string
        String mockEntityJson = objectMapper.writeValueAsString(mockEntityJsonObject);

        List<MockEntity> deserializedEntityList = mapper.mapToList(mockEntityJson, MockEntity.class);
        assertThat(deserializedEntityList)
                .hasSize(1)
                .contains(constructedMockEntity);
    }

    @Test
    void testMapToList_validJsonArrayOrObject_doesNotMatchSchema_throwsMappingException() {
        String jsonArray = "[{\"a\" : \"1\" , \"b\" : \"2\"}, {\"c\" : \"3\" , \"d\" : \"4\"}]";
        String jsonObject = "{\"a\" : \"1\" , \"b\" : \"2\"}";

        assertThrows(MappingException.class, ()-> mapper.mapToList(jsonArray, MockEntity.class));
        assertThrows(MappingException.class, ()-> mapper.mapToList(jsonObject, MockEntity.class));
    }

    @Test
    void testMapToList_validJsonType_butIsNotArrayOrObject_throwsIllegalArgumentException() {
        String jsonString = "\"json string\"";
        assertThrows(MappingException.class, () -> mapper.mapToList(jsonString, MockEntity.class));

        String nullToken = "null";
        assertThrows(MappingException.class, () -> mapper.mapToList(nullToken, MockEntity.class));

        String trueToken = "true";
        assertThrows(MappingException.class, () -> mapper.mapToList(trueToken, MockEntity.class));

        String falseToken = "false";
        assertThrows(MappingException.class, () -> mapper.mapToList(falseToken, MockEntity.class));
    }

    @Test
    void testMapToList_invalidJsonType_throwsMappingException() {
        String invalidJson = "invalid json string";
        assertThrows(MappingException.class, () -> mapper.mapToList(invalidJson, MockEntity.class));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "   "})
    void testMapToList_emptyOrWhiteSpaceStringJson_emptyList(String json) {
        List<MockEntity> deserializedEntityList = mapper.mapToList(json, MockEntity.class);
        assertThat(deserializedEntityList).isEmpty();

    }

    @Test
    @SuppressWarnings("all")
    void testMapToList_nullParameters_throwsException() {
        NullPointerException ex1 = assertThrows(NullPointerException.class, () -> mapper.mapToList(null, MockEntity.class));
        NullPointerException ex2 = assertThrows(NullPointerException.class, () -> mapper.mapToList("", null));
        assertThat(ex1.getMessage()).isEqualTo("inputJson is marked non-null but is null");
        assertThat(ex2.getMessage()).isEqualTo("objectClass is marked non-null but is null");
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class MockEntity {

        @JsonProperty("ID")
        Long id;

        @JsonProperty("Value")
        String value;

    }
}