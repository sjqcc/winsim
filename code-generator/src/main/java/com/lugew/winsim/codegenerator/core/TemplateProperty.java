package com.lugew.winsim.codegenerator.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * @author LuGew
 * @since 2020/6/1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TemplateProperty {
    private String name;
    private String suffix = ".java";
    private Map<String, Object> parameters;

    public TemplateProperty(String name) {
        this.name = name;
    }

    public TemplateProperty(String name, Map<String, Object> parameters) {
        this.name = name;
        this.parameters = parameters;
    }
}
