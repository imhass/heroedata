package com.example.heroedata;

/*
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for
 * license information.
 */


import com.microsoft.azure.spring.data.cosmosdb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Document(collection = "mycollection")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Hero {
    @Id
    private String id;
    private String name;

    @Override
    public String toString() {
        return String.format("Hero: %s %s", id, name);
    }
}
